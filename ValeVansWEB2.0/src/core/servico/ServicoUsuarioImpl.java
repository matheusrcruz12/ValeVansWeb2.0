package core.servico;

import java.util.ArrayList;
import java.util.List;


import api.dao.UsuarioDAO;

import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.dao.UsuarioDAOMySQLDB;


public class ServicoUsuarioImpl implements ServicoUsuario {

	@Override
	public Usuario insert(Usuario usuario) {

		UsuarioDAO uDao = new UsuarioDAOMySQLDB();
		uDao.insert(usuario);
		return null;
	}

	@Override
	public Usuario findByEmail(String emailUsuario) {
		UsuarioDAO uDao = new UsuarioDAOMySQLDB();
		
		Usuario usu = uDao.findByEmail(emailUsuario);
		
		return usu;
	}

}
/*   @Override
    public Usuario insert(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findByNomeUsuario(String nomeUsuario) {
    	
        UsuarioDAO uDao = new UsuarioDAOMariaDB10();
        
        UsuarioPapelDAO upDao = new UsuarioPapelDAOMariaDB10();
        
        PapelDAO pdao = new PapelDAOMariaDB10();
        
        Usuario u = uDao.findByNomeUsuario(nomeUsuario);
        
        List<Long> idPapeis = upDao.findByUsuario(u);
        
        List<Papel> papeis = new ArrayList();
        
        for ( Long id: idPapeis){
        	
            papeis.add(pdao.findById(id));
            
        }
        u.setPapeis(papeis);
        
        return u;
    }    */