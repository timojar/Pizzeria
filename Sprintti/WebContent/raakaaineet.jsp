<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="fi.omapizzeria.admin.bean.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<link href="styles.css" rel="stylesheet" type="text/css">
<link href="tyyli.css" rel="stylesheet" type="text/css">

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
		 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>

<title>Lista</title>


</head>
<body>




	 


		
		
	
	
		
		

		<div class="navbar-fixed">
			<%@ include file="adminnav.jsp" %>
		

	</div>
		
		
		
		


		<div id=sisältö>




h4>Luo täyte</h4>
<br>
<br>

 <div class="row">
    <form class="col s12" action="tayteController" method="post">
      <div class="row">
        <div class="input-field col s3">
          <i class="material-icons prefix">assignment</i>
          <input id="icon_prefix" length="15" type="text" class="validate" name="tayteNimi">
          <label for="icon_prefix">Täytteen nimi</label>
        </div>
        <div class="input-field col s3">
          <i class="material-icons prefix">assignment</i>
          <input id="icon_telephone" length="5" type="tel" class="validate" name="saatavuus">
          <label for="icon_telephone">Saatavuus</label>
          <br> </div>
          <!-- <input type="submit" class="btn waves-effect waves-light"  value="Luo täyte"> -->
          
          <button class="btn waves-effect waves-light" type="submit" name="commit">
				Luo Täyte <i class="material-icons right"></i>
			</button>
          
         
  </button>
       
      </div>
    </form>
  </div>
  
  <!--  
  <form action="tayteController" method="post">
<label>Täytteen nimi</label>
<input type="text" name="tayteNimi">

<label>Saatavuus</label>
<input type="text" name="saatavuus">

<input type="submit" value="Luo täyte">

</form>

-->




		
</div>

<form  method="post" action="logout" id="logout">
		
			<input type="hidden" name="logout">
			<label><c:out value="${user}"></c:out></label>
			<input class="btn waves-effect waves-light" type="submit" value="Kirjaudu ulos">
		</form>

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



</body>
</html>