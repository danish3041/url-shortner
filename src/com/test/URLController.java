package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLController
 */
// @WebServlet("/URLController")
public class URLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String shortenedURL;
	private static String originalURL;

	/**
	 * Default constructor.
	 */
	public URLController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside doPost");
		String value = request.getParameter("action");
		System.out.println(value);
		if (value != null) {
			if (value.equals("Submit")) {
				originalURL = request.getParameter("tbsu");
				shortenedURL = "my-awesome_urlshortner.com";
				System.out.println("originalURL = " + originalURL);
				System.out.println("shortenedURL = " + shortenedURL);
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Redirect.jsp");
				reqDispatcher.forward(request, response);
			} else if (value.equals("Redirect")) {
				String sr = request.getParameter("su");
				if (sr.equals(URLController.shortenedURL)) {
					// redirecting to google site
					System.out.println("redirect done");
					response.sendRedirect(URLController.originalURL);
				} else {
					request.getRequestDispatcher("/Error.html");
				}
			}
		} else {
			request.getRequestDispatcher("/Error.html");
		}
	}
}
