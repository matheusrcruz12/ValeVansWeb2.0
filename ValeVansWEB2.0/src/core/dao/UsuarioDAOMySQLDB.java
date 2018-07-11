package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import api.dao.UsuarioDAO;
import api.modelo.Usuario;

public class UsuarioDAOMySQLDB implements UsuarioDAO {
	private Connection conexao;
    
    public UsuarioDAOMySQLDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.mariadb.jdbc.Driver");
            /* Abertura de conexão: */
            /* Notar que poderia ser substituida por
            uma chamada de get instance de uma conexão já aberta. 
            */
            //conexao = DriverManager.getConnection("jdbc:mariadb://172.16.7.63:3306/agenda","usuario", "usuario123"); 
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/valeVansWebBD?" +
                                 "user=root&password=fatec");
            System.out.println("Conectado.. Usuario DAO...");
        } catch (Exception e){
            System.out.print("Erro de conexão...UsuarioDAOMYSQL");
        }
    }
    
	@Override
	public Usuario insert(Usuario usuario) {
		System.out.println("Entrou Met");
		Usuario usu = null;
		try {
			System.out.println("Entrou Try");
			usu = Usuario.getInstance();
			usu = usuario;
			String insertSql = "insert into usuario(usu_nome, usu_email, usu_senha) value(?,?, ?)";

			PreparedStatement insertSQLp = conexao.prepareStatement(insertSql);
			insertSQLp.setString(1, usuario.getNome());
			insertSQLp.setString(2, usu.getEmail());
			insertSQLp.setString(3, usu.getSenha());
			insertSQLp.execute();
			insertSQLp.close();
			conexao.close();
			System.out.println("Cadastrado");
		} catch (Exception e) {
			System.out.println("Deu erro: "+e);
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Long id) {
		/*Usuario u;
		try{        
            PreparedStatement comandoSQLp = conexao.prepareStatement("select * from agenda.usuario where id = ?");  
            comandoSQLp.setString(1, id.toString());
            ResultSet rs = comandoSQLp.executeQuery();
            System.out.println("Conectei..");
            rs.next();
            u = new Usuario();
            u.setId(rs.getLong(1));
            u.setNomeUsuario(rs.getString(2));
            u.setSenha(rs.getString(3));
            u.setNome(rs.getString(4));
            u.setEmail(rs.getString(5));            
            /* Se utilizar o padrão singleton, não fechar a conexão. */
        /*    comandoSQLp.close();
            rs.close();
            //conexao.close();
            return u;
        }           
        catch (Exception e)
        {
          System.out.print("\nErro de conexão...Find by id usuario ");
        }
        return u;*/
		return null;
	}

	@Override
	public Usuario findByNomeUsuario(String  nomeUsuario) {
		return null;
	}

	@Override
	public Usuario findByEmail(String email) {
		Usuario u = null;
		System.out.println("Entrou no metodo");
		try {
			System.out.println("Entrou no try");
			String sqlSelect = "select * from valeVansWebBD.usuario where usu_email = ?";
			PreparedStatement selectSQLp = conexao.prepareStatement(sqlSelect);
			selectSQLp.setString(1, email);
			ResultSet resulSet = selectSQLp.executeQuery();
			System.out.println("Conectei..");
			resulSet.next();
			u = Usuario.getInstance();
			u.setId(Long.parseLong(resulSet.getString(1)));
			u.setNome(resulSet.getString(2));
			u.setEmail(resulSet.getString(3));
			u.setSenha(resulSet.getString(4));
			selectSQLp.close();
			//conexao.close();
			System.out.println("Buscou");
			return u;
			
		} catch (Exception e) {
			System.out.println("Deu erro: "+e);
		}
		return u;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario usuarioAnterior, Usuario usuarioAtual) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
