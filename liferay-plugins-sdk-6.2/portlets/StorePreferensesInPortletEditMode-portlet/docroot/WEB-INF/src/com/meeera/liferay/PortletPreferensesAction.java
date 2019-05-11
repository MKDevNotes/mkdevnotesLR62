package com.meeera.liferay;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PortletPreferensesAction
 */
public class PortletPreferensesAction extends MVCPortlet {
	 @Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String dateFormat = ParamUtil
				.getString(renderRequest, "prefdateformat");
		System.out.println("====" + dateFormat);
		PortletPreferences preferences = renderRequest.getPreferences();
		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");
		if (Validator.isNotNull(portletResource) && (preferences == null)) {
			try {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(
						renderRequest, portletResource);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		preferences.setValue("dateFormat", dateFormat);
		preferences.store();
		SessionMessages.add(renderRequest,"potlet-config-saved");
		super.doEdit(renderRequest, renderResponse);
		
	}
	
}
