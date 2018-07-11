package br.com.testes.unitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import api.modelo.Rota;
import api.repositorio.RepositorioRota;
import core.repositorio.RepositorioRotaImpl;

class TesteRotas {

	@Test
	void inserirRotas() {
		RepositorioRota repRota = new RepositorioRotaImpl();
		Rota r = new Rota();
		r.setBairroSaida("Jardim Oriente");
		r.setIdVan(2);
		r.setInstDestino("Fatec");
		r.setPeriodo("Noite");
		
		repRota.insert(r);
		
		fail("Not yet implemented");
	}

}
