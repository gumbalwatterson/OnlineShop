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
small-container price{
margin: 0px 0px ;

}

.small-container h1{
margin: 0px 0px 20px ;

}

.small-container h4{
font-weight: bold;
margin: 0px 0px 0px ;
font-size: 22px;
}

.small-container .col-1 img{
padding: 0;
}

.small-container{
margin-top: 80px;
}

.small-container .col-1 {
padding: 10px;

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
        <li><a href="#">Home</a></li>
        <li><a href="#">Search</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Account</a></li>    
       </ul>
     </nav>
    <img src="cartempty.png" width="30px" height="30px"/>
     </div>
</div>
</div>

<!--  products -->
<div class="products">
<div class="small-container">
<h2 class= "title" >Product</h2>
	
<div class="row">

<div class="col-1">
	<img src="product1.png"  width="300px"  />
</div>

<div class="col-1">
	
	<p> product name</p>
	<h1>simple throuusers</h1>
	<p class="price"> price</p>
	<h4>$20.00</h4>

<a href="" class="btn2"> view pictures collection </a>
<h3>product details</h3>
</br>
<p>details about the product bla bla dfghhgfhfdsjicdsji ji djis  ji jids dsji jdsi</p>

<a href="" class="btn"> add to cart</a>
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


    