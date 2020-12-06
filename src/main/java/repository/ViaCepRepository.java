package repository;

import org.springframework.stereotype.Repository;

import com.buscaCep.buscaCep.model.ViaCepEntity;


public interface ViaCepRepository {

	ViaCepEntity findViaCepEntityByLogradouro(String logradouro);

	ViaCepEntity findAll();
	
}
