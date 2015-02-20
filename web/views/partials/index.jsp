<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 2/20/2015
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head.jsp"%>
</head>
<body>

<%@include file="../common/header.jsp"%>

<div class="container-fluid">
    <div class="row">

        <%@include file="../common/sidebar.jsp"%>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Dashboard</h1>

            <%--Place here your content--%>
            <h1 class="page-header">Index</h1>
            
            ${test}
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp"%>

</body>
</html>
