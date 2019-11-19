/** 
 * @author Giles Kindzeka Kisife
 * Session history time out set to 5 minutes here means after collecting session history for 5 minutes, the session times out
 * 
 * **/
package com.acvs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTracker
 */
@WebServlet("/SessionTracker")
public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> sessionList = new ArrayList<String>();
	private HttpSession session;
	private static long sessionDuration;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Start session if non exist.
		request.getSession(true);
		session = request.getSession();
		sessionDuration = session.getLastAccessedTime() - session.getCreationTime();

		String currentLink = (String) request.getAttribute("webLink");

		// Set weblink to homepage at start of session
		if ((session.isNew()) || (currentLink == null)) {
			currentLink = "Homepage.jsp";
			request.getSession(true).setAttribute("webLink", currentLink);
			sessionList.add(currentLink);

		} else {
			request.getSession(true).setAttribute("webLink", currentLink);
			sessionList.add(currentLink);

		}

		// Check if session history has more than 10 entries and clear history.
		if (sessionList.size() > 10) {
			System.out.println("Clearing session after 10 entries");
			sessionList.clear();
		}
		// Check if session history has lasted more than 5 minutes and reset.
		else if ((sessionDuration >= 5 * 60 * 1000) && sessionList.size() <= 10) {
			System.out.println("Session history is timing out after 5 minutes!");
			sessionList.clear();
			session.invalidate();

		}
		request.setAttribute("history", sessionList);
		request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
	}

}
