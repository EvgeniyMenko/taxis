<%@ page language="java" contentType="text/html; "
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>
 
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="bundle.translations"/>
 
<html lang="${sessionScope.lang}">
<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		
		<title>taxi</title>
		
	
		<link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
		<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="resources/css/demo.css">
		<link rel="stylesheet" type="text/css" href="resources/css/sidebar.css">
		<link rel="stylesheet" type="text/css" href="resources/css/table.css">
	    <link rel="stylesheet" type="text/css" href="resources/css/form.css">
	   <script src="resources/js/Future.js"></script>
		<script src="resources/js/snap.svg-min.js"></script>
		<script src="resources/js/AjaxCostTripPage.js"></script>
		
	</head>
	<body class="theme-1">
	
	<fmt:message key="text.time" var="time"/>
	<div class="container3">
	<a href="?action=costOfTravel&sessionLocale=en"><img src="resources/images/UK.png" width="30" 
   height="30"></a>
	<a href="?action=costOfTravel&sessionLocale=ru"><img src="resources/images/RU.png" width="30" 
   height="30"></a></div>
		<div class="container">
		
			<nav id="menu" class="menu">
			
				<button class="menu__handle"><span>Menu</span></button>
				<div class="menu__inner">
					<ul>
						<li><a href="${pageContext.request.contextPath}/home"><i class="fa fa-fw fa-home"></i><span><fmt:message key="text.home" /></span></a></li>
						<c:if test = "${sessionScope.user.role == 'admin'}">
					    <li><a href='${pageContext.request.contextPath}/home?action=add'><i class="fas fa-taxi"></i><span><fmt:message key="text.addCar" /><span></span></span></a></li>
					    <li><a href="${pageContext.request.contextPath}/home?action=edit"><i class="fas fa-edit"></i><span><fmt:message key="text.updateCar" /><span></span></span></a></li>
					    <li><a href="${pageContext.request.contextPath}/home?action=delete"><i class="fas fa-trash"></i><span><fmt:message key="text.deleteCar" /><span></span></span></a></li>
					    </c:if>
					    <li><a href="${pageContext.request.contextPath}/home?action=findCar"><i class="fas fa-search"></i><span><fmt:message key="text.findCar" /><span></span></span></a></li>
					    <li><a href="${pageContext.request.contextPath}/home?action=costOfTravel"><i class="fas fa-money-bill-wave"></i><span><fmt:message key="text.price" /><span></span></span></a></li>
					    <li><a href="${pageContext.request.contextPath}/home?action=sort"><i class="fas fa-filter"></i><span><fmt:message key="text.sort" /><span></span></span></a></li>
					    <c:if test = "${sessionScope.user.role == 'admin'}">
					    <li><a href="${pageContext.request.contextPath}/home?action=settings"><i class="fas fa-user-cog"></i><span><fmt:message key="text.settings" /><span></span></span></a></li>
					    </c:if>
					    <li><a href='${pageContext.request.contextPath}/logout'><i class="fas fa-sign-out-alt"></i><span><fmt:message key="text.logout" /><span></span></span></a></li>
						
					</ul>
				</div>
				<div class="morph-shape" data-morph-open="M300-10c0,0,295,164,295,410c0,232-295,410-295,410" data-morph-close="M300-10C300-10,5,154,5,400c0,232,295,410,295,410">
					<svg width="100%" height="100%" viewBox="0 0 600 800" preserveAspectRatio="none">
						<path fill="none" d="M300,-10C300,-10,300,154,300,400C300,632,300,810,300,810"></path>
					<desc>Created with Snap</desc><defs></defs></svg>
				</div>
			</nav>
			<div class="main">
				<header class="codrops-header">
					<h1><fmt:message key="text.taxisCompany" /><span><br> <br><fmt:message key="text.chooseCar" /></span></h1><br>
					<div class="container2"  id="result"></div>
					
				</header>
		<br>
		<form action="${pageContext.request.contextPath}/home?action=costOfTripResult"  method="post">
		<span class="custom-dropdown big">  
		
 <select name="select" id="selectBox" required>   
 <option selected value=""><fmt:message key="text.chooseCar" /></option>
   <c:forEach items="${taxis}" var="entry">
    <option data-id="${entry.value.id}" value="${entry.value.id}" >${entry.value.classCar},${entry.value.car},${entry.value.carModel}</option>
   </c:forEach> 
  
 </select> 
</span><br>
 <input type="number" step="1" min="1" placeholder="${time}" name="time" value="" required/><br>
 <input  type="hidden"   name="id"  >
<br>

  
  <button class="btn_login" ><fmt:message key="text.count" /></button> 
 </form>
	        <br>
			</div>
			
		</div>
		
		<script src="resources/js/classie.js"></script>
		<script src="resources/js/Menu.js"></script>
	
</body>

</html>