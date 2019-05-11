<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<liferay-portlet:actionURL var="configurationURL" 	portletConfiguration="true" />
<portlet:defineObjects />

<liferay-ui:success key="config-stored" message="Configuration Saved Successfully" />
<form name="fm" method="post" action="<%=configurationURL.toString()%>">
	Name : <input type="checkbox" name="<portlet:namespace/>name" >	<br/>
	Phone : <input type="checkbox" name="<portlet:namespace/>phone" >	<br/>
	Age : <input type="checkbox" name="<portlet:namespace/>age" >	<br/>
	Salary : <input type="checkbox" name="<portlet:namespace/>salary" >	<br/>
	<input type="submit" value="Save">
</form>