<%-- 
    Document   : newjsp
    Created on : 04/04/2021, 11:08:33 AM
    Author     : kaushikdeshpande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<link href="css/style.css" rel="stylesheet">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&display=swap" rel="stylesheet">
		<style>
         .welcome_title{
			filter: drop-shadow(0px 3px 6px rgba(0, 0, 0, 0.161));
                left: 99px;
                top: 201px;
                position: absolute;
                overflow: visible;
                width: 1279px;
                white-space: nowrap;
                text-align: left;
                font-family: Helvetica Neue;
                font-style: normal;
                font-weight: normal;
                font-size: 50px;
                color: rgba(112,112,112,1);
				left: 700px;
				top: 120px;
          



          			 
		 }
		 .welcome_email{
			filter: drop-shadow(0px 3px 6px rgba(0, 0, 0, 0.161));
                left: 99px;
                top: 201px;
                position: absolute;
                overflow: visible;
                width: 1279px;
                white-space: nowrap;
                text-align: left;
                font-family: Helvetica Neue;
                font-style: normal;
                font-weight: normal;
                font-size: 25px;
                color: rgba(112,112,112,1);
				left: 850px;
				top: 220px;
          		 
		 }
		#Box_2 {
		fill: #183e7c;
		stroke: rgba(112,112,112,1);
		stroke-width: 1px;
		stroke-linejoin: miter;
		stroke-linecap: butt;
		stroke-miterlimit: 4;
		shape-rendering: auto;
	}
	.Box_2 {
		overflow: visible;
		position: absolute;
		width: 473px;
		height: 129px;
		left: 390px;
		top: 601px;
		transform: matrix(1,0,0,1,0,0);
	}
	#Return_to_Shopping_ {
		left: 424px;
		top: 646px;
		position: absolute;
		overflow: visible;
		width: 407px;
		white-space: nowrap;
		text-align: center;
		font-family: Helvetica Neue;
		font-style: normal;
		font-weight: normal;
		font-size: 35px;
		color: rgb(255, 255, 255);
	}
	#Box_3 {
		fill: #183e7c;
		stroke: rgba(112,112,112,1);
		stroke-width: 1px;
		stroke-linejoin: miter;
		stroke-linecap: butt;
		stroke-miterlimit: 4;
		shape-rendering: auto;
	}
	.Box_3 {
		overflow: visible;
		position: absolute;
		width: 473px;
		height: 129px;
		left: 1029px;
		top: 601px;
		transform: matrix(1,0,0,1,0,0);
	}
	#View_Account {
		left: 1063px;
		top: 646px;
		position: absolute;
		overflow: visible;
		width: 407px;
		white-space: nowrap;
		text-align: center;
		font-family: Helvetica Neue;
		font-style: normal;
		font-weight: normal;
		font-size: 35px;
		color: rgb(255, 255, 255);
	}







		</style>
	</head>	
	<body>
		<div class="navbar">
			<div class="logo"><img src="assets/logo.png"/></div>
			<ul>
				<a href="#"><li>Home</li></a>
				<a href="#"><li>Store</li></a>
				<a href="#"><li>About</li></a>
				<a href="#"><li>Contact</li></a>
				<a href="#"><li class="login">Sign up / Login</li></a>
			</ul>
		</div>
		<div class="welcome_title">
			<span> Welcome "Account name"      </span>

			</div>
		<div class="welcome_email">
				<span> Email: "Customers Email" </span>
	
				</div>
		<div >

			<button type="button" onclick="alert('Hello world!')">
					<svg class="Box_2" viewBox="0 0 473 129">
						<path id="Box_2" d="M 22 0 L 451 0 C 463.1502685546875 0 473 9.849735260009766 473 22 L 473 107 C 473 119.1502685546875 463.1502685546875 129 451 129 L 22 129 C 9.849735260009766 129 0 119.1502685546875 0 107 L 0 22 C 0 9.849735260009766 9.849735260009766 0 22 0 Z">
						</path>
					</svg>
					<div id="Return_to_Shopping_">
						<span>Return to Shopping </span>
					</div>
			</button>

			<button type="button" onclick="alert('Hello world!')">
					<svg class="Box_3" viewBox="0 0 473 129">
						<path id="Box_3" d="M 22 0 L 451 0 C 463.1502685546875 0 473 9.849735260009766 473 22 L 473 107 C 473 119.1502685546875 463.1502685546875 129 451 129 L 22 129 C 9.849735260009766 129 0 119.1502685546875 0 107 L 0 22 C 0 9.849735260009766 9.849735260009766 0 22 0 Z">
						</path>
					</svg>
					<div id="View_Account">
						<span>View Account</span>
					</div>
				
			</button>
		</div>
		
	<footer>
			<p>Copyright Not Group 14 2021</p>
	</footer>
</html>
