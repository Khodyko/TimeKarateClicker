package controllerCommandMethods;

import java.io.IOException;
import java.util.SortedMap;

import controller.Command;
import dao.DBHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import jakarta.servlet.http.Cookie;
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
			DBHelper dbHelper=new DBHelper();
			Cookie[] cookies = request.getCookies();
			String cookieName = "login";
			Cookie cookie = null;
			if(cookies !=null) {
			    for(Cookie c: cookies) {
			        if(cookieName.equals(c.getName())) {
			            cookie = c;
			            break;
			        }
			    }
			}
			dbHelper.registerUser((String)cookie.getValue(), scoreMillis);
			SortedMap<Long, String> dbData= dbHelper.callSQL();
			session.setAttribute("dbData", dbData);
			
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
