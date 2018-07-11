package api.dao;

import java.util.List;

import api.modelo.Usuario;

public interface UsuarioDAO {
	
	public Usuario insert(Usuario usuario);
    
    public Usuario findById(Long id);
    
    public Usuario findByNomeUsuario(String nomeUsuario);
    
    public Usuario findByEmail(String email);
    
    public List<Usuario> findAll();
    
    public Usuario update(Usuario usuarioAnterior, Usuario usuarioAtual);
    
    public boolean delete(Usuario usuario);
    
    public boolean delete(Long id);

 
}
