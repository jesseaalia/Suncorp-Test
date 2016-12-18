<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create new DENOMINATION</title>
<link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
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

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    $(document).ready(function() {
      
      $('#newDenominationForm').submit(function(event) {
    	  
    	  var hundredNotes = $('#hundredNotes').val();
    	  var fiftyNotes = $('#fiftyNotes').val();
    	  var twentyNotes = $('#twentyNotes').val();
    	  var json = { "hundredNotes" : hundredNotes, "fiftyNotes" : fiftyNotes, "twentyNotes": twentyNotes};
    	  
        $.ajax({
        	url: $("#newDenominationForm").attr( "data-url"),
        	data: JSON.stringify(json),
        	type: "POST",
        	
        	beforeSend: function(xhr) {
        		xhr.setRequestHeader("Accept", "application/json");
        		xhr.setRequestHeader("Content-Type", "application/json");
        		$(".error").remove();
        	},
        	success: function(denom) {
        		var respContent = "";
        		var tot=parseInt(denom.hundredNotes)*100 + parseInt(denom.fiftyNotes)*50 + parseInt(denom.twentyNotes)*20  ;
		  		respContent += "<span class='success'>ATM CASH DENOMINATION: [ Hundred Notes : ";
		  		respContent += denom.hundredNotes + " Fifty Notes : ";
		  		respContent += denom.fiftyNotes + " Twenty Notes: " ;
		  		respContent += denom.twentyNotes + " ToTal Cash : "+  tot + "]</span>";
        		 
        		$("#sPhoneFromResponse").html(respContent);   		
        	},
        	error: function(jqXHR, textStatus, errorThrown) {
        		var respBody = $.parseJSON(jqXHR.responseText);
        		var respContent = "";
        		
        		respContent += "<span class='error-main'>";
        		respContent += respBody.message;
        		respContent += "</span>";
        		
        		$("#sPhoneFromResponse").html(respContent);
        		
        		$.each(respBody.fieldErrors, function(index, errEntity) {
        			var tdEl = $("."+errEntity.fieldName+"-info");
        			tdEl.html("<span class=\"error\">"+errEntity.fieldError+"</span>");
        		});
        	}
        });
         
        event.preventDefault();
      });
       
    });   
  </script>
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
<h1>Enter Denomination:</h1>
<div>
<div id="sPhoneFromResponse"></div>
</div>
<form:form id="newDenominationForm" data-url="${pageContext.request.contextPath}/denominations/create.json" commandName="denom">
<table>
<tbody>
<tr>
<td>hundredNotes:</td>
<td><form:input path="hundredNotes" /></td>
<td class="model-info"></td>
</tr>
<tr>
<td>fiftyNotes:</td>
<td><form:input path="fiftyNotes" /></td>
<td class="price-info"></td>
</tr>
<tr>
<td>twentyNotes:</td>
<td><form:input path="twentyNotes" /></td>
<td class="price-info"></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>


</form:form>
</div>
</body>
</html>