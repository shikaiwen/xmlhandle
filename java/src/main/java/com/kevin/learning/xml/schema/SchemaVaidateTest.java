package com.kevin.learning.xml.schema;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 参考文章地址：http://www.javacodegeeks.com/2015/04/%E7%94%A8%E4%BA%8Ejava%E5%92%8Cxml%E7%BB%91%E5%AE%9A%E7%9A%84jaxb%E6%95%99%E7%A8%8B.html
 * @author root
 *
 */
public class SchemaVaidateTest {

	@Test
	public void test1(){
		try{
			ResourceLoader loader = new DefaultResourceLoader();
			Resource countryXSD = loader.getResource("classpath:country.xsd");
			
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			try {
				Schema countrySchema = factory.newSchema(countryXSD.getURL());
				try {
					Country australia = new Country();
					australia.setName("Australia");
					australia.setCapital("Camberra");
//					australia.setFoundation(LocalDate.of(1788, 01, 26));
					// australia.setContinent( "Oceania" );
					australia.setContinent("Oceania");
					// australia.setImportance( 1 );
					JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
					JAXBSource source = new JAXBSource(jaxbContext, australia);

					Validator validator = countrySchema.newValidator();
					
					//DefaultHandler 是一个Adapter 
					validator.setErrorHandler(new DefaultHandler(){
						public void warning(SAXParseException exception) throws SAXException {
							super.error(exception);
						}
						@Override
						public void error(SAXParseException e) throws SAXException {
							
							System.out.println(e.getMessage());
//							super.error(e);
						}
						@Override
						public void fatalError(SAXParseException e) throws SAXException {
							super.fatalError(e);
							System.out.println("fatal:" + e);
						}
		
					});
					
					validator.validate(source);
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
