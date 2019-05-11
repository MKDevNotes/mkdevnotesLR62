package org.mk.example.portlet.config;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String name = ParamUtil.getString(actionRequest,"name");
		String phone = ParamUtil.getString(actionRequest,"phone");
		String age = ParamUtil.getString(actionRequest,"age");
		String salary = ParamUtil.getString(actionRequest,"salary");
		
		System.out.println("name "+name);
		System.out.println("phone "+phone);
		System.out.println("age "+age);
		System.out.println("salary "+salary);
		
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		if(Validator.isNotNull(name)){
			portletPreferences.setValue("name", StringPool.TRUE);
		}
		if(Validator.isNotNull(phone)){
			portletPreferences.setValue("phone", StringPool.TRUE);
		}
		if(Validator.isNotNull(age)){
			portletPreferences.setValue("age", StringPool.TRUE);
		}
		if(Validator.isNotNull(salary)){
			portletPreferences.setValue("salary", StringPool.TRUE);
		}
		portletPreferences.store();
	}

	@Override
	public String render(PortletConfig arg0, RenderRequest arg1,
			RenderResponse arg2) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(" render under ConfigurationImpl");
		
		return "/configuration.jsp";
	}

}
