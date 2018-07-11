package api.repositorio;

import java.util.List;

import api.modelo.Rota;

public interface RepositorioRota {
	public Rota insert(Rota rota);
	
	public List<Rota> findByInst(String instNome);
	
	public List<Rota> findAll();
	
	public List<Rota> findByInstBairroPer(String instNome, String bairroNome,String periodo);
	
	public Rota updateRota(Rota rotaAnterior, Rota rotaAtual);
	
	public Rota deleteRota(Rota rotaDelete);
	
}
