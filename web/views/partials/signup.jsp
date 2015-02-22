<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../common/head-signin.jsp"%>
<body>

<div class="container">

    <form class="form-signin" method="post">
        <h2 class="form-signin-heading">Sign up</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>

</div>

<%@include file="../common/footer-signin.jsp"%>

</body>
</html>
