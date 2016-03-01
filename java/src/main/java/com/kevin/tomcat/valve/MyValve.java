package com.kevin.tomcat.valve;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Globals;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

public class MyValve extends ValveBase{

	@Override
	public void invoke(Request req, Response resp) throws IOException, ServletException {
		
		String domain = this.getDomain();
		this.getNext().invoke(req, resp);
		
		String sid = req.getRequestedSessionId();
		
//        Throwable throwable =
//                (Throwable) req.getAttribute(Globals.);
		
//		resp.isCommitted()
//		resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		req.getSession()
		System.out.println("sessionid:" + sid);
		System.out.println("domain:"+domain);
	}

}
