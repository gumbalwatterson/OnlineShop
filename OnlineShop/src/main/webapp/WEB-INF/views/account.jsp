<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
    
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


</style>
</head>
<body>

<div class="header">

<div class="container">
<div class="navbar">

<div class="logo">    
 <img src="glogo.png" width="300px"/>
  </div>  
      <nav>
      <ul>     
        <li> Welcome! user name </li>
        <li><a href="#">Home</a></li>
        <li><a href="#">Search</a></li>
	<li><a href="#">About</a></li>
       </ul>
     </nav>
    <img src="cartempty.png" width="30px" height="30px"/>
     </div>
</div>
</div>

<!--  products -->
<div class="products">
<div class="small-container">
<h2 class= "title" >Products</h2>
	
<div class="row">

<div class="col-1">
	<img src="product1.png"  width="300px"  />
	<h4> product name</h4>
	<p>$20.00</p>
	</div>
<div class="col-1">
	<img src="product2.png"  width="300px"  />
	<h4> product name</h4>
	<p>$20.00</p>
	</div>
<div class="col-1">
	<img src="product3.png"  width="300px"/>
	<h4> product name</h4>
	<p>$20.00</p>
	</div>
	
<div class="col-1">
	<img src="product4.png" width="300px"  />
	<h4> product name</h4>
	<p>$20.00</p>
	</div>
	
<div class="col-1">
	<img src="product5.png" width="300px" />
	<h4> product name</h4>
	<p>$20.00</p>
	</div>

<div class="col-1">
	<img src="product6.png" width="300px"  />
	<h4> product name</h4>
	<p>$20.00</p>
	</div>	

</div>   <!--  end of row -->
</div>  <!--  end of small-container -->

</div>


<!--  footer -->


<div class ="footer">
<div class ="container">

<div class="row">

<div class="footer-col-1">
<img src="glogo.png"/>
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


    