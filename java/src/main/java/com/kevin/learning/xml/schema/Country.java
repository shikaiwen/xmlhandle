package com.kevin.learning.xml.schema;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name="tK",namespace="http://www.kevin.com/",
propOrder = { "name", "capital", "foundation", "continent", "population" } )
@XmlRootElement(name="Country")

public class Country {

	private String name;
	private String capital;
	private String continent;
	private int  population;
	
	
//	private int  importance;
	private LocalDate foundation;
	
	 @XmlElement (name = "Country_Population")
	    public void setPopulation( int population )
	    {
	        this.population = population;
	    }

	    @XmlElement( name = "Country_Name" )
	    public void setName( String name )
	    {
	        this.name = name;
	    }

	    @XmlElement( name = "Country_Capital" )
	    public void setCapital( String capital )
	    {
	        this.capital = capital;
	    }
//	    @XmlAttribute( name = "importance", required = true )
//	    public void setImportance( int importance )
//	    {
//	        this.importance = importance;
//	    }

	    
	    @XmlJavaTypeAdapter( MyDateAdapter.class )
	    @XmlElement(name="Country_Foundation_Date")
		public void setFoundation(LocalDate foundation) {
			this.foundation = foundation;
		}

	    @XmlElement(name="Country_Continent")
		public void setContinent(String continent) {
			this.continent = continent;
		}
	    
		public String getName() {
			return name;
		}

		public String getCapital() {
			return capital;
		}


		public String getContinent() {
			return continent;
		}

		public int getPopulation() {
			return population;
		}

//		public int getImportance() {
//			return importance;
//		}

		public LocalDate getFoundation() {
			return foundation;
		}


	
	
	
}
