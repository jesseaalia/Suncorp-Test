<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Home page</title>
<link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
<style>
ul.horizontal {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #3A9FB0;;
    width: 300px;
}

ul.horizontal li {
    float: left;
}

ul.horizontal li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

ul.horizontal li a:hover:not(.active) {
    background-color: #000;
}

ul.horizontal li a.active {
    background-color:#4CAF9A;
}

ul.horizontal2 {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
}

ul.horizontal2 li {
    float: left;
}

ul.horizontal2 li a {
    display: inline-block;
    color: #666;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

ul.horizontal2 li a:hover:not(.active) {
    background-color: #ddd;
}

ul.horizontal2 a.active {
    color: white;
    background-color: #4CAF50;
}
.width94 {
width:94%;
}
@media screen and (max-width: 600px) {
    .width94 {
       width:100%;
    }
}
</style>

</head>
<body>
<div class="w3-row">
<div class="w3-col m3">
 

<ul class="horizontal gray">
  <li><a class="active" href="${pageContext.request.contextPath}/index.html">Home </a></li>
  <li><a class="active" href="${pageContext.request.contextPath}/denominations/create.html">Denomination</a></li>
   <li><a class="active" href="${pageContext.request.contextPath}/denominations/edit/1.html">WithDrawl </a></li>
</ul>
</div>
</div>

<div id="container">
<h1> Welcome To ATM CASHMAN </h1>
<p>
 
 </p>
</div>
</body>
</html>