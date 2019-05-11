
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />

This is the
<b>Mk Client Side Validation Controller</b>
portlet in View mode.

<liferay-theme:defineObjects />
<portlet:defineObjects />
<aui:form name="fm2" action="" method="post">

	<aui:field-wrapper>
		<aui:column columnWidth="15">
			<label>Employee Name :<span style="color: red;"> *</span></label>
		</aui:column>
		<aui:column columnWidth="35">
			<aui:input name="employeeName" type="text" label="" inlineLabel="true">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</aui:column>
	</aui:field-wrapper>
	<aui:button type="submit" name="save" value="Save" />
</aui:form>




<%-- <aui:input name="userName" value='' label="User Name">
		<aui:validator name="required" />
		<aui:validator name="alphanum" />
	</aui:input>
	<aui:input name="firstName" value='' label="First Name">
		<aui:validator name="required" />
		<aui:validator name="alpha" />
	</aui:input>
	<aui:input name="lastName" value='' label="Last Name">
		<aui:validator name="alpha" />
	</aui:input>
	<aui:input name="email" value='' label="Email">
		<aui:validator name="email" />
	</aui:input>
	<aui:input name="date" value='' label="Date of Birth">
		<aui:validator name="date"></aui:validator>
	</aui:input>
	<aui:input name="phoneNumber" value='' label="Phone Number">
		<aui:validator name="digits"></aui:validator>
		<aui:validator name="minLength">8</aui:validator>
		<aui:validator name="maxLength">10</aui:validator>
	</aui:input>
	<aui:input name="price" value='' label="Price Range">
		<aui:validator name="number"></aui:validator>
		<aui:validator name="min">200</aui:validator>
		<aui:validator name="max">1000</aui:validator>
	</aui:input>
	<aui:input name="password1" id="password1" value='' label="Password"
		type="password">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:input name="password2" value='' label="Re Type Password"
		type="password">
		<aui:validator name="required" />
		<aui:validator name="equalTo">'#<portlet:namespace />password1'</aui:validator>
	</aui:input>
	<aui:input name="webSite" value='' label="Website Address">
		<aui:validator name="url" />
	</aui:input>
	<aui:input name="age" value='' label="Age">
		<aui:validator name="custom" errorMessage="You must have 18 years or more">
			function (val, fieldNode, ruleValue) {
				var result = false;
				//alert(val);
					if (val >=18) {
						result = true;
					}
					return result;
			}
		</aui:validator>
	</aui:input> --%>