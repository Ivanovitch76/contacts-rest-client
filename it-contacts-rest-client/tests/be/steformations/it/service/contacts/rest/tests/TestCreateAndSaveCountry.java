package be.steformations.it.service.contacts.rest.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.steformations.it.java_data.contacts.dto.CountryDto;
import be.steformations.it.service.contacts.rest.ContactRestClient;

public class TestCreateAndSaveCountry {

	ContactRestClient client;
	
	@Before
	public void setUp() throws Exception {
		this.client = new ContactRestClient();
	}

	@Test
	public void testCreateAndSaveCountry() {
		long millis = System.currentTimeMillis();
		String abbreviation = "AU-" + millis;
		String name = "Australie-" + millis;
		
		CountryDto received = this.client.createAndSaveCountry(abbreviation, name);
		assertNotNull(received);
		assertNotNull(received.getId());
		assertEquals(abbreviation, received.getAbbreviation());
		assertEquals(name, received.getName());
		
		CountryDto found = this.client.getCountryByAbbreviation(abbreviation);
		assertEquals(received, found);
	}

}
