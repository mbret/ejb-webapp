<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item" href="${pageContext.request.contextPath}/${routes.index}">Index</a>
            <a class="blog-nav-item" href="${pageContext.request.contextPath}/${routes.profile}">Profile</a>
            <a class="blog-nav-item" href="${pageContext.request.contextPath}/${routes.folders}">Folders</a>
            <a class="blog-nav-item" href="${pageContext.request.contextPath}/${routes.writeArticle}">Write an article</a>
            <a class="blog-nav-item pull-right" href="${pageContext.request.contextPath}/${routes.logout}">Logout</a>
        </nav>
    </div>
</div>