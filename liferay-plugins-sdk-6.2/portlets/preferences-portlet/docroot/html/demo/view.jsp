<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="javax.portlet.PortletPreferences"%>
<portlet:defineObjects />

<% 
PortletPreferences preferences = renderRequest.getPreferences();
String state = preferences.getValue("State", "");// state is set in portlet.xml
String country = preferences.getValue("Country", "");//country is set in Demo.java
%>

<h5>Preferences from Portlet.xml</h5><br>
State  ==><%= state%><br><br>


<h5>Preferences from Java class</h5><br>
Country ==><%= country%><br><br>
