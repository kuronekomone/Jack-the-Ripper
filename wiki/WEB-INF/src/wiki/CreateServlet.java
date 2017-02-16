package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;

import java.net.URL;
import java.sql.*;


public class CreateServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String image = req.getParameter("path");
		
		System.out.println("csimage= " +image);
		
		//送られてきた写真のurlにフルパスになるように文字列を付与
		String url="file:"+image;
		System.out.println("csurl1="+url);
		URL imageurl = new URL(url);
		//URL オブジェクト名 = new URL(ファイル名);
		
		System.out.println("csurl2= " +imageurl);
		
		String path = imageurl.getPath();
		
		System.out.println("csurl3= " +path);
		
		try{
			//WikiPageをnewする
			WikiPage wikiPage = new WikiPage();
			
			//Jspからの情報をセット
			wikiPage.setName(name);
			wikiPage.setContent(content);
			wikiPage.setPath(path);
			
			//WikiPageDAOのインスタンスを取得し、
			//セットした内容をsql文に書き込む
			WikiPageDAO.getInstance().insert(wikiPage);
			
			//DBへのアップデート
			RequestUtils.setMessage(req, name + "を作成しました");
			
			//req.setAttribute("path",path);
			
			req.getRequestDispatcher("/refer").forward(req,res);
			
			System.out.println("csurl4= " +path);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}