package api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author Matheus Rodrigues
 * 
 */
@Entity
@Table(name="rota")
public class Rota extends Identificador{
	@Id
	private Long id;
	
	@Column(name="rota_bairro")
	private String bairroSaida;
	
	@Column(name="rota_inst")
	private String instDestino;
	@Column(name="van_id")
	private int idVan;
	@Column(name="rota_periodo")
	private String periodo;

	
	private static Rota rotaUniqueInstance = null;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	// designer patterns singleton
	public static Rota getInstance() {
		if(rotaUniqueInstance == null)
			rotaUniqueInstance = new Rota();
		return rotaUniqueInstance;
	}
	public Rota() {
		
	}
	public String getBairroSaida() {
		return bairroSaida;
	}
	public void setBairroSaida(String bairroSaida) {
		this.bairroSaida = bairroSaida;
	}
	public String getInstDestino() {
		return instDestino;
	}
	public void setInstDestino(String instDestino) {
		this.instDestino = instDestino;
	}
	public int getIdVan() {
		return idVan;
	}
	public void setIdVan(int idVan) {
		this.idVan = idVan;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
