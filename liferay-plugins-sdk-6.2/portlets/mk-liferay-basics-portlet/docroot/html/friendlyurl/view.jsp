<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<!-- Action URL  -->
<portlet:actionURL var="addEmployeeURL" name="addEmployee">
</portlet:actionURL>

<!-- Delete URL  -->
<portlet:actionURL var="deleteEmployeeURL" name="deleteEmployee">
<portlet:param name="userId" value="1"/>
</portlet:actionURL>

<!-- Render URLs -->
<portlet:renderURL var="viewRenderURL">
 <portlet:param name="mvcPath" value="/html/friendlyurl/view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="displayRenderURL">
 <portlet:param name="mvcPath" value="/html/friendlyurl/display.jsp"/>
</portlet:renderURL>

<a href="<%= addEmployeeURL%>">Add URL</a><br>
<a href="<%= deleteEmployeeURL%>">Delete URL</a><br>
<a href="<%= viewRenderURL%>">Go to View </a><br>
<a href="<%= displayRenderURL%>">Go to Display</a><br>