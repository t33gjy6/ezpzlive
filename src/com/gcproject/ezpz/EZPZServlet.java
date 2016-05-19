package com.gcproject.ezpz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EZPZServlet")
public class EZPZServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String meal = request.getParameter("meal");
		try {
			request.setAttribute("meal", meal);
			getServletContext().getRequestDispatcher("/meals.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
