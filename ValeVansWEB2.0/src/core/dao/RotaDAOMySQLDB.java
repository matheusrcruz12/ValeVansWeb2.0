package core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import api.dao.RotaDAO;
import api.modelo.Rota;
import api.modelo.Usuario;

public class RotaDAOMySQLDB implements RotaDAO{
	private Connection conexao;
	 public RotaDAOMySQLDB(){
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
	            System.out.println("Conectado.. Rota DAO...");
	        } catch (Exception e){
	            System.out.print("Erro de conexão...UsuarioDAOMYSQL");
	        }
	    }
	    
		@Override
		public Rota insert(Rota rota) {
	

			try {

				String insertSql = "insert into rota (rota_bairro, rota_inst, rota_periodo, van_id) value(?,?,?,?)";

				PreparedStatement insertSQLp = conexao.prepareStatement(insertSql);
				
				insertSQLp.setString(1, rota.getBairroSaida());
				insertSQLp.setString(2, rota.getInstDestino());
				insertSQLp.setString(3, rota.getPeriodo());
				insertSQLp.setString(4, ""+rota.getIdVan());
				insertSQLp.execute();
				insertSQLp.close();
				conexao.close();
				System.out.println("Cadastrado");
			} catch (Exception e) {
				System.out.println("Deu erro: "+e);
			}
			
			// TODO Auto-generated method stub
			return rota;
		}

	
	@Override
	public Rota findById(Long id) {
		Rota r = null;
		
		List<Rota> lista = findAll();
		
		for(Rota ro: lista) {
			if(ro.getId() == id) {
				r = ro;
				break;
			}
		}
		
		return r;
	}

	@Override
	public List<Rota> findAll() {
		List<Rota> listaRotas = new ArrayList<>();
		try {

			String buscaSql = "select * from rota";
			
			
			PreparedStatement buscaSQLp = conexao.prepareStatement(buscaSql);
			ResultSet resultados = buscaSQLp.executeQuery();
			while(resultados.next()){
				Rota r = new Rota();
				long i = resultados.getInt("rota_id");
				r.setId(i);
				r.setBairroSaida(resultados.getString("rota_bairro"));
				r.setInstDestino(resultados.getString("rota_inst"));
				r.setPeriodo(resultados.getString("rota_periodo"));
				r.setIdVan(resultados.getInt("van_id"));
				listaRotas.add(r);
			}
			
			
			System.out.println("Cadastrado");
		} catch (Exception e) {
			System.out.println("Deu erro: "+e);
		}
		
		return listaRotas;
	}

	@Override
	public Rota update( Rota rotaAtual) {
		try {

			String insertSql = "update rota set rota_bairro = ?, rota_inst = ? , rota_periodo = ? , van_id = ? where rota_id = ?";

			PreparedStatement insertSQLp = conexao.prepareStatement(insertSql);
			
			insertSQLp.setString(1, rotaAtual.getBairroSaida());
			insertSQLp.setString(2, rotaAtual.getInstDestino());
			insertSQLp.setString(3, rotaAtual.getPeriodo());
			insertSQLp.setString(4, ""+rotaAtual.getIdVan());
			insertSQLp.setString(5, ""+rotaAtual.getId());
			insertSQLp.execute();
			insertSQLp.close();
			conexao.close();
			System.out.println("Cadastrado");
		} catch (Exception e) {
			System.out.println("Deu erro: "+e);
		}
		
		// TODO Auto-generated method stub
		return rotaAtual;
	}

	@Override
	public boolean delete(Rota rota) {
		try {

			String insertSql = "delete from rota where rota_id = ?";

			PreparedStatement insertSQLp = conexao.prepareStatement(insertSql);
			insertSQLp.setString(1, ""+rota.getId());
			insertSQLp.execute();
			insertSQLp.close();
			conexao.close();
			System.out.println("Cadastrado");
		} catch (Exception e) {
			System.out.println("Deu erro: "+e);
		}
		
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
