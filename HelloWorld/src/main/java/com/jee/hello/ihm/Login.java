package com.jee.hello.ihm;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jee.hello.dao.DAOContext;
import com.jee.hello.dao.UserDAO;
import com.jee.hello.modele.User;


@WebServlet(name = "LoginUser", urlPatterns = { "/login" }, loadOnStartup=1)
public class Login extends HttpServlet {

	private static final long serialVersionUID = -4319076288258537575L;

    public Login() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
        DAOContext.init( config.getServletContext() ); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute( "login", "" );
        request.setAttribute( "password", "" );
        request.setAttribute( "errorMessage", "" );
        System.out.println("Hey");
        request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
        
        request.setAttribute( "login", login );
        request.setAttribute( "password", password );
        
        User connectedUser = UserDAO.isValidLogin( login, password );
        if ( connectedUser != null ) {
            
            HttpSession session = request.getSession( true );
            session.setAttribute( "connectedUser", connectedUser );
            request.getRequestDispatcher( "/connected.jsp" ).forward( request, response );
        
        } else {
        
            request.setAttribute( "errorMessage", "Bad identity" );         
            request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
            
        }
        
    }
}
