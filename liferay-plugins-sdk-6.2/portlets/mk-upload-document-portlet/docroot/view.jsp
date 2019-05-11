<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />

<portlet:actionURL var="uploadURL" name="uploadDocumentFile"/>
<portlet:resourceURL var="downloadURL"/>
<liferay-ui:success key="success" message="File Upload Successfully"/>
<liferay-ui:error key="failure" message="Upload Error"/>
<liferay-ui:error key="file.extension.error" message="Upload only text File" />

This is the <b>MK Upload Document Example</b> portlet.

<b>Please Upload a Text Document</b>
<br>
<form action="${uploadURL}" method="post" enctype="multipart/form-data">
	<input type="file" name="textFile"/> <br>
	<input type="Submit" name="Submit"/>
</form>

<br>
<a href="${downloadURL}">Click Here for Download</a>