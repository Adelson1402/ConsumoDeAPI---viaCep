package com.buscaCep.buscaCep.consume;



import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.buscaCep.buscaCep.model.ViaCepEntity;


@Controller
public class ViaCepController {
 
	Scanner scan = new Scanner(System.in);
	
	@RequestMapping(value="/showcep")
	public String showcep() {
		return "showcep";
		
	}
	
	
	



@RequestMapping(value="/showcepp")
public ModelAndView consumeAPI(HttpServletRequest request, HttpServletResponse response ) throws IOException {
	
//Pega os parametros do front e os trata
	response.getWriter().append("").append(request.getContextPath());
	String cep = request.getParameter("cxCep");
	
//inicia o RestTemplate e envia os devidos valores à URL	
	RestTemplate template = new RestTemplate();
	ModelAndView mvc = new ModelAndView("showcep");
	//viacep.com.br/ws/01001000/json/
	//System.out.println("digite o cep");
	//cep = scan.next();
	
	UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("viacep.com.br/ws")
			.path( cep.toString() + "/json")
			.build();
	
	ResponseEntity<ViaCepEntity> vceEntity = template.getForEntity(uri.toString(), ViaCepEntity.class);
	String cepRua = vceEntity.getBody().getLogradouro();
	String cepBairro = vceEntity.getBody().getBairro();
	String cepCidade = vceEntity.getBody().getLocalidade();
	if(cepRua == null) {
	  cepRua = "Esse Cep é inválido! tente outro, por favor.";
	  cepBairro = "Não encontrado";
	  cepCidade = "Não encontrado";
		
	}
	mvc.addObject("viacepRua", cepRua);
	mvc.addObject("viacepBairro", cepBairro);
	mvc.addObject("viacepCidade", cepCidade);
	System.out.println(vceEntity.getBody().getLogradouro());
	return mvc;
	
	//
	
}

	
}
