<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<portlet:resourceURL  var="loginURL"/>

<portlet:renderURL var="succcessURL">
<portlet:param name="path" value="success"/>
</portlet:renderURL>

<portlet:defineObjects />

This is the <b>Mk Ajax Controller</b> portlet in View mode.

<script type="text/javascript">
function submitForm(){
    AUI().use('aui-io-request', function(A){
    	alert("Hello");
    	A.io.request('<%=loginURL.toString()%>', {
            method: 'post',
            form: {
                id: 'form'
            },
            on: {
                 success: function() {
                  var data = this.get('responseData');
                  var content= JSON.parse(data);
                  alert(content.name);
                  alert(content.password);
                  window.location.href = "${succcessURL}"+'&name='+content.name+'&password='+content.password;
                 }
            }
         });
 });
}
 </script>
<b>Please Fill the Details</b>

<form name="form" id="form">
Name : <input type="text" name="name"><br>
Password :<input type="password" name="password"><br> 
<input type="button" value="SUBMIT" onclick="submitForm()">  
</form>
