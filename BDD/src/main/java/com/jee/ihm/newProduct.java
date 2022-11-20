package com.jee.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UtilConnexion;

@WebServlet("/new")
public class newProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("newProductView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("IM HERE");
		
		try ( Connection con = UtilConnexion.seConnecter() ) {
			
			String name = request.getParameter("txtName");
			String desc = request.getParameter("txtDesc");
			Float price = Float.parseFloat( request.getParameter("txtPrice") );

			System.out.println("New Product :" + name + " - " + desc + " - " + price);

			PreparedStatement ps = con.prepareStatement("INSERT INTO product(name, description, price) VALUE (?,?,?) ");
			
			ps.setString(1, name);
			ps.setString(2, desc);
			ps.setFloat(3, price);
			ps.executeUpdate();
			con.close();

			request.setAttribute("msg", "Produit Crée avec succes");
			request.getRequestDispatcher("/getAllView.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erreur dans le produit");
			e.printStackTrace();
			doGet(request, response);
		}
		
	}

}
