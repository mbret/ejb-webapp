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

            <%--Article detail--%>
            <div class="blog-post">
                <h2 class="blog-post-title"><c:out value="${article.title}"/></h2>
                <p class="blog-post-meta"><c:out value="${article.date}"/> by <a href="#"><c:out value="${article.author.email}"/></a></p>
                <p><c:out value="${article.content}"/></p>
            </div><!-- /.blog-post -->

            <%--Article comments--%>
            <div class="blog-frame" data-example-id="default-media">
                <c:forEach var="comment" items="${article.comments}">
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object" data-src="holder.js/64x64" alt="64x64" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PGRlZnMvPjxyZWN0IHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjE0LjUiIHk9IjMyIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="width: 64px; height: 64px;">
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><c:out value="${comment.author.email}"/></h4>
                            <c:out value="${comment.content}"/>
                            <p>Posted <c:out value="${comment.date}"/> </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            <%--Post comment--%>
            <div class="blog-frame" data-example-id="simple-horizontal-form">
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/${routes.postComment}">
                    <input type="hidden" name="article" value="${article.id}" />
                    <input type="hidden" name="redirect" value="${pageContext.request.contextPath}/${routes.article}?id=${article.id}" />
                    <div class="form-group">
                        <div class="col-sm-12">
                            <textarea name="content" rows="5" class="form-control" id="inputPassword3" placeholder="Write your comment here"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-default">Post your comment</button>
                        </div>
                    </div>
                </form>
            </div>
            
        </div><!-- /.blog-main -->
        
    </div>
</div>

<%@include file="../common/footer.jsp"%>

</body>
</html>
