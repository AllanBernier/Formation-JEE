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

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try ( Connection con = UtilConnexion.seConnecter() ) {
			
			int id = Integer.parseInt(request.getParameter("id"));

			PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();

			request.setAttribute("msg", "Produit Supprimé");
			request.getRequestDispatcher("/getproducts").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erreur dans la suppression");
			doGet(request, response);
			e.printStackTrace();
		}	
	}

}
