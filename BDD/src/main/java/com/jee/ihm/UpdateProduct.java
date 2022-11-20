package com.jee.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UtilConnexion;


@WebServlet("/updateproduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try ( Connection con = UtilConnexion.seConnecter() ) {
			int id = Integer.parseInt( request.getParameter("id") );

			PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				request.setAttribute("id", rs.getInt(1));
				request.setAttribute("name", rs.getString(2));
				request.setAttribute("desc", rs.getString(3));
				request.setAttribute("price", rs.getFloat(4));
			}
			
			request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/getproducts").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try ( Connection con = UtilConnexion.seConnecter() ) {
			
			String id = request.getParameter("txtId");
			String name = request.getParameter("txtName");
			String desc = request.getParameter("txtDesc");
			Float price = Float.parseFloat( request.getParameter("txtPrice") );

			System.out.println("New Product :" + name + " - " + desc + " - " + price);

			PreparedStatement ps = con.prepareStatement("UPDATE product SET name=?, description=?, price=? WHERE id="+ id);
			
			ps.setString(1, name);
			ps.setString(2, desc);
			ps.setFloat(3, price);
			//ps.setInt(4, id);
			ps.executeUpdate();
			con.close();

			request.setAttribute("msg", "Produit Midifié avec succes");
			request.getRequestDispatcher("/getAllView.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Erreur dans la modification");
			e.printStackTrace();
			doGet(request, response);
		}
	}

}
