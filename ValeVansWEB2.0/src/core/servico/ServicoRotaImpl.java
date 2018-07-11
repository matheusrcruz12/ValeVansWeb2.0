package core.servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import api.modelo.Rota;
import api.modelo.Usuario;
import api.servico.ServicoRota;
import core.dao.RotaDAOMySQLDB;
import core.repositorio.RepositorioRotaImpl;

public class ServicoRotaImpl implements ServicoRota{

    
   	@Override
	public Rota insert(Rota rota) {
   		/*RepositorioRotaImpl repRota = new RepositorioRotaImpl();
   		repRota.insert(rota);*/
		RotaDAOMySQLDB rotaDao = new RotaDAOMySQLDB();
		rotaDao.insert(rota);
		return rota;
	}

	@Override
	public Rota findByInstituicao(String instNome) {
		
		return null;
	}
	public Rota findById(Long id) {
		RotaDAOMySQLDB rotaDao = new RotaDAOMySQLDB();
		
		Rota r = rotaDao.findById(id);
		return r;
	}
	@Override
	public Rota findByBairro(String bairroNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rota findByBairroPerIns(String instNome, String periodo, String bairroNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRota(Rota rotaAtual) {
		RotaDAOMySQLDB rotaDao = new RotaDAOMySQLDB();
		
		rotaDao.update(rotaAtual);
		
	}

	@Override
	public void deleteRota(Rota rotaDelete) {
		RotaDAOMySQLDB rotaDao = new RotaDAOMySQLDB();
		rotaDao.delete(rotaDelete);
		
	}

	@Override
	public List<Rota> findAll() {
		RotaDAOMySQLDB rotaDao = new RotaDAOMySQLDB();
		
		List<Rota> listaRotas = rotaDao.findAll();
		return listaRotas;
	}

}
