<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<jsp:useBean class="java.lang.String" id="myActionURL" scope="request"></jsp:useBean>
<portlet:defineObjects />

This is the <b>Mk Create URL Example</b> portlet in View mode.

<h2>Test for Action URL</h2>
<br>
<a href="<%= myActionURL%>">Click Here For ActionURL</a>