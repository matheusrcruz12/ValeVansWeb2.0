package api.modelo;
/**
 *@author Matheus Rodrigues
 * 
 */
public class Usuario extends Identificador {
	private Long id;
	private String nome;
	private String senha;
	private String email;
	private static Usuario usuarioUniqueInstance = null;
	
	public Usuario() {}
	// designer patterns singleton
	public static Usuario getInstance() {
		if(usuarioUniqueInstance == null)
			usuarioUniqueInstance = new Usuario();
		return usuarioUniqueInstance;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
