<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/20/2015
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../common/head.jsp"%>
<body>

<%@include file="../common/header.jsp"%>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">Write an article</h1>
    </div>

    <div class="row">

        <div class="col-sm-12 blog-main">

            <c:forEach var="article" items="${articles}">
                <div class="blog-post">
                    <h2 class="blog-post-title"><a href="${pageContext.request.contextPath}/${routes.article}?id=${article.id}"><c:out value="${article.title}"/></a></h2>
                    <p class="blog-post-meta"><c:out value="${article.date}"/> by <a href="#"><c:out value="${article.author.email}"/></a></p>
                    <p><c:out value="${article.content}"/></p>
                </div><!-- /.blog-post -->
            </c:forEach>

        </div><!-- /.blog-main -->

    </div>
</div>

<%@include file="../common/footer.jsp"%>

</body>
</html>
