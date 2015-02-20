<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/20/2015
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li><a href="${pageContext.request.contextPath}/${routes.index}">Index</a></li>
        <li><a href="${pageContext.request.contextPath}/${routes.articles}">Articles</a></li>
        <li><a href="${pageContext.request.contextPath}/${routes.folders}">Folders</a></li>
        <li><a href="${pageContext.request.contextPath}/${routes.subscribe}">Subscribe</a></li>
        <li><a href="${pageContext.request.contextPath}/${routes.writeArticle}">Write an article</a></li>
    </ul>
</div>
