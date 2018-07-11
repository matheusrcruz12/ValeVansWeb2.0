package core.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import api.modelo.Rota;
import api.repositorio.RepositorioRota;

public class RepositorioRotaImpl implements RepositorioRota{
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_simples");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Rota insert(Rota rota) {
		em.getTransaction().begin();
		
		em.persist(rota);
		
		em.getTransaction().commit();
		emf.close();
		return rota;
	}

	@Override
	public List<Rota> findByInst(String instNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rota updateRota(Rota rotaAnterior, Rota rotaAtual) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rota deleteRota(Rota rotaDelete) {
		em.getTransaction().begin();
		
		em.remove(rotaDelete);
		
		em.getTransaction().commit();
		emf.close();
		
		return rotaDelete;
	}

	@Override
	public List<Rota> findAll() {
		em.getTransaction().begin();
		Query cons = em.createQuery("select r from Rota r");
		List<Rota> rotas = cons.getResultList();
		em.getTransaction().commit();
		emf.close();
		return rotas;
	}

	@Override
	public List<Rota> findByInstBairroPer(String instNome, String bairroNome, String periodo) {
		// TODO Auto-generated method stub
		return null;
	}

}
