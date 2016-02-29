package com.kevin.learning.xml.marshal_typeadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyHashMapAdapter extends XmlAdapter<ArrayList<MyHashEntryType>,MyHashMapType> {

	@Override
	public MyHashMapType unmarshal(ArrayList<MyHashEntryType> v) throws Exception {
		
		if(v == null) return null;
		MyHashMapType mapType = new MyHashMapType();
		
		for(int i = 0;i < v.size();i++){
			mapType.getEntryList().add(v.get(i));
		}
//		HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
//		if(v == null) return null;
//		for(int i = 0; i < v.size();i++){
//			MyHashEntryType entry = v.get(i);
//			hashMap.put( entry.getKey() , entry.getValue());
//		}
		return mapType;
	}

	@Override
	public ArrayList<MyHashEntryType> marshal(MyHashMapType v) throws Exception {
//		ArrayList<MyHashEntryType> entryList = new ArrayList<MyHashEntryType>();
		
		return v.getEntryList();
		
//		for(Integer key : v.keySet()){
//			MyHashEntryType t = new MyHashEntryType();
//			t.setKey(key);
//			t.setValue(v.get(key));
//			entryList.add(t);
//		}
//		MyHashMapType mapType = new MyHashMapType();
//		ArrayList<MyHashEntryType> entryList = new ArrayList<MyHashEntryType>();
//		for(Integer key : v.keySet()){
//			MyHashEntryType entryType = new MyHashEntryType();
//			entryType.setKey(key);
//			entryType.setValue(v.get(key));
//			
//			entryList.add(entryType);
//			mapType.getEntryList().add(entryType);
//		}
//		return mapType;
	}

}
