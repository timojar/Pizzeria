<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="fi.omapizzeria.admin.bean.Pizza"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link href="styles.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>

<%
	DecimalFormat desimaalit = new DecimalFormat("0.00");

	List<Pizza> pizzalista = (ArrayList<Pizza>) request
			.getAttribute("lista");
%>

</head>
<body>




	<div id=raamit>


		<div id=header></div>

		<ul id=paavalikko>
			<li><a href="">Ravintolat</a>
			<li><a href="">Ruokalista </a>
			<li><a href="">Meille töihin </a>
			<li><a href="">Yhteystiedot</a>
		</ul>
		<div id=pylvas></div>


		<div id=sisältö>


			<h2>Pizza lista</h2>

			<c:out value="${aloitusaika }"></c:out>
			<c:if test="${not empty param.added}">Uuden pizzan lisääminen onnistui!</c:if>


			<c:forEach items="${lista }" var="pizzat">

				<p>
					<c:out value="${pizzat.id }"></c:out>
				</p>
				<p>
					<c:out value="${pizzat.nimi }"></c:out>
				</p>
				<p>
					<c:out value="${pizzat.hinta }"></c:out>
				</p>


				<%--Pizzanpoisto: Jokaisen pizzan kohdalla on poista-nappi, jota
				painamalla lähetetään pizzan id-numero parametrina controller-servlettiin
				
				--%>

				<form action="controller" method="post">
					<input type="hidden" name="tunnus" value="${pizzat.id }"> <input
						type="submit" id="delete" value="poista">

				</form>
				<br>

			</c:forEach>

			<form method="post" action="controller" id="tiedot">

				<p>Pizzan nimi:</p>
				<input type="text" name="nimi" id="pizzannimi">

				<p>Pizzan hinta:</p>
				<input type="text" name="hinta" id="pizzanhinta"> <input
					type="submit" id="lahetys">
			</form>





		</div>





		<div id=footer>

			<p>http://localhost:8080/PizzeriaAdmin/list.jsp</p>

		</div>

	</div>



</body>
</html>