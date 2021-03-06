package com.kevin.learning.xml.schema;

import java.io.File;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import org.w3c.dom.Node;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import test.*;

public class SchemaValidateLearn1 {

	// This sample application demonstrates how to enable validation during
    // the unmarshal operations. 
    public static void main(String[] args) {
        try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance("test");

            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);

            try {
                Schema schema = sf.newSchema(new File("po.xsd"));
                u.setSchema(schema);
                u.setEventHandler(
                        new ValidationEventHandler() {
                            // allow unmarshalling to continue even if there are errors
                            public boolean handleEvent(ValidationEvent ve) {
                                // ignore warnings
                                if (ve.getSeverity() != ValidationEvent.WARNING) {
                                    ValidationEventLocator vel = ve.getLocator();
                                    System.out.println(
                                            "Line:Col[" + vel.getLineNumber()
                                            + ":" + vel.getColumnNumber()
                                            + "]:" + ve.getMessage());
                                }

                                return true;
                            }
                        });
            } catch (org.xml.sax.SAXException se) {
                System.out.println(
                        "Unable to validate due to following error.");
                se.printStackTrace();
            }

            // unmarshal an invalid po instance document into a tree of Java
            // content objects composed of classes from the primer.po package.
            System.out.println(
                    "NOTE: This sample is working correctly if you see validation errors!!");

            Object poe = u.unmarshal(new File("po.xml"));

            // even though document was determined to be invalid unmarshalling,
            // marshal out result.
            System.out.println("");
            System.out.println("Still able to marshal invalid document");

            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(poe, System.out);
        } catch (UnmarshalException ue) {
            // The JAXB specification does not mandate how the JAXB provider
            // must behave when attempting to unmarshal invalid XML data.  In
            // those cases, the JAXB provider is allowed to terminate the 
            // call to unmarshal with an UnmarshalException.
            System.out.println("Caught UnmarshalException");
        } catch (JAXBException je) {
            je.printStackTrace();
        }
    }
}
