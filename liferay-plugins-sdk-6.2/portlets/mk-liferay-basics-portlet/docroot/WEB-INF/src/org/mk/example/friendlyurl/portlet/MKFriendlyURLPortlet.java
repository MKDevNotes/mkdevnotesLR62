package org.mk.example.friendlyurl.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKFriendlyURLPortlet
 */
public class MKFriendlyURLPortlet extends MVCPortlet {

	public void addEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("Add Method");
	}

	public void deleteEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("Delete Method=>"
				+ ParamUtil.getInteger(actionRequest, "userId"));
	}

}
