package org.mk.example.multipleaction.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKMultipleActionPortlet
 */
public class MKMultipleActionPortlet extends MVCPortlet {

	public void firstMethod(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		String first = ParamUtil.getString(request, "first");
		System.out.println("First=>" + first);
	}

	public void secondMethod(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		String second = ParamUtil.getString(request, "second");
		System.out.println("second=>" + second);
	}

}
