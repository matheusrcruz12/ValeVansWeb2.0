package api.servico;

import java.util.List;

import api.modelo.Rota;

public interface ServicoRota {
	//Inserir nova rota
    public Rota insert(Rota rota);
    //Busca por instituição de destino
    public List<Rota> findAll();
    //Busca por instituição de destino
    public Rota findByInstituicao(String instNome);
    //Busca por bairro de saida
    public Rota findByBairro(String bairroNome);
    //Buscar por rota completa
    public Rota findByBairroPerIns(String instNome, String periodo, String bairroNome);
    // Atualizar uma rota
    public void updateRota(Rota rotaAtual);
    // Deletar uma Rota
    public void deleteRota(Rota rotaDelete);
    
    
}
