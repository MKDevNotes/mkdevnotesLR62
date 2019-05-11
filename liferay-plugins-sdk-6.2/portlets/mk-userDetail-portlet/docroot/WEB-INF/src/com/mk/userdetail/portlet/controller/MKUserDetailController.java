package com.mk.userdetail.portlet.controller;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MKUserDetailController extends MVCPortlet{

	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		// TODO Auto-generated method stub

		String page = ParamUtil.getString(renderRequest, "VIEW_PAGE",
				"viewUserDetailList");
		
		System.out.println("page "+page);

		if (Validator.isNotNull(page)) {

			if (page.equalsIgnoreCase("viewUserDetailList")) {
				include(viewTemplate, renderRequest, renderResponse);
			} else if (page.equalsIgnoreCase("editUserDetail")) {
				include("/html/userDetail/editUserDetail.jsp", renderRequest,
						renderResponse);
			} else if (page.equalsIgnoreCase("viewUserDetail")) {
				include("/html/employee/viewEmployeeList.jsp", renderRequest,
						renderResponse);
			}
		}

	}
}
