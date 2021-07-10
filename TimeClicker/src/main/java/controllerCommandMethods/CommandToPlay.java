package controllerCommandMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import service.ServiceProvider;

public class CommandToPlay implements Command {
	
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String path = "/WEB-INF/jsp/play.jsp";
	HttpSession session=request.getSession(true); 
	String login=request.getParameter("login");
	session.setAttribute("login", login);
	session.setAttribute("toFive", "0");

	RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
	
	requestDispatcher.forward(request, response);

}

}
