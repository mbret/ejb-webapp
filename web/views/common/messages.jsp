<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object errors = request.getAttribute("errors");
    if( errors != null ){
        if(errors instanceof String){ %>
    <div class="hidden notification" data-type="error"><% out.println(errors); %></div>
<%}
else{
    for (String key: ((HashMap<String, String>)errors).keySet()){%>
    <div class="hidden notification" data-type="error"><% out.println(((HashMap<String, String>) errors).get(key)); %></div>
<%}
}
}%>

<%
    Object success = request.getAttribute("success");
    if( success != null ){
        if(success instanceof String){ %>
<div class="hidden notification" data-type="success"><% out.println(success); %></div>
<%}
else{
    for (String key: ((HashMap<String, String>)success).keySet()){%>
<div class="hidden notification" data-type="success"><% out.println(((HashMap<String, String>) success).get(key)); %></div>
<%}
}
}%>