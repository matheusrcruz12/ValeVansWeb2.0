package api.dao;

import java.util.List;

import api.modelo.Rota;


public interface RotaDAO {
	
	public Rota insert(Rota rota);
    
    public Rota findById(Long id);
    
    public List<Rota> findAll();
    
    public Rota update(Rota rotaAtual);
    
    public boolean delete(Rota rota);
    
    public boolean delete(Long id);   
}
