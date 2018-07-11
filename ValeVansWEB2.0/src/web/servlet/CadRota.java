package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.modelo.Rota;
import api.modelo.Usuario;
import api.servico.ServicoRota;
import api.servico.ServicoUsuario;
import core.servico.ServicoRotaImpl;
import core.servico.ServicoUsuarioImpl;

@WebServlet("/CadRota")
public class CadRota extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CadRota() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html");
	       
			try{
				request.setCharacterEncoding("UTF-8"); 
	        }catch(Exception e){} 
			
			String bairro = request.getParameter("bairro");
			String idVan = request.getParameter("idVan");
			String inst = request.getParameter("instituicao");
			String periodo = request.getParameter("periodo");

			Rota rota = new Rota();
			rota.setBairroSaida(bairro);
			rota.setIdVan(Integer.parseInt(idVan));
			rota.setInstDestino(inst);
			rota.setPeriodo(periodo);
			System.out.println("b: "+bairro+" id: "+idVan+" inst: "+inst+" per: "+periodo);
			
			if(bairro!= null && idVan!=null && inst!= null && periodo!= null){
				ServicoRota sRota = new ServicoRotaImpl();
				
				sRota.insert(rota);
				
				try {
					request.getServletContext().getRequestDispatcher("/cadastroRota.jsp").forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				request.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
			}
	        
		
	}

}
