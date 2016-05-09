<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tilaukset</title>
<link href="tyyli.css" rel="stylesheet" type="text/css">
<link href="styles.css" rel="stylesheet" type="text/css">

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="materialize.min.css"
	me"WebContent/index.jsp"dia="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>


	<div class="navbar-fixed">
		<%@ include file="adminnav.jsp"%>
	</div>



	<div id="tilaukset">
		<br> <br>
		<h3>Tilaukset</h3>
		<br> <br> <a class="waves-effect waves-light btn"
			href="SelaaTilauksia?status=tilattu">Tilatut</a> <a
			class="waves-effect waves-light btn"
			href="SelaaTilauksia?status=vahvistettu">Vahvistetut</a> <br> <br>
			 <a
			class="waves-effect waves-light btn"
			href="SelaaTilauksia?status=maksettu">Maksetut</a> <br> <br>
		<br> <br> <br> <br>
<c:set var="tuotot" value="${0}"/>
		<c:forEach items="${tilaukset}" var="tilaus">
<c:set var="tuotot" value="${tilaus.yhteishinta+tuotot }"/>
			<p>
				<span class="atribuutit"> Tilaus nro: </span>
				<c:out value="${tilaus.numero }"></c:out>
			</p>

			<p>
				<span class="atribuutit"> Osoite: </span>
				<c:out value="${tilaus.tilausAsiakas.osoite}"></c:out>
			</p>
			<p>
				<span class="atribuutit"> Postinumero: </span>
				<c:out value="${tilaus.tilausAsiakas.postinro}"></c:out>
			</p>

			<p>
				<span class="atribuutit"> Toimipaikka: </span>
				<c:out value="${tilaus.tilausAsiakas.tmp}"></c:out>
			</p>
			<p>
				<span class="atribuutit"> Etunimi: </span>
				<c:out value="${tilaus.tilausAsiakas.etunimi}"></c:out>
			</p>

			<p>
				<span class="atribuutit"> Sukunimi </span>
				<c:out value="${tilaus.tilausAsiakas.sukunimi}"></c:out>
			</p>

			<p>
				<span class="atribuutit"> Email:</span>
				<c:out value="${tilaus.tilausAsiakas.email}"></c:out>
			</p>

			<p>
				<span class="atribuutit"> Toimitustapa: </span>
				<c:out value="${tilaus.toimitustapa}"></c:out>
			</p>

			<p>
				<span class="atribuutit"> Maksutapa: </span>
				<c:out value="${tilaus.maksutapa}"></c:out>
			</p>

			<p>

				<span class="atribuutit"> Yhteishinta: </span>
				<fmt:formatNumber type="currency" currencySymbol=""
					value="${tilaus.yhteishinta}" />
				EUR
			</p>


			<form action="Tilaukselle" method="get">

				<input type="hidden" value="${tilaus.numero }" name="numero">

				<input type="submit" value="Katso Tilausta"> <br> <br>
				<br>
			</form>

		</c:forEach>

	</div>
	<form method="post" action="logout" id="logout">

		<input type="hidden" name="logout"> <label><c:out
				value="${user}"></c:out></label> <input class="btn waves-effect waves-light"
			type="submit" value="Kirjaudu ulos">
	</form>
	<%@ include file="footer.jsp"%>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>