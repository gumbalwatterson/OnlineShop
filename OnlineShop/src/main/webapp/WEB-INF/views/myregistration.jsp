<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

<html>
<head>
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

.account-page{

padding: 50px 0;
background: radial-gradient(#fff, #ffd6d6);
}

.form-container{
background: #fff;
width: 300px;
height: 400px;
position: relative;
text-align: center;
padding: 20px 0;
margin: auto;
box-shadow: 0 0 20px 0px rgba(0,0,0,0.1);
}

.form-container span{
font-weight: bold;
padding: 0 10px;
color: #555;
cursor: pointer;
width: 100px;
display: inline-block;
}

.form-btn{
display: inline-block;
}

.form-container form{
max-width: 300px;
padding: 0 20px;
position: absolute;
top: 130px;
}

form input{
width: 100%;
height: 30px;
margin: 10px 0;
padding: 0 10px;
border: 1px solid #ccc;

}

form .btn{
width: 100%;
border: none;
cursor: pointer;
margin: 10px 0;

}

form .btn:focus{
outline: none;
}


form a{
font-size: 12px;
}

.btn{
display: inline-block;
background: #ff523b;
color: #fff;
padding: 8px 30px;
margin: 30px 0px;
border-radius: 30px;
transition: background 0.5s;
}

.btn2{
display: inline-block;
background: #0A52F7;
color: #fff;
padding: 8px 30px;
margin: 30px 0px;
border-radius: 30px;
transition: background 0.5s;
}

.btn2:hover{
background: #563434;
}

.btn:hover{
background: #563434;
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

.error_message{
color: #FE0000;
font-weight: normal;
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
        <li><a href="#">Home</a></li>
        <li><a href="#">Search</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Account</a></li>    
       </ul>
     </nav>
    <img src=<spring:url value="/img/cartempty.png"/> width="30px" height="30px"/>
     </div>
</div>
</div>

<!--  register page -->

<div class="account-page">
<div class="container">
<div class="row">

<div class="col-2">
	<img src=<spring:url value="/img/gumball.png"/> width="100%" />
</div>

<div class="col-2">
	<div class="form-container">
	<div class="form-btn">
	<h2 class="title"> Registration</h2>	
	</div>

<form:form name="f" modelAttribute="user" action="regprocess" method="POST">

  <c:if test="${error != null}">
            <div class="error_message">
                Failed to login. User already exist.
                
            </div>
        </c:if>

<spring:hasBindErrors name="user"  ><div class="error_message"> uncorrect details</div></spring:hasBindErrors>

<form:input type="text" path="name" placeholder="Name"/>
<form:input type="text" path="lastname" placeholder="Lastname"/>
<form:input type="email" path="email" placeholder="Email"/>
<form:input type="password" path="password" placeholder="Password"/>
<form:button type="submit" class="btn">Register</form:button>
</form:form>	


</div>
</div>

</div> <!-- end of row -->

</div> <!--  end of container -->

</div> <!--  end of account-page -->


<!--  footer -->


<div class ="footer">
<div class ="container">

<div class="row">

<div class="footer-col-1">
<img src=<spring:url value="glogo.png"/>/>
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


    
    