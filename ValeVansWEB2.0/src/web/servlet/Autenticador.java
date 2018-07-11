package web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.servico.ServicoUsuarioImpl;

@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Autenticador() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("loginEmail");
		String senha = request.getParameter("loginSenha");
		
		ServicoUsuario sUsuario = new ServicoUsuarioImpl();
		Usuario uBD = sUsuario.findByEmail(email);
		
		ServletContext sc = request.getServletContext();
		if (uBD!= null && uBD.getSenha().equals(senha)){
        	
            try{
                request.setAttribute("usuarioLogado",uBD);
                sc.getRequestDispatcher("/index.jsp").forward(request, response); 
            }catch( Exception e){
               //Tratamento de exceção... 
            }            
        }
        else{
            try {
                request.setAttribute("falhaAutenticacao", true);
                sc.getRequestDispatcher("/login.jsp").forward(request, response);
            }catch(Exception e){
                //Tratamento de erro de IO ou de Servlet..
            }  
        }
		doGet(request, response);
	}

}
