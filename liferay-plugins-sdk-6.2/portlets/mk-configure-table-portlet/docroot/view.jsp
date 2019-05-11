<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="javax.portlet.PortletPreferences"%>
<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
String name = (String)prefs.getValue("name", "false");
String phone = (String)prefs.getValue("phone", "false");
String age = (String)prefs.getValue("age", "false");
String salary = (String)prefs.getValue("salary", "false");

System.out.println("name "+name);
System.out.println("phone "+phone);
System.out.println("age "+age);
System.out.println("salary "+salary);

%>

<h4>For Show/Hide Columns:- <br>Click on Gear->Configuration->Set Up</h4><br>

<table border="1" cellpadding="8">
  <tr>
   <c:if test='<%=name.equalsIgnoreCase("true") %>'>
    <th ><h3> Name </h3></th>
   </c:if>
     
   <c:if test='<%=phone.equalsIgnoreCase("true") %>'>
      <th><h3> Phone </h3></th>
   </c:if>
    
    <c:if test='<%=age.equalsIgnoreCase("true") %>'>
        <th><h3> Age </h3></th>
    </c:if>
     
    <c:if test='<%=salary.equalsIgnoreCase("true") %>'>
       <th><h3> Salary </h3></th> 
    </c:if> 
  </tr>
</table>