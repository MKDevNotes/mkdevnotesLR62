package org.mk.liferay.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MKPreferencesEditModeController extends MVCPortlet {

	protected String viewTemplate;
	protected String editTemplate;

	public void init() throws PortletException {
		// TODO Auto-generated method stub
		viewTemplate = getInitParameter(MKGenericPortletConstant.VIEW_JSP);
		editTemplate = getInitParameter(MKGenericPortletConstant.EDIT_JSP);
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		System.out.println("DoEdit Method Called...");

		getMKPreferenseValue(renderRequest);

		include(editTemplate, renderRequest, renderResponse);
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		System.out.println("DoView Method Called...");

		getMKPreferenseValue(renderRequest);

		include(viewTemplate, renderRequest, renderResponse);
	}

	@ProcessAction(name = "updatePreferenceAction")
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		String userSelectedCurrency = ParamUtil.getString(actionRequest,
				"userSelectCurrency");
		portletPreferences.setValue("userSelection", userSelectedCurrency);
		portletPreferences.store();
		actionResponse.setPortletMode(PortletMode.VIEW);
	}

	/*
	 * https://asbnotebook.wordpress.com/2016/06/04/simple-generic-portlet-example
	 * -with-liferay/
	 * 
	 * public void processAction(ActionRequest actionRequest, ActionResponse
	 * actionResponse)throws PortletException, IOException { PortletPreferences
	 * prefs = actionRequest.getPreferences(); String newParameter =
	 * actionRequest.getParameter("newPreference");
	 * 
	 * prefs.setValue("editablePref", newParameter); prefs.store();
	 * 
	 * actionResponse.setPortletMode(PortletMode.VIEW); }
	 */
	private void getMKPreferenseValue(RenderRequest renderRequest) {
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		String[] currencies = portletPreferences.getValues("Currency",
				new String[] {});

		List<String> currenciesList = new ArrayList<String>();
		for (String currency : currencies) {
			currenciesList.add(currency);
		}

		String stock = portletPreferences.getValue("StockSymbol",
				StringPool.BLANK);
		String state = portletPreferences.getValue("State", StringPool.BLANK);

		renderRequest.setAttribute(MKGenericPortletConstant.CURRENCY_LIST,
				currenciesList);
		renderRequest
				.setAttribute(MKGenericPortletConstant.STOCK_SYMBOL, stock);
		renderRequest.setAttribute(MKGenericPortletConstant.STATE, state);

		String userSelection = portletPreferences.getValue("userSelection",
				StringPool.BLANK);
		renderRequest.setAttribute("userSelection", userSelection);
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
