<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Personal Information</title>
</head>
<body>
    <h2>Personal Information</h2>
    <form action="PersonalInfoServlet" method="post">
        FirstName: <input type="text" name="firstName"><br>
        LastName: <input type="text" name="lastName"><br>
        MiddleName: <input type="text" name="middleName"><br>
        Gender:
        <input type="radio" name="gender" value="male"> Male
        <input type="radio" name="gender" value="female"> Female<br>
        <input type="submit" value="Next">
    </form>
</body>
</html>