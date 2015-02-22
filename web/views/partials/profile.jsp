<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<%@include file="../common/head.jsp"%>
<body>

<%@include file="../common/header.jsp"%>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">Profile</h1>
        <p class="lead blog-description">Here is your personal profile.</p>
    </div>

    <div class="row">

        <div class="col-sm-12 blog-main">

            <p>
                Email: <c:out value="${user.email}"/>
            </p>
            <p>
                <c:choose>
                    <c:when test="${user.subscriber}">
                        You are a subscriber, thanks ;)
                    </c:when>
                    <c:otherwise>
                        <a class="blog-nav-item" onclick="return confirm('Are you sure you want to subscribe ? Really sure ? sure sure sure ?');" href="${pageContext.request.contextPath}/${routes.subscribe}">Subscribe</a>
                    </c:otherwise>
                </c:choose>
            </p>


        </div><!-- /.blog-main -->
        
    </div>
</div>

<%@include file="../common/footer.jsp"%>

</body>
</html>
