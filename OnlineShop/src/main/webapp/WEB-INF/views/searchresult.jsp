<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html>

<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

*{
margin:0;
padding:0;
box-sizing: border-box;
}

body{
font-family: 'Poppins' , sans-serif;
}
.navbar{
display: flex;
align-items: center;
padding: 20px;
 }
 
 nav{
 flex: 1;
 text-align: right;
 }
 nav ul{
display: inline-block;
list-style-type: none;
 }
nav ul li{
display: inline-block;
margin-right: 20px;

}
a{
text-decoration: none;
color: #555;
}

p{
color: #555;
}

.container{
max-width: 1300px;
margin: auto;
padding-left: 25px;
padding-right: 25px;
}

.navbar li a:hover{
color: white;

}

.row{

display: flex;
align-items: center;
flex-wrap: wrap;
justify-content: space-around;

}

.header{
	background: radial-gradient(#33E6FF,#D6E0FF);
height: 250px;

}

<!--
.header .row{
margin-top: 70px;
}
-->

.products{
margin: 70px 0;


}

.col-1{
flex-basis: 30%;
min-width: 250px;
margin-bottom: 50px;
padding: 10px;
transition: transform 0.5s;
}

.col-1 img{
width: 100%;
}

.small-container{
max-width: 1080px;
margin:auto;
padding-left: 25px;
padding-right: 25px;

}

.title{
text-align: center;
margin: 0 auto 80px;
position: relative;
line-height: 60px;
color: #555;
}

.title::after{
content: '';
background: #ff523b;
width: 80px;
height: 5px;
border-radius: 5px;
position: absolute;
bottom: 0;
left: 50%;
transform: translateX(-50%);

}

h4{
color: #555;
font-weight: normal;
}

.col-1 p{
font-size: 14px;
}

.col-1:hover{
transform: translateY(-5px);
}

.footer{
background: #000;
color: #8a8a8a;
font-size: 14px;
padding: 60px 0 20px;

}

.footer p{
color: #8a8a8a;
}
.footer h3{
color: #fff;
margin-bottom: 20px;
}

.footer-col-1 , .footer-col-2 , .footer-col-3{
min-width: 250px;
margin-bottom: 20px;
}

.footer-col-1{
flex: 1;
text-align: center;
}

.footer-col-1 img{
width: 180px;
margin-bottom: 20px;

}
.footer-col-2 , .footer-col-3{
flex-basis: 12%;
text-align: center;
}

ul{
list-style-type: none;
}

.footer hr{
border: none;
background: #b5b5b5;
height: 1px;
margin: 20px 0;

}

.copyright{
text-align: center;
}


.searchbar{
width: 100%;
max-width: 300px;
display: inline-flex;
}

.searchbar__input{
flex-grow: 1;
padding: 10px
outline: none;
border: 1px solid #0A52F7;
border-radius: 5px 0 0 5px;
background: #F3F4FB;
transition: background 0.25s, box-shadow 0.25s;
font-family: 'Poppins' , sans-serif;
}

.searchbar__input:focus{
background: #fff;
box-shadow: 0 0 2px #0A52F7; 
}

.searchbar__input::placeholder{
font-family: 'Poppins' , sans-serif;
color:#0A52F7 

}

.searchbar__button{

width:40px;
background: #0A52F7;
color: #fff;
outline: none;
border: none;
display: flex;
align-items: center;
justify-content: center; 
border-radius: 0 5px 5px 0;
cursor: pointer;
user-select: none;

}

.searchbar__button:active{
box-shadow: insert 0 0 30px rgba(0, 0, 0, 0.25);
}


</style>
</head>
<body>

<div class="header">

<div class="container">
<div class="navbar">

<div class="logo">    
 <img src=<spring:url value="/img/glogo.png"/> width="300px"/>
  </div> 
  		  
      <nav>
      <ul>
       <sec:authorize access="isAuthenticated()">
 		<li>	Welcome, <sec:authentication property="name"/></li>
  		  </sec:authorize>
  		       
        <li><a href="#">Home</a></li>
      
        <li><a href="#">About</a></li>
      
  		<sec:authorize access="!isAuthenticated()">
        <li><a href="<spring:url value="/log"/>">Account</a></li>    
       </sec:authorize>
    
    	<sec:authorize access="isAuthenticated()">
        <li><a href="<spring:url value="/useraccount"/>">Account</a></li>    
       </sec:authorize>
       
       </ul>
     </nav>
     
       <form action="search" method="get">

      <div class="searchbar">      
      <input type="text" class="searchbar__input" placeholder="Search..." name="find">
       <button type="submit" class="searchbar__button"><i class="material-icons">search</i></button>
	</div>  
  </form>
  
   <a href="<spring:url value="/cart"/>" > <img src=<spring:url value="/img/cartempty.png"/> width="30px" height="30px"/></a>
     </div>
</div>
</div>

<!--  products -->
<div class="products">
<div class="small-container">
<h2 class= "title" >Products</h2>
	
<div class="row">

<c:if test="${iteams != null}">
<c:forEach var="iteam" items="${iteams}">


<div class="col-1">
<a href="<spring:url value="/test?seller=${iteam.seller}&id=${iteam.id}"/>">
	<img src="data:image/png;base64,${iteam.imgUtility}"  width="300px"  />
	</a>
	<h4> ${iteam.itemname}</h4>
	<p>
	<fmt:formatNumber value="${iteam.price}" minFractionDigits="2" type="currency" ></fmt:formatNumber>
	</p>
	<p>Seller:${iteam.sellername}</p>
	
	</div>
</c:forEach>
</c:if>

</div>   <!--  end of row -->
</div>  <!--  end of small-container -->

<h2 class= "title" >featured</h2>
</div>


<!--  footer -->


<div class ="footer">
<div class ="container">

<div class="row">

<div class="footer-col-1">
<img src=<spring:url value="/img/glogo.png"/>/>
<p> GumbalShop offers many products around the world </p>
</div>

<div class="footer-col-2">
<h3> Useful links </h3>
<ul>

<li>Coupons</li>
<li>Return Policy</li>
<li>Join Affiliate</li>

</ul>
</div>

<div class="footer-col-3">
<h3> Follow us </h3>
<ul>

<li>Facebook</li>
<li>Instagram</li>
<li>Tweater</li>

</ul>
</div>


</div> <!--  end of row -->

<hr>
<p class="copyright"> Copyright 2020 GumbalShop </p>

</div> <!--  end of container -->
</div> <!--  end of footer -->

</body>
</html>
