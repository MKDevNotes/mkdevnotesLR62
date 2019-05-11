<%@ include file="init.jsp"%>
<script src="/html/js/liferay/service.js" language="Javacript"> </script>

<portlet:renderURL var="addUserActionURL">
	<portlet:param name="action" value="addUser"></portlet:param>
</portlet:renderURL>

<div align="right">
	<input type="button" value="View User"
		onClick="javascript:self.location='<portlet:renderURL><portlet:param name="VIEW_PAGE" value="viewUserDetailList" /></portlet:renderURL>'" />
</div>

<style>
/*.mk-container {
	color: #fff !important;
	background-color: #009688 !important;
	box-shadow: 0 4px 10px 0 rgba(0, 0, 0, 0.2), 0 4px 20px 0
		rgba(0, 0, 0, 0.19);
	padding: 5px 0px 5px 10px;
}
*/
.mk-border {
	border: 1px solid #ccc !important;
}

input[type=text] {
	padding: 8px;
	display: block;
	border: none;
	border-bottom: 1px solid #ccc;
	width: 100%;
}
</style>

<div class="mk-container">
	<h2>Employee Registration</h2>
</div>
<div class="formContainer">
	<aui:form>
		<aui:layout>
			<aui:fieldset>
				<aui:column>
					<aui:input name="firstName" label="First Name">
						<aui:validator name="alpha" />
					</aui:input>
					<aui:input name="lastName" label="Last Name">
						<aui:validator name="alpha" />
					</aui:input>
					<aui:input type="text" name="dob" id="dob" label="Date of Birth">
						<aui:validator name="required" />
					</aui:input>
					<aui:field-wrapper name="gender">
						<aui:input checked="<%=true%>" inlineLabel="right" name="gender"
							type="radio" value="Male" label="male" />
						<aui:input inlineLabel="right" name="gender" type="radio"
							value="female" label="female" />
					</aui:field-wrapper>
					<aui:input type="text" name="email" label="Email">
						<aui:validator name="email" />
						<aui:validator name="required" />
					</aui:input>
					<aui:input type="text" name="phoneNo" label="Phone No">
						<aui:validator name="digits" />
						<aui:validator name="required" />
					</aui:input>
					<aui:input type="textarea" name="address" label="Address">
						<aui:validator name="required" />
					</aui:input>
					<aui:button type="submit" value="Save" />
				</aui:column>
			</aui:fieldset>
		</aui:layout>
	</aui:form>
</div>