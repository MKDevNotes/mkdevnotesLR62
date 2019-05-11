<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

This is the <b>Mk Multiple Action</b> portlet in View mode.

<!-- Action URLs  -->
<portlet:actionURL var="firstActionURL"  name="firstMethod" />
<portlet:actionURL var="secondActionURL"  name="secondMethod" />

<h4>First Form</h4>
<form action="<%=firstActionURL%>" method="POST">
First :-<input type="text" name='<portlet:namespace/>first'>
<input type="submit" value="SUBMIT">
</form>
<h4>Second Form</h4>
<form action="<%=secondActionURL%>" method="POST">
Second :-<input type="text" name='<portlet:namespace/>second'>
<input type="submit" value="SUBMIT">
</form>

