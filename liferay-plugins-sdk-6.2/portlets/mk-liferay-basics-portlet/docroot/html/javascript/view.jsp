<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects/>
<portlet:defineObjects />
 
Enter User Name: <input name="<portlet:namespace/>userName" type="text"  id="<portlet:namespace/>userName" />

<a id="renderURL" href="javascript:void(0);"> Click here</a>

<!-- Code for Link -->
<aui:script>
AUI().use('liferay-portlet-url', function(A) {
	var linkValue = A.one("#renderURL");
	var userName = A.one('#<portlet:namespace/>userName');
	linkValue.on('click', function(A) {
	var renderUrl1 = Liferay.PortletURL.createRenderURL();
	renderUrl1.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	renderUrl1.setParameter("userName", userName.val());
	window.location.href = renderUrl1;
		});
	});
</aui:script>

<input type="button" value="Submit" onclick="renderCall()">
<!-- Code for Button -->
<script type="text/javascript">
function renderCall(){
	AUI().use('aui-io-request', function(A){
	var userName = A.one('#<portlet:namespace/>userName');
	var renderUrl1 = Liferay.PortletURL.createRenderURL();
	renderUrl1.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
	renderUrl1.setParameter("userName", userName.val());
	window.location.href = renderUrl1;
    });
}
</script>