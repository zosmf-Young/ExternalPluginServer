package com.ibm.zoszmf.externalplugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/profile")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String prefix = null;
	private static String owner = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		json.put("prefix", prefix);
		json.put("owner", owner);
		response.getWriter().append(json.toString());
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reader reader = request.getReader();
		
//		BufferedReader br = new BufferedReader(reader);
//		String line = null;
//		StringBuilder sb = new StringBuilder();
//		while ((line = br.readLine()) != null) {
//			sb.append(line);
//		} 
//		System.out.println(sb.toString());
		
		JSONObject json = JSONObject.parse(reader);
		prefix = (String) json.get("prefix");
		owner = (String) json.get("owner");
	}

}
