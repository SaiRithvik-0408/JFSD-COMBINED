<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link type="text/css" rel="stylesheet" href="../../css/styles.css">
<!-- <link type="text/css" rel="stylesheet" href="css/styless.css"> -->
<link type="text/css" rel="stylesheet" href="../../css/adminhome.css">
<meta charset="UTF-8">
<title>About us</title>
</head>
<body>
<style>
/* Add these styles to your existing CSS file */

/* Styles for the admin container */
.admin__container {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  margin: 20px;
}

.blink {
  animation: blink 1s steps(1, end) infinite;
}

/* Styles for admin header */
.admin__container .section__header {
  font-size: 2rem;
  color: #333;
  margin-bottom: 20px;
  animation: fadeIn 1s ease-in-out;
}

/* Styles for admin options */
.admin__options {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.admin__options a {
  display: inline-block;
  background-color: #49c1a2;
  color: #fff;
  padding: 10px 20px;
  text-align: center;
  border-radius: 5px;
  text-decoration: none;
  transition: background-color 0.3s ease-in-out;
}

.admin__options a:hover {
  background-color: #37a08e;
  transition: background-color 0.3s ease-in-out;
  transform: scale(1.05);
}

/* Add keyframes for fadeIn animation */
@keyframes fadeIn {
  0% {
    opacity: 0;
    transform: translateY(-20px);
  }
  100% {
    opacity: 1;
    transform: translateY(0);
  }
}

</style>
<nav>
      <div class="nav__logo">Flivan</div>
      <ul class="nav__links">
        <li class="link"><a href="index.jsp">Home</a></li>
        <li class="link"><a href="login">Login</a></li>
        <li class="link"><a href="Message.jsp">ViewFlights</a></li>
      </ul>
       <a href="login.jsp"><button class="btn">Logout</button></a>
    </nav>
 <!-- About Section -->
  <div class="w3-container w3-padding-32" id="about">
    <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">About</h3>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint
      occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
      laboris nisi ut aliquip ex ea commodo consequat.
    </p>
  </div>

  <div class="w3-row-padding w3-grayscale">
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/images/client-1.jpg" alt="John" style="width:100%">
      <h3>John Doe</h3>
      <p class="w3-opacity">CEO & Founder</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/images/client-2.jpg" alt="Jane" style="width:100%">
      <h3>Jane Doe</h3>
      <p class="w3-opacity">Architect</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/images/client-3.jpg" alt="Mike" style="width:100%">
      <h3>Mike Ross</h3>
      <p class="w3-opacity">Architect</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <img src="/images/client-4.jpg" alt="Dan" style="width:100%">
      <h3>Dan Star</h3>
      <p class="w3-opacity">Architect</p>
      <p>Phasellus eget enim eu lectus faucibus vestibulum. Suspendisse sodales pellentesque elementum.</p>
      <p><button class="w3-button w3-light-grey w3-block">Contact</button></p>
    </div>
  </div>
</body>
</html>