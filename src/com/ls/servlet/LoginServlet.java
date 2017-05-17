package com.ls.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 验证输入验证码的正确性
 * @author ls
 * @date 2017年5月9日
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7543385137577080694L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String piccode = (String)request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode"); 
		PrintWriter out = response.getWriter();
		if(checkcode.equalsIgnoreCase(piccode)){
			out.print("验证码输入正确！");
		}else{
			out.println("验证码输入错误！");
		}
		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request,response);
	}
}
