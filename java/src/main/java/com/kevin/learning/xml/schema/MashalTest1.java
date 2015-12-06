package com.kevin.learning.xml.schema;

import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
public class MashalTest1 {

	@Test
	public void testMarshal(){
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
//		spain.setImportance( 1 );
		spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );
		spain.setPopulation( 45000000 );

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(spain, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
