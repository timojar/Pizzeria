<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="tyyli.css" rel="stylesheet" type="text/css">
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

	<!-- CSS  -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet">
	<link href="materialize.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
	<link href="style.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
	<link href='https://fonts.googleapis.com/css?family=Pacifico'
		rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Oswald'
		rel='stylesheet' type='text/css'>
</head>
<body>

	<div class="navbar-fixed">
		
		
		
			
		<%@ include file="pizzerianav.jsp" %>
	
		
		
		
	</div>
	<br>
	<br>
	<h3>Kirjaudu sisään</h3>
	<br>
	<br>

	<div class="row">
		<form class="col s12" action="controller" method="post">
			<div class="row">
				<div class="input-field col s3">
					<i class="material-icons prefix">account_circle</i> <input
						name="Kayttajanimi" type="text" length="15" class="validate"
						required> <label for="first_name">Käyttäjänimi</label>
				</div>

			</div>

			<div class="row">
				<div class="input-field col s3">
					<i class="material-icons prefix">vpn_key</i> <input id="password"
						type="password" length="15" name="Salasana" class="validate"
						required> <label for="password">Salasana</label>
				</div>
			</div>
			<p class="Muista minut">
			<p>
				<input type="checkbox" class="filled-in" id="filled-in-box"
					checked="checked" name="memory"> <label for="filled-in-box">Muista
					minut</label>
			</p>
			<br>
			<button class="btn waves-effect waves-light" type="submit"
				name="commit">
				Kirjaudu sisään <i class="material-icons right"></i>
			</button>
		</form>
	</div>

	<footer class="page-footer green accent-4">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Tietoa yrityksestä</h5>
				<p class="grey-text text-lighten-4">Castello è Fiori on
					perinteinen italialaishenkinen Pizzaravintola, jolla on perinteet
					syvällä Italian historiassa. Perustettu vuonna 1800, perustamme
					suosiomme perinteisiin ja aitoihin italialaisiin makuelämyksiin.
					Tule ja koe aitoa Venetsialaista henkeä mainion viinin kera.</p>
			</div>
			<div class="col l4 offset-l2 s12">
				<h5 class="white-text">Links</h5>
				<ul>
					<li><a class="grey-text text-lighten-3" href="#!">Menu</a></li>
					<li><a class="grey-text text-lighten-3" href="#!">Group
							dining</a></li>
					<li><a class="grey-text text-lighten-3" href="#!">Order
							online</a></li>
					<li><a class="grey-text text-lighten-3" href="#!">Social
							media</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">
			© 2016 Late Night Show with Aarninsalo <a
				class="grey-text text-lighten-4 right" href="#!">More Links</a>
		</div>
	</div>
	</footer>

	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>
</body>
</html>