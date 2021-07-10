<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/red.css" type="text/css">
<title>Registration-Karate-User </title>
<style>
body {
	background: #c7b39b url(resources/picture/karateBckgrnd.jpg);
	/* Цвет фона и путь к файлу */
}
</style>
</head>
<body>
	<div style="text-align:center"
	>
		<h1 >Karate speed
		</h1>
	</div>
	<div style="text-align:center; margin-top:150px;">
		<form action="Controller" method="post">
			<input type="hidden" name="commandToController"
					value="Command_to_play" /> <br />
					<input type="text"
					name="login" value="" placeholder="Your login" />
					<br /> <br /> <input type="submit" class="button24" value="Send" /><br />
		
		</form>
	</div>
</body>
</html>