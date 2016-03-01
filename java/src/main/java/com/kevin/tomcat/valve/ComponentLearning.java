package com.kevin.tomcat.valve;

import org.apache.catalina.Pipeline;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.core.StandardPipeline;
import org.apache.catalina.core.StandardWrapper;

/**
 * Tomcat源码分析教程：http://www.ibm.com/developerworks/cn/java/j-lo-tomcat1/
 * Valve的实现分析：http://gearever.iteye.com/blog/1536022
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
		StandardWrapper wrapper;   //wrapper就封装了servlet信息并负责调用servlet
		
		//每个对象都有一个StandardPipeLine
		Pipeline pipeline;
		StandardPipeline standardPipeline;
		
	}
}
