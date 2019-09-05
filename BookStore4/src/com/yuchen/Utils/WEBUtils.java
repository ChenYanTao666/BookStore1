package com.yuchen.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WEBUtils {
	public static String getPath(HttpServletRequest request, HttpServletResponse response){
		// 获取域名
		String requeURI = request.getRequestURI();
		// 获取请求参数
		String prev = request.getQueryString();
		String path =  requeURI  + "?"+ prev;
		if (path.contains("&pageNum")) {
			path = path.substring(0,path.indexOf("&pageNum"));
		}
		System.out.println(path);
		return path;
	}

}
