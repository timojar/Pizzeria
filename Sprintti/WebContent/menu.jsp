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

<fmt:formatNumber type="currency" currencySymbol="eur"  value="${pizzat.hinta }"/>
<link href="styles.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>


</head>
<body>




		<div id=sisältö>
		
		
		
		  
		
<c:forEach items="${menu}" var="pizzat">


<table id="pizzat">
				
      
        <tbody>
              <tr>
            <td id="nro"><c:out value="${pizzat.pizzaNo }"></c:out></td>
            <td id="pizzanimi"><c:out value="${pizzat.nimi }"></c:out></td>
            <td><fmt:formatNumber type="currency"  currencySymbol="EUR"  value="${pizzat.hinta}" /></td>
          </tr>
        </tbody>
      </table>
       
      
      	<form action="shoppingcart" method="post" id="add" >
					<input type="hidden" name="pizzaid" value="${pizzat.id }"> <input
						type="submit"  value="Lisää ostoskoriin">


<select name="lkm">
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
				</form>
				
            <p>
				<c:out value="${pizzat.kuvaus }"></c:out>
				</p>
				
			
	
<br>	
<br>	
<br>		
</c:forEach>



		</div>




<div id="ostoskori">
	
			
<c:forEach items="${ostoslista}" var="ostos">
<p>


<c:out value="${ostos.lkm }"> </c:out> kpl <c:out value="${ostos.nimi }">  </c:out> <c:out value="${ostos.yhteishinta}">
</c:out> euroa 
				</p>
				
<form action="removeItem" method="post">
<input type="hidden" name="remove" value="{ostos.index}">
<input type="submit" value="poista" >

</form>

</c:forEach>			
	
</div>

	





</body>
</html>