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
           
        <div id="myContainer">
            <div id="Welcome__Account_Name">
                <span>Welcome “ Account Name”</span>
            <!-- This button is for Viewing the Cart-->
            <button type="button" onclick="alert('Hello world!')" > 
                <svg class="Rectangle_1">
                    <rect id="Rectangle_1" rx="0" ry="0" x="0" y="0" width="300" height="300">
                    </rect>
                </svg> 

                <div id="_View_Cart">
                    <span> View Cart</span>
                </div>
                <svg class="ic_shopping_basket_24px" viewBox="1 2.02 115.911 100">
                    <path id="ic_shopping_basket_24px" d="M 86.40567016601562 38.79555130004883 L 63.32875823974609 4.232855796813965 C 62.32770538330078 2.75761890411377 60.64171600341797 2.019999980926514 58.95573425292969 2.019999980926514 C 57.26974868774414 2.019999980926514 55.58376312255859 2.75761890411377 54.58271408081055 4.285542964935303 L 31.50579452514648 38.79555130004883 L 6.268703937530518 38.79555130004883 C 3.370917320251465 38.79555130004883 0.9999999403953552 41.16646575927734 0.9999999403953552 44.06425476074219 C 0.9999999403953552 44.53843688964844 1.052686929702759 45.01262283325195 1.210747957229614 45.48680877685547 L 14.59325504302979 94.32769012451172 C 15.80505847930908 98.75340270996094 19.86196136474609 102.0199966430664 24.70916748046875 102.0199966430664 L 93.20231628417969 102.0199966430664 C 98.04952239990234 102.0199966430664 102.1064224243164 98.75339508056641 103.3709106445312 94.32769012451172 L 116.7534255981445 45.48680877685547 L 116.9114837646484 44.06425476074219 C 116.9114837646484 41.16646575927734 114.5405502319336 38.79555130004883 111.6427764892578 38.79555130004883 L 86.40567016601562 38.79555130004883 Z M 43.14963150024414 38.79555130004883 L 58.95574188232422 15.61325550079346 L 74.76184844970703 38.79555130004883 L 43.14963150024414 38.79555130004883 Z M 58.95574188232422 80.94518280029297 C 53.16016387939453 80.94518280029297 48.41833114624023 76.20334625244141 48.41833114624023 70.40777587890625 C 48.41833114624023 64.61219787597656 53.16016387939453 59.87036514282227 58.95574188232422 59.87036514282227 C 64.75131225585938 59.87036514282227 69.49314117431641 64.61219787597656 69.49314117431641 70.40777587890625 C 69.49314117431641 76.20334625244141 64.75131225585938 80.94518280029297 58.95574188232422 80.94518280029297 Z">
                    </path>
                    </svg>





            </button>

            <!-- This button is for Viewing Orders-->
            <button type="button" onclick="alert('Hello world!')" > 
                <svg class="Rectangle_2">
                    <rect id="Rectangle_2" rx="0" ry="0" x="0" y="0" width="300" height="300">
                    </rect>
                </svg> 

                <div id="View_Orders">
                    <span>View Orders</span>
                </div>
                <svg class="ic_assignment_24px" viewBox="3 1 90 100">
                    <path id="ic_assignment_24px" d="M 83 11 L 62.09999465942383 11 C 59.99999237060547 5.200000286102295 54.49999237060547 1 47.99999618530273 1 C 41.49999618530273 1 35.99999618530273 5.199999332427979 33.89999771118164 11 L 12.99999904632568 11 C 7.499998569488525 11 2.999999046325684 15.50000095367432 2.999999046325684 21 L 2.999999046325684 90.99999237060547 C 2.999999046325684 96.5 7.499998569488525 101 12.99999904632568 101 L 83 101 C 88.5 101 93 96.5 93 90.99999237060547 L 93 21 C 93 15.50000095367432 88.5 11 83 11 Z M 47.99999618530273 11 C 50.74999618530273 11 52.99999618530273 13.25000095367432 52.99999618530273 16 C 52.99999618530273 18.75000190734863 50.74999618530273 21 47.99999618530273 21 C 45.24999237060547 21 42.99999237060547 18.75000190734863 42.99999237060547 16 C 42.99999237060547 13.24999904632568 45.24999237060547 11 47.99999618530273 11 Z M 57.99999237060547 81 L 22.9999942779541 81 L 22.9999942779541 70.99999237060547 L 57.99999237060547 70.99999237060547 L 57.99999237060547 81 Z M 73 61 L 22.9999942779541 61 L 22.9999942779541 50.99999618530273 L 73 50.99999618530273 L 73 61 Z M 73 41 L 22.9999942779541 41 L 22.9999942779541 30.99999618530273 L 73 30.99999618530273 L 73 41 Z">
                    </path>
                </svg>





            </button>

            <!-- This button is for Account Details -->

            <button type="button" onclick="alert('Hello world!')" > 
                <svg class="Rectangle_4">
                    <rect id="Rectangle_4" rx="0" ry="0" x="0" y="0" width="300" height="300">
                    </rect>
                </svg> 

                <div id="Account_Details">
                    <span>Account Details</span>
                </div> 
                    <svg class="ic_person_outline_24px" viewBox="4 4 100 100">
                    <path id="ic_person_outline_24px" d="M 54 15.875 C 61.25 15.875 67.125 21.75 67.125 29 C 67.125 36.25 61.25000762939453 42.12500381469727 54 42.12500381469727 C 46.74999237060547 42.12500381469727 40.87499618530273 36.25 40.87499618530273 29 C 40.87499618530273 21.75 46.74999237060547 15.875 54 15.875 M 54 72.125 C 72.5625 72.125 92.125 81.25 92.125 85.25 L 92.125 92.125 L 15.875 92.125 L 15.875 85.25 C 15.875 81.25 35.43750381469727 72.125 54 72.125 M 54 4 C 40.1875 4 29 15.1875 29 29 C 29 42.8125 40.1875 54 54 54 C 67.8125 54 79 42.8125 79 29 C 79 15.1875 67.8125 4 54 4 Z M 54 60.25 C 37.3125 60.25 4 68.625 4 85.25 L 4 104 L 104 104 L 104 85.25 C 104 68.625 70.6875 60.25 54 60.25 Z">
                    </path>
                </svg>
            </button>

             <!-- This button is for Submitting a ticket -->
             <button type="button" onclick="alert('Hello world!')" > 
                <svg class="Rectangle_3">
                    <rect id="Rectangle_3" rx="0" ry="0" x="0" y="0" width="1436" height="185">
                    </rect>
                </svg>
                <div id="Submit_Support_Ticket">
                    <span>Submit Support Ticket</span>
                </div>
            </button>

            <button type="button" onclick="alert('Hello world!')" > 
                    
                <div class="logout">
                    <span>Logout</span>
                </div>

                </button>

            
        </div>
		
		
	</body>

	
</html>