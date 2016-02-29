package com.kevin.learning.xml.marshal_typeadapter;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement(name="Foo")
public class Foo {
	
    @XmlElement(name="map")
	@XmlJavaTypeAdapter(MyHashMapAdapter.class)
	public MyHashMapType hashMap;

	public MyHashMapType getHashMap() {
		return hashMap;
	}

	public void setHashMap(MyHashMapType hashMap) {
		this.hashMap = hashMap;
	}

	
	
}
