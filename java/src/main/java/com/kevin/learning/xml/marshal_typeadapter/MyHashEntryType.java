package com.kevin.learning.xml.marshal_typeadapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class MyHashEntryType {

	@XmlAttribute
	private Integer key;
	
	@XmlValue
	private String value;

	public Integer getKey() {
		return key;
	}
	

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
