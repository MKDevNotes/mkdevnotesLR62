<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<%
String defaultText = "This is Default text";
%>
<!-- Action URLs  -->
<portlet:actionURL var="submitContentURL" />

<aui:form action="<%=submitContentURL%>" method="POST">
<div class="control-group"> 
<liferay-ui:input-editor name="headline" initMethod="initHeadLineEditor" width="50" height="400" resizable="true" ></liferay-ui:input-editor>
     <aui:input type="hidden" name="headline" value='<%=defaultText %>'>
       <aui:validator name="custom" errorMessage="Please Provide HeadLine">
           function (value, fieldNode, ruleValue) {
                return validateHeadLine(value);
            }
        </aui:validator>               
     </aui:input>      
</div>                                                                                   

<input type="submit" value="SUBMIT">
</aui:form>

<aui:script>
 function <portlet:namespace/>initHeadLineEditor(){ 
	 return "<%=UnicodeFormatter.toString(defaultText)%>";
 }
 
 function validateHeadLine(value) {
    if(value != ""){
        return true;
     }
       else {
       return false;
    }

} 

</aui:script>