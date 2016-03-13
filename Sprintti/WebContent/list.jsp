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


		<div id=header></div>

		<ul id=paavalikko>
			<li><a href="">Ravintolat</a>
			<li><a href="menuController">Ruokalista </a>
			<li><a href="">Meille t�ihin </a>
			<li><a href="tayteController">Luo t�yte</a>
		</ul>
		<div id="pylvas">
		
		<div id="column"></div>
		
		</div>


		<div id=sis�lt�>


			<h2>Pizza lista</h2>

			<c:out value="${aloitusaika }"></c:out>
			<c:if test="${not empty param.added}">Uuden pizzan lis��minen onnistui!</c:if>


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

				<%--Pizzanpoisto: Jokaisen pizzan kohdalla on poista-nappi, jota
				painamalla l�hetet��n pizzan id-numero parametrina controller-servlettiin
				
				--%>
<br>
				<form action="controller" method="post" id="delete">
					<input type="hidden" name="tunnus" value="${pizzat.id }"> <input
						type="submit"  value="poista">

				</form>
				<br>


<c:choose>
<c:when test="${pizzat.poisto != 'nosale'}">
<form action="controller" method="post" id="hide">	
<input type="hidden" name="hide" value="${pizzat.id }">		
<input	type="submit"  value="piilota">
</form>	
</c:when>

<c:when test="${pizzat.poisto == 'nosale'}">
<form action="controller" method="post" id="reveal">	
<input type="hidden" name="reveal" value="${pizzat.id }">		
<input	type="submit"  value="Lis��">
</form>	

</c:when>


</c:choose>

			<br>
		

			</c:forEach>

			<form method="post" action="controller" id="tiedot">

				<p>Pizzan nimi:</p>
				<input type="text" name="nimi" id="pizzannimi">

				<p>Pizzan hinta:</p>
				<input type="text" name="hinta" id="pizzanhinta">
				<br>
				<br>
				
				<p>Sis�lt� kuvaus:</p>
				<input type="text" name="kuvaus" id="taytteet">
				<br>
				<br>
					<br>
			<label>Valitse t�ytteet (max 6)</label>
				<br>
			
			<c:forEach items="${taytelista}" var="tayte"> 
		
		<label> <input type="checkbox" name="${pizzatayte}" value="${tayte.tayteNimi}"> 
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