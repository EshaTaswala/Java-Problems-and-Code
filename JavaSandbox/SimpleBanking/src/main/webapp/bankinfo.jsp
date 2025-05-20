<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bank Information</title>
</head>
<body>
    <h2>Bank Information</h2>
    <form action="BankInfoServlet" method="post">
        Bank Name: <input type="text" name="bankName"><br>
        Account #: <input type="text" name="accountNumber"><br>
        SSN: <input type="text" name="ssn"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>