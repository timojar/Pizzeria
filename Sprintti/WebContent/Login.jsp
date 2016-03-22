<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="materialize.min.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<title>Adminlogin</title>
</head>
<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<h3>Kirjaudu sisään</h3>
	<br>
	<!--    <form action="controller" method="POST">
	
		<p>
			<input type="text" name="Kayttajanimi" value=""
				placeholder="Käyttäjänimi">
		</p>
		<p>
			<input type="password" name="Salasana" value=""
				placeholder="Salasana">
		</p>
		<p class="remember_me">
			<label> <input type="checkbox" name="remember_me"
				id="remember_me"> Muista minut
			</label>
		</p>
		<p class="submit">
			<input type="submit" name="commit" value="Login">
		</p>
	</form> -->

	<div class="row">
		<form class="col s12" action="controller" method="post">
			<div class="row">
				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						name="Kayttajanimi" type="text" length="15" 
						class="validate" required > <label for="first_name">Käyttäjänimi</label>
				</div>

			</div>

			<div class="row">
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i> <input id="password"
						type="password" length="15" name="Salasana" class="validate" required>
					<label for="password">Salasana</label>
				</div>
			</div>
			<p class="Muista minut">
			<p>
				<input type="checkbox" class="filled-in" id="filled-in-box"
					checked="checked" name="memory"> <label for="filled-in-box">Muista
					minut</label>
			</p>
			<button class="btn waves-effect waves-light" type="submit"
				name="commit">
				Kirjaudu sisään <i class="material-icons right"></i>
			</button>
		</form>
	</div>



</body>
</html>