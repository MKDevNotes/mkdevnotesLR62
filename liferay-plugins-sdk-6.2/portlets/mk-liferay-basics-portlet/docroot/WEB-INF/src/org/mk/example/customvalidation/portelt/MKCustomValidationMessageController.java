package org.mk.example.customvalidation.portelt;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.mk.example.customvalidation.bean.UserRegisteraion;

import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKCustomValidationMessageController
 */
public class MKCustomValidationMessageController extends MVCPortlet {
	
	public void userRegister(ActionRequest request, ActionResponse response) {
		
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request,"lastName");
		String email = ParamUtil.getString(request,"email");
		String contactNumber = ParamUtil.getString(request,"contactNumber");
		String country = ParamUtil.getString(request,"country");
		String subject = ParamUtil.getString(request,"subject");
		
		System.out.println("FirstName "+firstName+"\n LastName "+lastName+"\n Country "+country+"\n Email "+email);
		
		UserRegisteraion user = new UserRegisteraion(firstName,lastName,email,contactNumber,country,
				subject);
		List<String>errors = validate(user, request);
		if(errors.size() == 0){
		      	System.out.println("Successfully Created");
		}else{
		    PortletConfig portletConfig = (PortletConfig)request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	            SessionMessages.add(request, ((LiferayPortletConfig)portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	            request.setAttribute("user", user);
	            request.setAttribute("errors", errors);
}
		
	}
	
	public List<String> validate(UserRegisteraion user,ActionRequest request){
		List<String>errors  = new ArrayList<String>();
		ResourceBundle bundle= getPortletConfig().getResourceBundle(request.getLocale());
		if(!Validator.isName(user.getFirstName())){
	 	 errors.add(bundle.getString("firstName.errorMsg.missing"));	
		}
		if(!Validator.isName(user.getLastName())){
			errors.add(bundle.getString("lastName.errorMsg.missing"));	
		}
		if(!Validator.isEmailAddress(user.getEmail())){
			errors.add(bundle.getString("email.errorMsg.missing"));		
		}
		if(!Validator.isPhoneNumber(String.valueOf(user.getContactNumber()))){
			errors.add(bundle.getString("phone.errorMsg.missing"));	
		}
        
		 return errors;
}

}
