package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.servico.ServicoUsuarioImpl;

/**
 * Servlet implementation class CadUsuario
 * 
 */
@WebServlet("/CadUsuario")
public class CadUsuario extends HttpServlet {
	// throws ServletException, IOException
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
       resp.setContentType("text/html");
       
		try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 
		
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");	
		String senha1 = req.getParameter("senha");
		String senha2 = req.getParameter("conSenha");
		Usuario u = new Usuario();
		
		u.setEmail(email);
		u.setNome(nome);
		
		if(senha1.equals(senha2)){
			u.setSenha(senha1);
		}else{
			try {
				req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(nome!= null && email!=null && senha1!= null){
			ServicoUsuario sUsu = new ServicoUsuarioImpl();
			
			sUsu.insert(u);
			
			try {
				req.getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
        

	}

}
