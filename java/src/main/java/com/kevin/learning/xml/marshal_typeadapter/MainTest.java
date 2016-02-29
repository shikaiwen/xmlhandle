package com.kevin.learning.xml.marshal_typeadapter;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Test;

public class MainTest {

	
	@Test
	public void testMarshal() {
		try{
			Foo fo = new Foo();
//			HashMap<Integer,String> mymap = new HashMap<Integer,String>();
//			mymap.put(1, "kevin");
//			mymap.put(2, "dak");
//			fo.hashMap = mymap;
			
			MyHashMapType hashMapType = new MyHashMapType();
			
			MyHashEntryType entry1 = new MyHashEntryType();
			MyHashEntryType entry2 = new MyHashEntryType();
			
			entry1.setKey(1);entry1.setValue("kevin");
			entry2.setKey(2);entry2.setValue("2323");
			
			hashMapType.getEntryList().add(entry1);
			hashMapType.getEntryList().add(entry2);
//			mymap.put(1, "kevin");
//			mymap.put(2, "dak");
			fo.hashMap = hashMapType;
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Foo.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(fo, System.out);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
