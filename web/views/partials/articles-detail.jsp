<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<%@include file="../common/head.jsp"%>
<body>

<%@include file="../common/header.jsp"%>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">Blog</h1>
        <p class="lead blog-description">Article detail.</p>
    </div>

    <div class="row">

        <div class="col-sm-12 blog-main">

            <div class="blog-post">
                <h2 class="blog-post-title"><c:out value="${article.title}"/></h2>
                <p class="blog-post-meta"><c:out value="${article.date}"/> by <a href="#"><c:out value="${article.author.email}"/></a></p>
                <p><c:out value="${article.content}"/></p>
            </div><!-- /.blog-post -->

        </div><!-- /.blog-main -->
        
    </div>
</div>

<%@include file="../common/footer.jsp"%>

</body>
</html>
