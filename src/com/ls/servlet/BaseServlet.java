package com.ls.servlet;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6151390102454430736L;
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
}
