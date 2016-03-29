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


<link href="styles.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>


</head>
<body>




	<div id=raamit>


		<div id=header>
		
		<form  method="post" action="logout" id="logout">
			
			
			<input type="hidden" name="logout">
			<label><c:out value="${user}"></c:out></label>
			<input type="submit" value="Kirjaudu ulos">
			</form>
		
		
		</div>

		<ul id=paavalikko>
			<li><a href="controller">Näytä kaikki pizzat</a>
			<li><a href="menuController">Ruokalista </a>
			<li><a href="">Meille töihin </a>
			<li><a href="tayteController">Luo täyte</a>
		</ul>
		<div id="pylvas">
		
		<div id="column"></div>
		
		</div>


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

<p>
				<c:out value="${pizzat.kuvaus }"></c:out>
				</p>
				
				<c:if test="${pizzat.piiloitus == 'nosale'}"> <p>Ei ole myynnissä</p></c:if>

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
			
			
			
		
		<label> <input type="checkbox" name="taytteet" value="${tayte.tayteNimi}"> 
		<c:out value="${tayte.tayteNimi}">
		</c:out> </label>
		
			
			</c:forEach>
			
				<br>
				<br>
				
		
				
			 <input
					type="submit" id="lahetys" value="Luo pizza">			
				
			</form>


		<table>
		<c:forEach begin="${startindex}" end ="${noofPages}" var="i">
		
		<td><a href="controller?page=${i}">${i}</a></td>
		</c:forEach>
		</table>


		</div>





		<div id=footer>

			<p>http://localhost:8080/PizzeriaAdmin/list.jsp</p>

		</div>

	</div>



</body>
</html>