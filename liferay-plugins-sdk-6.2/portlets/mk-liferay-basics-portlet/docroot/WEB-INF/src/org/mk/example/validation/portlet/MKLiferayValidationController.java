package org.mk.example.validation.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.mk.example.customvalidation.bean.UserRegisteraion;

import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKLiferayValidationController
 */
public class MKLiferayValidationController extends MVCPortlet {

	public void userRegister(ActionRequest request, ActionResponse response) {

		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String email = ParamUtil.getString(request, "email");
		String contactNumber = ParamUtil.getString(request, "contactNumber");
		String country = ParamUtil.getString(request, "country");
		String subject = ParamUtil.getString(request, "subject");

		System.out.println("FirstName " + firstName + "\n LastName " + lastName
				+ "\n Country " + country + "\n Email " + email);

		UserRegisteraion user = new UserRegisteraion(firstName, lastName,
				email, contactNumber, country, subject);

		if (validate(user, request)) {
			System.out.println("Successfully Created");
		} else {

			PortletConfig portletConfig = (PortletConfig) request
					.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages
					.add(request,
							((LiferayPortletConfig) portletConfig)
									.getPortletId()
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			request.setAttribute("user", user);
		}

	}

	public boolean validate(UserRegisteraion user, ActionRequest request) {
		boolean flag = true;
		if (!Validator.isName(user.getFirstName())) {
			SessionErrors.add(request, "firstName.errorMsg.missing");
			flag = false;
		}
		if (!Validator.isName(user.getLastName())) {
			SessionErrors.add(request, "lastName.errorMsg.missing");
			flag = false;
		}
		if (!Validator.isEmailAddress(user.getEmail())) {
			SessionErrors.add(request, "email.errorMsg.missing");
			flag = false;
		}
		if (!Validator.isPhoneNumber(String.valueOf(user.getContactNumber()))) {
			SessionErrors.add(request, "phone.errorMsg.missing");
			flag = false;
		}
		return flag;
	}

}
