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
<form action="tayteController" method="post">
<label>Täytteen nimi</label>
<input type="text" name="tayteNimi">

<label>Saatavuus</label>
<input type="text" name="saatavuus">

<input type="submit" value="Luo täyte">

</form>


		</div>





		<div id=footer>

			<p>http://localhost:8080/PizzeriaAdmin/list.jsp</p>

		</div>

	</div>



</body>
</html>