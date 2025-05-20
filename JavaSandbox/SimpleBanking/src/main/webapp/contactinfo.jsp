<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Information</title>
</head>
<body>
    <h2>Contact Information</h2>
    <form action="ContactInfoServlet" method="post">
        Address: <input type="text" name="address"><br>
        City: <input type="text" name="city"><br>
        State: <input type="text" name="state"><br>
        Country: <input type="text" name="country"><br>
        Phone: <input type="text" name="phone"><br>
        <input type="submit" value="Next">
    </form>
</body>
</html>