package org.mk.example.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

public class MKMultipleActionURLPortlet extends MVCPortlet {

	public final void first(final ActionRequest request, final ActionResponse response) {
		System.out.println("First");
		request.setAttribute("message", "First Button is Called.....");
	}
	
        public final void second(final ActionRequest request, final ActionResponse response) {
		System.out.println("Second");
		request.setAttribute("message", "Second Button is Called.....");
	}
	
}
