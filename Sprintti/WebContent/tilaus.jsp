<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="fi.omapizzeria.admin.bean.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div id="tilaukset">	
		
	<h3>Tilaus nro <c:out value="${tilausid}"></c:out></h3>	


      <table>
        <thead>
          <tr>
              <th data-field="id">Pizza id</th>
              <th data-field="name">Pizzan nimi</th>
              <th data-field="price">Kpl</th>
               <th data-field="">Hinta EUR</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach items="${rivit}" var="rivi">
          <tr>
            <td><c:out value="${rivi.pizzaid}"></c:out></td>
            <td><c:out value="${rivi.pizza.nimi}"></c:out></td>
            <td><c:out value="${rivi.lkm}"></c:out></td>
            <td><fmt:formatNumber type="currency"  currencySymbol=""  value="${rivi.hinta}" /> EUR</td>
          </tr>
         </c:forEach> 
           
        </tbody>
      </table>
            <br>
            <br>
            <br>

<form action="Tilaukselle" method="post">

<input type="hidden" value="${tilausid}" name="vahvistus">

<button class="btn waves-effect waves-light" type="submit" name="action">Vahvista
    <i class="material-icons right">send</i>
  </button>


</form>
		<br>
            <br>
            <br>

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