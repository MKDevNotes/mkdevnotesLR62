<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:renderURL var="savePreferensesRenderURL" windowState="normal" portletMode="edit">
</portlet:renderURL>
<%
String portletResource = ParamUtil.getString(request, "portletResource");
PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource); 
if (Validator.isNotNull(preferences)) {
preferences = renderRequest.getPreferences();
}
String dateFormat = preferences.getValue("dateFormat",null);
%>
<h1> Add Portlet Preferenses</h1>
<form action="<%=savePreferensesRenderURL%>" name="savePreferenses"  method="POST">
Expected Date Format<br/>
<input  type="text" name="<portlet:namespace/>prefdateformat"<portlet:namespace/>prefdateformat" value='<%=dateFormat!=null?dateFormat:StringPool.BLANK%>'/><br/>
<input type="submit" name="savepref" id="savepref" value="Save Preferenses"/>
</form>