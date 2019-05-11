<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:renderURL var="firstRenderURL">
    <portlet:param name="mvcPath" value="/html/multiplerender/first.jsp" />
</portlet:renderURL>
<portlet:renderURL var="secondRenderURL">
    <portlet:param name="mvcPath" value="/html/multiplerender/second.jsp" />
</portlet:renderURL>

<!--  ActionURLs but in Controller i use for rendering-->
<portlet:actionURL var="thirdRenderURL"  name="CustomRenderMethod">
   <portlet:param name="nameofjsp" value="third" />
</portlet:actionURL>

<portlet:actionURL var="fourthRenderURL"  name="CustomRenderMethod">
   <portlet:param name="nameofjsp" value="fourth" />
</portlet:actionURL>

<h4>First Form</h4>
<a href="${firstRenderURL}" >Go to First JSP</a><br>
<a href="${secondRenderURL}" >Go to Second JSP</a><br>

<h4>Second Form</h4>
<a href="${thirdRenderURL}" >Go to Third JSP</a><br>
<a href="${fourthRenderURL}" >Go to Fourth JSP</a>