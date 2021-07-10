package controllerCommandMethods;

import java.io.IOException;

import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

public class CommandInPlaing implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		Integer randomCount1=(int)(Math.random()*40);
		Integer randomCount2=(int)(Math.random()*80);
		Long timeBeginRequest=System.currentTimeMillis();
		Long timeOfClick=(Long) request.getAttribute("Time");
		Integer toFive=  (Integer) Integer. parseInt((String) session.getAttribute("toFive"));
		toFive=toFive+1;
		session.setAttribute("toFive", toFive.toString());
		if(toFive>5) {
			Long scoreMillis= (Long)Long.parseLong( (String) session.getAttribute("time"))-(Long)System.currentTimeMillis();
			Long scoreSec=((Long)(scoreMillis/1000));
			Long scoreMilisWithoutSec=(Long)scoreMillis%1000;
			String scoreSecMilliString=scoreSec.toString()+" sec "+scoreMilisWithoutSec+" millis" ;
			session.setAttribute("time", scoreSecMilliString);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/results.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		session.setAttribute("randomCount1", randomCount1.toString());
		session.setAttribute("randomCount2", randomCount2.toString());
	if(toFive==1) {
		session.setAttribute("time", timeBeginRequest.toString());}
		
		response.sendRedirect("Controller?commandToController=COMMAND_AFTER_REDIRECT_TO_INPLAING");
		
	}

	}
