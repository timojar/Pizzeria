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
		
		
		
		


	
		<div id="section">


<c:forEach items="${taytteetvahissa }" var="t">
	
	<p><c:out value="${t.pizzanimi}"> </c:out>: <c:out value="${t.tayteNimi}"></c:out> on <span class="nosale">loppumassa.
	</span>Lisää täytteet tai <span class="nosale"> pizza poistetaan ruokalistalta </span></p>
	
	</c:forEach>


	<h2>Pizza lista</h2>
	
	

			<c:out value="${aloitusaika }"></c:out>
			<c:if test="${not empty param.added}"><p><span class="onnistui">Uuden pizzan lisääminen onnistui!</span></p></c:if>
			<c:if test="${not empty param.hinta}">
			<p><span class="eionnistunut">Laita hinta numerona. Desimaalina käytä .-merkintää</span></p></c:if>
			
			
	<c:if test="${not empty param.taytemaara}">
	
	
	<p><span class="eionnistunut">Vähintään 1 täyte pitää olla pitsassa ja täytteitä korkeintaan 7</span></p></c:if>



			<c:forEach items="${lista }" var="pizzat">

				<p>
					<c:out value="${pizzat.id }"></c:out>
				</p>
				<p>
					<c:out value="${pizzat.nimi }"></c:out>
				</p>
				<p>
					<fmt:formatNumber type="currency"  currencySymbol=""  value="${pizzat.hinta}" /> EUR
				</p>

<p>
				<c:out value="${pizzat.kuvaus }"></c:out>
				</p>
				
				<c:if test="${pizzat.piiloitus == 'nosale'}"> <p><span class="nosale">Ei ole myynnissä</span></p></c:if>

				<%--Pizzanpoisto: Jokaisen pizzan kohdalla on poista-nappi, jota
				painamalla lähetetään pizzan id-numero parametrina controller-servlettiin
				
				--%>
<br>
				<form action="poistaPizza" method="post" id="delete">
					<input type="hidden" name="tunnus" value="${pizzat.id }"> <input
						type="submit"  value="poista">

				</form>
				<br>

	<%--Pizzan piiloitus: piilota-nappi lähettää Pizza id-atribuutin arvon parametrina
	 controller-luokkaan, jossa se käännetään int-tietotyypiksi.
	 Käännettynä se menee PizzaDAO-luokkaan, jossa pizza 
	 saa "nosale"-arvon tietokannan piilota-kenttään. MenuDao-luokka tuo niitä pizzoja menuController-luokkaan
	 joissa ei ole merkintää piilota kentässä. Luokka "menuController" ohjaa pizzoja ruokalistaan.
	 
				--%>
		

			<br>
		<form action="MuokkaaPizza" method="get">
		
		<input type="hidden" name="muokkausid" value="${pizzat.id }">		
<input	type="submit"  value="muokkaa">
		
		</form>

			</c:forEach>

			<form method="post" action="lisaaPitsa" id="tiedot">



				<p>Pizzan nimi:</p>
				<input type="text" name="nimi" id="pizzannimi" required>

				<p>Pizzan hinta:</p>
				<input type="text" name="hinta" id="pizzanhinta" required>
				<br>
				<br>
				
			
			<label>Valitse täytteet (max 6)</label>
				<br>
			
			<c:forEach items="${taytelista}" var="tayte"> 
						
		<p>
      <input type="checkbox" id="${tayte.tayteNimi}" name="taytteet" value="${tayte.id}"/>
      
      <label for="${tayte.tayteNimi}"><c:out value="${tayte.tayteNimi}"> </c:out></label>
    </p>
			
			</c:forEach>
			
				<br>
				<br>
				
		
				
			 <input
					type="submit" id="lahetys" value="Luo pizza">			
				
			</form>


	<br>
	
	<br>	


<c:if test="${noofPages > 1}">
		
		
	
 <ul class="pagination">
    <c:forEach begin="${startindex}" end ="${noofPages}" var="i">
    <c:choose>
    
    <c:when test="${i==currentpage}">
    <li class="active"><a href="controller?page=${i}">${i}</a></li>
    </c:when>
    <c:when test="${i!=currentpage}">
    <li class="waves-effect"><a href="controller?page=${i}">${i}</a></li>
    </c:when>
    
    </c:choose>
   
   </c:forEach>
  </ul>



</c:if>

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