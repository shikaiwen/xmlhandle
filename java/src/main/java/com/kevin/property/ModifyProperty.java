package com.kevin.property;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


/**
 * 用创建FileOutputStream时，如果文件已存在会直接将文件内容清空
 * @author root
 *
 */

public class ModifyProperty {

	public static void main(String[] args) throws Exception{
		
//		String path = "j:/t.txt";
//		String path2 = "F:/opt/pay/config/ma/commonconfigure.properties";
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(new FileInputStream(path2)));
//		String str = null;
//		while((str = br.readLine())!= null ){
//			
//			System.out.println(str);
//			
//		}
		t1();
	}
	
	public static void t1() throws Exception{
		String path = "F:/opt/pay/config/ma/commonconfigure.properties";
		FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = null ;  //new FileOutputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		PrintWriter pw = null; //new PrintWriter(new OutputStreamWriter(fos));
		String str = br.readLine();
		while( (str = br.readLine()) != null){
			String outLine = str;
			if(str.indexOf("CHARGE_CHANNEL") != -1){
				outLine = "CHARGE_CHANNEL=3";
			}
//			pw.println(outLine);
		}
		pw.close();
		fis.close();
		fos.close();
	}
}
