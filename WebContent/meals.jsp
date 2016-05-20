<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.gcproject.ezpz.*"%>
<%@ page import = "org.jsoup.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Easy Peasy</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="brand">Easy Peasy</div>
	<div class="address-bar">Grand Circus | Java Bootcamp | Detroit,
		Michigan</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
			<a class="navbar-brand" href="index.html">Easy Peasy</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="Index.html">Home</a></li>

				<li><a href="blog.html">Blog</a></li>
				<li><a href="recipes.html">Recipes</a></li>
				<li><a href="about.html">About</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<div class="container">

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Easy Peasy <strong>meals</strong>
					</h2>
					<hr>
				</div>
				<div class="col-lg-12 text-center">
					<h2>
						Meal <br> <small>A Good Replacement Meal Would Be:</small>
					</h2>
					<%
						String[] meals = new String[4];
						String[] nutrition = new String[6];
						String meal = (String) request.getAttribute("meal");
						meals = EZPZDao.getData(meal);
						String veggie = meals[2];
						nutrition = EZPZDao.getNutrition(veggie);
						String summary = ParseHTML.getTitle(meals[1]);

						out.println("<h3>" + meals[0] + "</h3>");
						out.println("<p>" + summary + "</p>");
						out.println("<a href = '"+ meals[1]+"'> Veiw Full Recipe Here</a>");
						out.println("<h5>Main Ingredient: " + nutrition[0] +"</h2>");
						out.println("<h5>Protein: " + nutrition[1] +"</h2>");
						out.println("<h5>Carbs: " + nutrition[2] +"</h2>");
						out.println("<h5>Fiber: " + nutrition[3] +"</h2>");
						out.println("<h5>Calories: " + nutrition[4] +"</h2>");
						
						
					%>







					<hr>
				</div>


			</div>
		</div>
	</div>

	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<p>Copyright &copy; Easy Peasy 2016</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
