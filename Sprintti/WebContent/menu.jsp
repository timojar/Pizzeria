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
	<link href="styles.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
	<link href='https://fonts.googleapis.com/css?family=Pacifico'
		rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Oswald'
		rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>
		 <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>

<title>Lista</title>


</head>
<body>




	 


		
		
	
		
		
		

		<div class="navbar-fixed">
		<%@ include file="pizzerianav.jsp" %>
	</div>
		
		
	<div id="menusisalto">

<h1>Menu</h1>

<br>
<br>
<br>
<br>

	<div id="ostoskori">
	<h5>Ostoslista</h5>
<c:set  var="total" value="${ 0}"/>	
<c:set var="index" value="${ -1}"/>
<c:forEach items="${ostoslista}" var="ostos">
<c:set  var="total" value="${ total+ostos.yhteishinta}"/>	
<p>

<c:set var="index" value="${ index+1}"/>
<c:out value="${ostos.lkm }"> </c:out> kpl <c:out value="${ostos.nimi }">  </c:out><span class="hinta"> <fmt:formatNumber type="currency"  currencySymbol=""  value="${ostos.yhteishinta}" />
 EUR</span>

				</p>
				
<form action="removeItem" method="post">
<input type="hidden" name="remove" value="${index}">
<input type="submit" value="poista" >



</form>

</c:forEach>

<p>Yhteens� <span class="hinta"><fmt:formatNumber type="currency"  currencySymbol=""  value="${total}" /> EUR</span></p>	
<br>
<p> <a href="removeItem?tyhjennys=empty">Tyhjenn� ostoslista</a> </p>		
	<a href="TilausController" button class="btn waves-effect teal lighten-1"  value="" type="submit" name="">
				Siirry tilaukseen <i class="material-icons right">done_all</i></a>
			</button>
</div>
	
	 <div class="row">
        <div class="col s12 m6">
          <div class="card green lighten-3">
            <div class="card-content black-text">
	
	<div id="vasensarake">
	
	<c:forEach items="${menu}" var="pizzat">


<table id="pizzat">
				
      
        <tbody>
              <tr>
            <td id="nro"><c:out value="${pizzat.pizzaNo }"></c:out></td>
            <td id="pizzanimi"><c:out value="${pizzat.nimi }"></c:out></td>
            <td><fmt:formatNumber type="currency"  currencySymbol=""  value="${pizzat.hinta}" /> EUR</td>
          </tr>
        </tbody>
      </table>
      
      
      	<form action="shoppingcart" method="post" id="add" >
					<input type="hidden" name="pizzaid" value="${pizzat.id }"> <input
						type="submit"  value="Lis�� ostoskoriin" id="add">

<div id="palkki">
<select name="lkm" class="browser-default" >
<option value="1">1 kpl</option>
<option value="2">2 kpl</option>
<option value="3">3 kpl</option>
<option value="4">4 kpl</option>
<option value="5">5 kpl</option>
<option value="6">6 kpl</option>
<option value="7">7 kpl</option>
<option value="8">8 kpl</option>
<option value="9">9 kpl</option>
</select>




  
</div>
				</form>
				
            <p>
				<c:out value="${pizzat.kuvaus }"></c:out>
				</p>
				
			
	
<br>	
<br>	
<br>		
</c:forEach>



		
</div>






	
	
	
	</div>	
	</div>
          </div>
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
				<h5 class="white-text">Tietoa yrityksest�</h5>
				<p class="grey-text text-lighten-4">Castello � Fiori on
					perinteinen italialaishenkinen Pizzaravintola, jolla on perinteet
					syv�ll� Italian historiassa. Perustettu vuonna 1800, perustamme
					suosiomme perinteisiin ja aitoihin italialaisiin makuel�myksiin.
					Tule ja koe aitoa Venetsialaista henke� mainion viinin kera.</p>
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
			� 2016 Late Night Show with Aarninsalo <a
				class="grey-text text-lighten-4 right" href="#!">More Links</a>
		</div>
	</div>
	</footer>



</body>
</html>