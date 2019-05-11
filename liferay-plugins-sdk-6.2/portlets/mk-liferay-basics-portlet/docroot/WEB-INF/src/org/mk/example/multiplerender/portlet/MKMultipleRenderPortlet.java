package org.mk.example.multiplerender.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKMultipleRenderPortlet
 */
public class MKMultipleRenderPortlet extends MVCPortlet {
 
	public void CustomRenderMethod(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException {
	     String nameofjsp = ParamUtil.getString(actionRequest, "nameofjsp");
	     if(nameofjsp.equalsIgnoreCase("third")){
	    	 actionResponse.setRenderParameter("mvcPath","/html/multiplerender/third.jsp");
	     }   
	     else{
	    	 actionResponse.setRenderParameter("mvcPath","/html/multiplerender/fourth.jsp");
	     }
	}

}
