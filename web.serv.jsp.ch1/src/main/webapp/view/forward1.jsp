<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:useBean id="user" class="com.jdc.web.serv.jsp.ch1.User" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<jsp:setProperty property="name" name="user" value="${ param['name'] }"/>

<jsp:forward page="forward2.jsp"></jsp:forward>