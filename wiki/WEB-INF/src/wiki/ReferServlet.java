package wiki;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;

import java.applet.*;
import java.awt.*;

import java.net.URL;
import java.net.InetAddress;
import java.net.UnknownHostException;

import sw.DBManager;
import wiki.WikiPage;

public class ReferServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		
		String name = req.getParameter("name");
		
		InetAddress address = InetAddress.getLocalHost();
		String addr = address.getHostAddress(); 
		
		try{
			if(name != null){
				
				//WikiPageDAOから名前と一致するデータを取得
				WikiPage wikiPage = WikiPageDAO.getInstance().findByName(name);
				System.out.println(wikiPage);
				HttpSession session = req.getSession();
				String imageurl="http://" + addr + ":8080/image/"+wikiPage.getPath();
				session.setAttribute("wikiPage",wikiPage);
				session.setAttribute("path",imageurl);
				
				//System.out.println("rsPath2=" +path);
				}
			
			req.getRequestDispatcher("/refer.jsp").forward(req,res);
		
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}




        

       