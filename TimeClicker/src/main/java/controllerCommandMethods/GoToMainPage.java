package controllerCommandMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.ServiceProvider;

public class GoToMainPage implements Command {
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/jsp/main.jsp";
	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		
		requestDispatcher.forward(request, response);
	}

}
