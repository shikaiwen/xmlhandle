package com.kevin.learning.xml.schema;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

@SuppressWarnings("rawtypes")
public class MyDateAdapter extends XmlAdapter{

	@Override
	public LocalDate unmarshal(Object v) throws Exception {
		String str = v.toString();
		return LocalDate.parse(str);
	}

	@Override
	public String marshal(Object v) throws Exception {
		
		return v.toString();
	}

}
