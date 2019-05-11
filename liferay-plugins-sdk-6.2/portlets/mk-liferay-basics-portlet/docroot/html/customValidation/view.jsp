<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />
<portlet:actionURL var="register" name="userRegister">
</portlet:actionURL>

<div id="error">
	<c:if test="${!empty errors}">
		<ul>
		<c:forEach items="${errors}"  var="error" >
			<li style="color: red"><c:out value="${error}"></c:out></li>
		</c:forEach>
		</ul>
	</c:if>
</div>

<body>
	<div class="formContainer">
		<form action="${register}" method="post">
			<div class="tableRow">
				<div class="col-25">
					<label for="fname">First Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="<portlet:namespace/>firstName" name="<portlet:namespace/>firstName"
						placeholder="Your name..">
				</div>
			</div>
			<div class="tableRow">
				<div class="col-25">
					<label for="lname">Last Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="<portlet:namespace/>lastName" name="<portlet:namespace/>lastName"
						placeholder="Your last name..">
				</div>
			</div>
			<div class="tableRow">
				<div class="col-25">
					<label for="email">Email</label>
				</div>
				<div class="col-75">
					<input type="text" id="<portlet:namespace/>email" name="<portlet:namespace/>email"
						placeholder="Your Email..">
				</div>
			</div>
			<div class="tableRow">
				<div class="col-25">
					<label for="<portlet:namespace/>contactNumber">Contact Number</label>
				</div>
				<div class="col-75">
					<input type="text" id="<portlet:namespace/>contactNumber" name="<portlet:namespace/>contactNumber"
						placeholder="Your Contact Number..">
				</div>
			</div>
			<div class="tableRow">
				<div class="col-25">
					<label for="<portlet:namespace/>country">Country</label>
				</div>
				<div class="col-75">
					<select id="<portlet:namespace/>country" name="<portlet:namespace/>country">
						<option value="">---Select Country---</option>
						<option value="india">India</option>
						<option value="australia">Australia</option>
						<option value="canada">Canada</option>
						<option value="usa">USA</option>
					</select>
				</div>
			</div>
			<div class="tableRow">
				<div class="col-25">
					<label for="subject">Subject</label>
				</div>
				<div class="col-75">
					<textarea id="<portlet:namespace/>subject" name="<portlet:namespace/>subject"
						placeholder="Write something.." style="height: 200px"></textarea>
				</div>
			</div>
			<div class="tableRow">
				<div class="button-col-25">
					<input type="submit" value="Submit">
				</div>
				<div class="button-col-75"></div>
			</div>
		</form>
	</div>
</body>
