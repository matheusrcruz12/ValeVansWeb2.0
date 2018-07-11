package br.com.testes.unitarios;

import api.modelo.Rota;
import api.repositorio.RepositorioRota;
import core.repositorio.RepositorioRotaImpl;

public class TesteRotaaa {
	
	public static void main(String[] args) {
		RepositorioRota repRota = new RepositorioRotaImpl();
		Rota r = new Rota();
		r.setBairroSaida("Jardim Oriente");
		r.setIdVan(2);
		r.setInstDestino("Fatec");
		r.setPeriodo("Noite");
		
		repRota.insert(r);
	}

}
