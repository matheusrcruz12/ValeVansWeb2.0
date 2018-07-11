package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.modelo.Rota;
import api.servico.ServicoRota;
import core.dao.RotaDAOMySQLDB;
import core.servico.ServicoRotaImpl;


@WebServlet("/BuscaRotas")
public class BuscaRotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BuscaRotas() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Rota rota = new Rota();
		String acao = request.getParameter("acao");
		ServicoRotaImpl ServRota = new ServicoRotaImpl();
		
		if(acao!=null && acao.equals("list")) {
			
			
			List<Rota> listaRotas = ServRota.findAll();
			
			request.setAttribute("listaRotas", listaRotas);
			RequestDispatcher saida = request.getRequestDispatcher("listaRotas.jsp");
			saida.forward(request, response);
		}else if(acao!=null && acao.equals("del")) {
			String id = request.getParameter("id");
			rota.setId(Long.parseLong(id));	
			ServRota.deleteRota(rota);
			response.sendRedirect("BuscaRotas?acao=list");
			
		}else if(acao!=null && acao.equals("alt")) {
			String id = request.getParameter("id");
			rota.setId(Long.parseLong(id));	
			Rota r = ServRota.findById(rota.getId());
			
			request.setAttribute("r", r);
			request.getRequestDispatcher("alterarRota.jsp").forward(request, response);
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	       
		try{
			request.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
		
		String id = request.getParameter("id");
		
		String bairro = request.getParameter("bairro");
		String idVan = request.getParameter("idVan");
		String inst = request.getParameter("instituicao");
		String periodo = request.getParameter("periodo");
		System.out.println("id"+id+"b: "+bairro+" id: "+idVan+" inst: "+inst+" per: "+periodo);
		Rota rota = new Rota();
		long idL = Long.parseLong(id);
		System.out.println(idL);
		rota.setId(idL);
		rota.setBairroSaida(bairro);
		rota.setIdVan(Integer.parseInt(idVan));
		rota.setInstDestino(inst);
		rota.setPeriodo(periodo);
		System.out.println("id"+rota.getId()+"b: "+bairro+" id: "+idVan+" inst: "+inst+" per: "+periodo);
		
		if(bairro!= null && idVan!=null && inst!= null && periodo!= null){
			ServicoRota sRota = new ServicoRotaImpl();
			
			sRota.updateRota(rota);
			System.out.println("Atualizando");
			
			try {
				response.sendRedirect("BuscaRotas?acao=list");
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			request.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		}
		
	}

}
