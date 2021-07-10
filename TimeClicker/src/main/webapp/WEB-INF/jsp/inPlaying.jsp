<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="resources/css/red.css" type="text/css">
<title>Let's Play!</title>
<style>
body {
	background-image:url(resources/picture/karateBckgrnd.jpg);
	
	/* Цвет фона и путь к файлу */
}
</style>
</head>
<body>
<%String randomCount1=(String)request.getSession(false).getAttribute("randomCount1"); 
		String randomCount2=(String)request.getSession(false).getAttribute("randomCount2");
		
		String toFive=(String) request.getSession(false).getAttribute("toFive");
		
		%>
	<div class=containerForDynamic>
		<form action="Controller" method="post" style="margin-top:<%out.print(randomCount1);%>%;
		 margin-left:<%out.print(randomCount2);%>%">
			<input type="hidden" name="commandToController"
					value="COMMAND_IN_PLAYING" />
					<input type="submit" class="button24"  value="Kick!" /><br />
		
		</form>
		<h1><%out.print(toFive); %></h1>
	</div>
</body>
</html>