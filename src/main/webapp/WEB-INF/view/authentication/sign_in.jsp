<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Sign in</title>

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
    <%--<link type="" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>--%>
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

            <h2 class="form-signin-heading text-center">Авторизація</h2>

            <form action="/trap" method="post">
                <%--<c:if test="${param.containsKey('error')}">--%>
                <%--<p class="error">Неверный логин или пароль!</p>--%>
                <%--</c:if>--%>
                <input name="username" type="text" class="form-control" placeholder="Ім'я користувача"/>
                <input name="password" type="password" class="form-control" placeholder="Пароль"/>
                <br>
                <input type="submit" class="btn btn-lg btn-default btn-block" value="Увійти">
            </form>

            <a href="/sign_up">Зареєструватись</a>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

</body>
</html>

