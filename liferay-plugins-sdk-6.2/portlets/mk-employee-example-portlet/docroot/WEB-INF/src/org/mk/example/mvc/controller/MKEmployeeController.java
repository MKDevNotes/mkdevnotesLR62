package org.mk.example.mvc.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MKEmployeeController extends MVCPortlet {

	protected String viewTemplate;

	public void init() throws PortletException {
		// TODO Auto-generated method stub
		viewTemplate = getInitParameter(MKEmployeePortletConstant.VIEW_JSP);
	}

	@ProcessAction(name = "newEmployee")  
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.processAction(actionRequest, actionResponse);
	}
	
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		// TODO Auto-generated method stub

		String page = ParamUtil.getString(renderRequest, "VIEW_PAGE",
				"viewEmployeeList");
		
		System.out.println("page "+page);

		if (Validator.isNotNull(page)) {

			if (page.equalsIgnoreCase("viewEmployeeList")) {
				include(viewTemplate, renderRequest, renderResponse);
			} else if (page.equalsIgnoreCase("editEmployee")) {
				include("/html/employee/editEmployee.jsp", renderRequest,
						renderResponse);
			} else if (page.equalsIgnoreCase("viewEmployee")) {
				include("/html/employee/viewEmployeeList.jsp", renderRequest,
						renderResponse);
			}
		}

	}

	public void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		PortletRequestDispatcher dispatcher = getPortletContext()
				.getRequestDispatcher(path);
		if (!(dispatcher == null)) {
			dispatcher.forward(renderRequest, renderResponse);
		}
	}

}
