<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<nav>
<c:out value="${etunimi}"></c:out> <c:out value="${sukunimi}"></c:out>
		<div class="nav-wrapper green accent-4">
			<a href="index.jsp" class="brand-logo center"><img
				src="Kuvat/Logo.png" alt=pizza height="76" width="160"></a>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="AsiakasController">Etusivu</a></li>
				<li><a href="menuController">Menu</a></li>
				<li><a href="#">Tietoa</a></li>
				<c:choose>
				<c:when test="${logged=='logged'}">
				<li><a href="logout?logout=logout" class="waves-effect  pink accent-1 btn">Kirjaudu ulos</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="Login.jsp" class="waves-effect  pink accent-1 btn">Kirjaudu</a></li>
				</c:otherwise>
				</c:choose>
				<li><a href="register.jsp" class="waves-effect amber accent-3 btn">Rekisteröidy</a></li>
			</ul>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="#">Ryhmätilaisuudet</a>
        <li><a href="feedback.jsp">Anna palautetta</a></li>
        
      </ul>
		</div>
		</nav>

