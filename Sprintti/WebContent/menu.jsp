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




	
			
			
	


		<div id=sisältö>
<c:forEach items="${menu}" var="pizzat">

<p>
					<c:out value="${pizzat.pizzaNo }"></c:out>
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


</c:forEach>



		</div>





		<div id=footer>

			<p>http://localhost:8080/PizzeriaAdmin/list.jsp</p>

		</div>

	</div>



</body>
</html>