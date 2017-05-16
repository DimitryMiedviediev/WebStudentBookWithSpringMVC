<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Student Profile</title>

    <!-- Bootstrap CSS-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>

    <!-- Develops CSS -->
    <%--<link href="../css/font_style.css" rel="stylesheet">--%>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


</head>

<body>
<div style="margin-top: 200px"></div>

<div class="container">
    <div class="row">

        <div class="col-sm-4"></div>
        <div class="col-sm-4">

            <h2 class="form-signin-heading text-center">Реєстрація</h2>

            <form:form action="createNewUser" method="POST" modelAttribute="user">
                <div class="form-group ${error}">
                    <form:input path="username" type="text" class="form-control" placeholder="Ім'я користувача"/>
                    <form:input path="email" type="email" class="form-control" placeholder="Електронна адреса"/>
                    <form:input path="password" type="password" class="form-control" placeholder="Пароль"/>
                </div>

                <input type="submit" class="btn btn-lg btn-default btn-block" value="Зареєстуватись">
                <%--TODO Добавить поле Confirm password, проверку сделать JS--%>
            </form:form>

            <a href="/authentication/sign_in">Авторизуватись</a>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

</body>
</html>