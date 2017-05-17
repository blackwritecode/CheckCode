package com.ls.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet 生成验证码图片
 * @author ls
 * @date 2017年5月9日
 */
public class ImageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6074281583690096288L;

	public void doGet(HttpServletRequest request,HttpServletResponse response){
		BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		Color c = new Color(200,150,255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789空巢里的鸟".toCharArray(); 
		Random r = new Random();
		int len = ch.length;
		int index;
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < 4; i++){
			index = r.nextInt(len);
			
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			g.drawString(ch[index]+"", (i*15)+3, 18);
			
			sb.append(ch[index]);
		}
		
		request.getSession().setAttribute("piccode", sb.toString());
		try {
			ImageIO.write(bi, "JPG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
	}
}
