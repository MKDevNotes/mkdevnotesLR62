package org.mk.example.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MKUploadDocumentPortlet extends MVCPortlet {
	final String liferayFilePath = "/home/muthukumar/liferayTempFile";
	public final void uploadDocumentFile(ActionRequest request,
			ActionResponse response) {
		SessionMessages.add(request,((LiferayPortletConfig)getPortletConfig()).getPortletId()+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		File file = uploadPortletRequest.getFile("textFile");
		System.out.println("file :: "+file);
		OutputStream out = null;
		InputStream in = null;
		
		try {
			MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
			String mimeType = mimeTypesMap.getContentType(file);
			System.out.println("file.getName() ::::: "+file.getName());
			if(Validator.isNotNull(mimeType) && mimeType.equalsIgnoreCase("text/plain")){
				in = new FileInputStream(file);
				System.out.println("in ::::: "+in);
				out = new FileOutputStream(new File(liferayFilePath, "hello.txt"));
				System.out.println("out ::::: "+out);
				IOUtils.copy(in, out);
				SessionMessages.add(request, "success");
			} else {
				SessionErrors.add(request, "file.extension.error");
			}
		} catch (IOException io) {
			SessionErrors.add(request, "failure");
		} finally {
			try{
				if(Validator.isNotNull(out)){
					out.flush();
					out.close();
				}
				if(Validator.isNotNull(in)){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		File outputFile = new File(liferayFilePath,"hello.txt");
		resourceResponse.setContentType("text/plain");
		resourceResponse.addProperty("Content-disposition", "atachment; filename=hello.txt");
		OutputStream out = null;
		InputStream in = null;
		try {
			out = resourceResponse.getPortletOutputStream();
			in = new FileInputStream(outputFile);
			IOUtils.copy(in, out);		
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Validator.isNotNull(out)) {
					out.flush();
					out.close();
				}
				if (Validator.isNotNull(in)) {
					in.close();
				}

			} catch (final IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
}


