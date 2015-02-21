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

            <div class="blog-frame" data-example-id="simple-horizontal-form" >
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Title</label>
                        <div class="col-sm-10">
                            <input type="email" name="title" class="form-control" id="inputEmail3" placeholder="Title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Content</label>
                        <div class="col-sm-10">
                            <textarea name="content" rows="10" class="form-control" id="inputPassword3" placeholder="Write your article here"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Submit</button>
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
