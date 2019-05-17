<%@ page language="java" contentType="text/html;"
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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css">
<script src="resources/js/Future.js"></script>
<script src="resources/js/login.js"></script>
<script src="resources/js/AjaxLoginPage.js"></script>
 
		
       	  
</head>
<body>
<div class="container3">
 <a href="?sessionLocale=en"><img src="resources/images/UK.png" width="30" 
   height="30"></a>
	<a href="?sessionLocale=ru"><img src="resources/images/RU.png" width="30" 
   height="30"></a></div>
 <fmt:message key="text.login" var="login" />
  <fmt:message key="text.password" var="password" />

<div class="cotn_principal">

  <div class="cont_centrar">
 
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2><fmt:message key="text.formLogin" />
</h2>
          
            <button class="btn_login" onclick="cambiar_login()"><fmt:message key="text.logIn" />
</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2><fmt:message key="text.registration" />
</h2>
        
            <button class="btn_sign_up" onclick="cambiar_sign_up()"><fmt:message key="text.singUp" /></button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey">
        
        </div>
      </div>
      <div class="cont_forms">
        <div class="cont_img_back_">
        
        </div>
        <div class="cont_form_login">
          <a href="" onclick="ocultar_login_sign_up()"><i class="fas fa-arrow-left"></i></a>
          <h2><fmt:message key="text.formLogin" /></h2>
          <div class="container2"  id="resultLogin" ></div>
          <form action="/TaxisProject/login" method="post" >
          <input type="text" name="username" placeholder="${login}" required/>
          <input type="password" name="password" placeholder="${password}" required/>
         <button class="btn_login" onclick="cambiar_login()"><fmt:message key="text.logIn" /></button></form>
        </div>
        <div class="cont_form_sign_up">
          <a href="" onclick="ocultar_login_sign_up()"><i class="fas fa-arrow-left"></i></a>
          <h2><fmt:message key="text.registration" /></h2>
     
         <fmt:message key="text.login" var="login" />


             <div class="container2"   id="failRegistr"></div>
           <form action="/TaxisProject/registration" method="post" >
          <input type="text" name="username" placeholder="${login}" required />
          <input type="password" name="password" placeholder="${password}"  required />
         
          <button class="btn_sign_up" onclick="cambiar_sign_up()"><fmt:message key="text.singUp" /></button></form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html> 