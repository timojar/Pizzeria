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

	<%--Pizzan piiloitus: piilota-nappi l�hett�� Pizza id-atribuutin arvon parametrina
	 controller-luokkaan, jossa se k��nnet��n int-tietotyypiksi.
	 K��nnettyn� se menee PizzaDAO-luokkaan, jossa pizza 
	 saa "nosale"-arvon tietokannan piilota-kentt��n. MenuDao-luokka tuo niit� pizzoja menuController-luokkaan
	 joissa ei ole merkint�� piilota kent�ss�. Luokka "menuController" ohjaa pizzoja ruokalistaan.
	 
				--%>
		
				
<c:choose>
<%--Pizzan piiloitus: Jos pizzan  arvo tietokannan kent�ss� "piiloitus" ei ole "nosale" Pizzan kohdalla on 
Piilota-nappi.
				--%>
<c:when test="${pizzat.piiloitus != 'nosale'}">
<form action="controller" method="post" id="hide">	
<input type="hidden" name="hide" value="${pizzat.id }">		
<input	type="submit"  value="Piilota">
</form>	
</c:when>

<%--Pizzan paljastus: paljasta-nappi l�hett�� Pizza id-atribuutin arvon parametrina
	 controller-luokkaan, jossa se k��nnet��n int-tietotyypiksi.
	 K��nnettyn� se menee PizzaDAO-luokkaan, jossa pizza 
	 saa tyhj�n arvon piilota-kentt��n. 
	 
				--%>
				
				
	<%--Pizzan paljastus: Jos pizzan  arvo tietokannan kent�ss� "piiloitus" on "nosale" Pizzan kohdalla on 
Paljasta-nappi.
				--%>			

<c:when test="${pizzat.piiloitus == 'nosale'}">
<form action="controller" method="post" id="reveal">	
<input type="hidden" name="reveal" value="${pizzat.id }">		
<input	type="submit"  value="Paljasta">
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