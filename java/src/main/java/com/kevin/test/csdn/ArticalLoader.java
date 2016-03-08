package com.kevin.test.csdn;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ArticalLoader {

	public static void main(String[] args) throws IOException{
//		getList();
//		getRawContent();
		getList();
	}
	
	public static String getRawContent() throws IOException{
//		HttpURLConnection conn = (HttpURLConnection)new URL("http://www.csdn.net/").openConnection();
		HttpURLConnection conn = (HttpURLConnection)new URL("http://blog.csdn.net/shikaiwencn?viewmode=contents").openConnection();
		
//		conn.setRequestProperty("Accept", "text/html, application/xhtml+xml, */*");
//		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.8,zh-Hans-CN;q=0.5,zh-Hans;q=0.3");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko");
//		conn.setRequestProperty("Host", "blog.csdn.net");
		
		InputStream is = conn.getInputStream();
		byte [] bytes = new byte[100];
		int len = 0;
		StringBuilder content = new StringBuilder();
		while( (len=is.read(bytes)) > 0 ){
			content.append( new String(bytes,0,len,"utf-8")  );
		}
		
//		System.out.println( content.toString() );
		return content.toString();
	}
	
	public static void getList() throws IOException{
//		Document doc = Jsoup.connect("http://blog.csdn.net/shikaiwencn?viewmode=contents").get();
		Document doc = Jsoup.parse( getRawContent() );
		
		Elements elts = doc.select("#article_list .list_item");
		Iterator<Element> iter = elts.iterator();
		for(;iter.hasNext();){
			
			Element elt = iter.next();
			Elements contentItem = elt.getElementsByClass("link_title");
			Element a = contentItem.get(0).child(0);
			String href = a.attr("href");
			String title = a.html();
			System.out.println(title + "\t" + href );
		}
			
		
		
		System.out.println(elts.size());
	}
	
	
	
	
	
}
