<%-- 
    Document   : Stock
    Created on : Mar 7, 2022, 4:33:33 PM
    Author     : benray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:useBean id= "StockBean" class= "com.liam.stocks.StockBean" />
<!DOCTYPE html>

        
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Stock Details</h1>
        Name: ${emp.stockname}<br/>
        Price: ${emp.price}
    </body>
</html>
