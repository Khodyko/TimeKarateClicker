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
	background: #c7b39b url(resources/picture/karateBckgrnd.jpg);
	/* Цвет фона и путь к файлу */
}
</style>
</head>
<body>
<%request.getSession(false).setAttribute("toFive", "0".toString());
String score=(String)request.getSession(false).getAttribute("time");
%>
	<div class=containerForStatic>
		<form action="Controller" method="post">
			<input type="hidden" name="commandToController"
					value="COMMAND_IN_PLAYING" />
					<input type="submit" class="button24" value="1 more time?" /><br />
		
		</form>
	</div>
	<h1>Your score is <%out.print(score); %></h1>
</body>
</html>