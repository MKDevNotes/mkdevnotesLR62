<%@ include file="init.jsp" %>
<portlet:actionURL  var="updatePreferenceActionURL" >
	<portlet:param name="action" value="updatePreferenceAction"/>
</portlet:actionURL>
<aui:form action="${updatePreferenceActionURL}" method="post" name="<portlet:namespace />fm">
    <aui:layout>          
         <aui:fieldset>
           <aui:column>
				<aui:select name="userSelectCurrency">
				<c:forEach items="${CurrencyList}" var="currency">
					<aui:option value="${currency}">${currency}</aui:option>
				</c:forEach>
				</aui:select>
           </aui:column>
          </aui:fieldset>
     </aui:layout>
	<aui:layout>        <aui:button type="submit" value="Save"  /></aui:layout>
</aui:form>