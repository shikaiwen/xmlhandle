package com.kevin.tomcat.valve;

import org.apache.catalina.Pipeline;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.core.StandardPipeline;
import org.apache.catalina.core.StandardWrapper;

/**
 * TomcatԴ������̳̣�http://www.ibm.com/developerworks/cn/java/j-lo-tomcat1/
 * Valve��ʵ�ַ�����http://gearever.iteye.com/blog/1536022
 * @author root
 *
 */
public class ComponentLearning {

	public void t1(){
		
		//Connector + Container = service
		
//		Engine Host Context Wrapper
		
		StandardEngine engine;
		StandardHost host;
		StandardContext context;
		StandardWrapper wrapper;   //wrapper�ͷ�װ��servlet��Ϣ���������servlet
		
		//ÿ��������һ��StandardPipeLine
		Pipeline pipeline;
		StandardPipeline standardPipeline;
		
	}
}
