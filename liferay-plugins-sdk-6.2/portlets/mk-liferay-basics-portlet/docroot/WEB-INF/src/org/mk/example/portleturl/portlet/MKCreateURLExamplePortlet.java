package org.mk.example.portleturl.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKCreateURLExamplePortlet
 */
public class MKCreateURLExamplePortlet extends MVCPortlet {

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletURL myActionURL = renderResponse.createActionURL();
		myActionURL.setParameter("name", "Liferay is Easy");
		renderRequest.setAttribute("myActionURL", myActionURL.toString());
		include(viewTemplate, renderRequest, renderResponse);
	}

	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		String name = request.getParameter("name");
		System.out.println("Name we set in URL=>" + name);
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewTemplate;
	private static Log _log = LogFactoryUtil
			.getLog(MKCreateURLExamplePortlet.class);
}
