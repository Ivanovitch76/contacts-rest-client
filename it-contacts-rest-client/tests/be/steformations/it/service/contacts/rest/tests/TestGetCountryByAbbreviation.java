package be.steformations.it.service.contacts.rest.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.it.java_data.contacts.dto.CountryDto;
import be.steformations.it.service.contacts.rest.ContactRestClient;

public class TestGetCountryByAbbreviation {

	ContactRestClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactRestClient();
	}

	@Test
	public void testGetCountryByAbbreviation() {
		CountryDto usa = new CountryDto();
		usa.setId(1);
		usa.setAbbreviation("US");
		usa.setName("Etats-Unis");
		
		CountryDto found = this.client.getCountryByAbbreviation("US");
		assertEquals(usa, found);
	}

}
