import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
	private Property property1, property2, property3, property4, property5, property6;
	private ManagementCompany management;

	@BeforeEach
	void setUp() throws Exception {
		management = new ManagementCompany("Alex Tseng", "123456789", 9);
	}

	@AfterEach
	void tearDown() throws Exception {
		management = null;
	}

	@Test
	void testAddProperty1() {
		property1 = new Property("John", "Gaithersburg", 2, "Testing", 1, 1, 1, 1);
		management.addProperty(property1);
		management.addProperty(property1);
		management.addProperty(property1);
		management.addProperty(property1);
		management.addProperty(property1);
		assertEquals(-1, management.addProperty(property1));
	}
	
	@Test
	void testAddProperty2() {
		property1 = null;
		assertEquals(-2, management.addProperty(property1));
	}
	
	@Test
	void testAddProperty3() {
		property1 = new Property();
		assertEquals(-3, management.addProperty(property1));
	}
	
	@Test
	void testAddProperty4() {
		property1 = new Property("John", "Gaithersburg", 2, "Testing", 1, 1, 1, 1);
		property2 = new Property("John", "Gaithersburg", 2, "Testing", 1, 1, 2, 2);
		management.addProperty(property1);
		assertEquals(-4, management.addProperty(property2));
	}
	
	@Test
	void testAddProperty5() {
		property1 = new Property("John", "Gaithersburg", 2, "Testing", 1, 1, 1, 1);
		assertEquals(0, management.addProperty(property1));
	}

	@Test
	void testIsPropertiesFull() {
		property1 = new Property("Hello", "There", 5, "John", 1, 1, 1, 1);
		property2 = new Property("Hello", "There", 1, "John", 2, 2, 1, 1);
		management.addProperty(property1);
		management.addProperty(property2);
		assertFalse(management.isPropertiesFull());
	}

	@Test
	void testGetPropertiesCount() {
		property1 = new Property("Hello", "There", 5, "John", 1, 1, 1, 1);
		property2 = new Property("Hello", "There", 1, "John", 2, 2, 1, 1);
		management.addProperty(property1);
		management.addProperty(property2);
		assertEquals(2, management.getPropertiesCount());
	}

	@Test
	void testGetTotalRent() {
		property1 = new Property("Hello", "There", 5, "John");
		property2 = new Property("Hello", "There", 1, "John");
		management.addProperty(property1);
		management.addProperty(property2);
		assertEquals(6.0, management.getTotalRent(), 6.0);
	}

	@Test
	void testGetHighestRentProperty() {
		property1 = new Property("Hello", "There", 5, "John");
		property2 = new Property("Hello", "There", 1, "John");
		management.addProperty(property1);
		management.addProperty(property2);
		assertEquals(100.0, management.getHighestRentProperty().getRentAmount(), 100.0);
	}

	@Test
	void testIsManagementFeeValid() {
		assertTrue(management.isManagementFeeValid());
	}

	@Test
	void testGetName() {
		assertEquals("Alex Tseng", management.getName());
	}

	@Test
	void testGetTaxID() {
		assertEquals("123456789", management.getTaxID());
	}

	@Test
	void testGetProperties() {
		property1 = new Property("Hello", "There", 5, "John", 1, 1, 1, 1);
		property2 = new Property("Hello", "There", 1, "John", 2, 2, 1, 1);
		management.addProperty(property1);
		management.addProperty(property2);
		assertEquals("John", management.getProperties()[0].getOwner());
	}

	@Test
	void testGetMgmFeePer() {
		assertEquals(9, management.getMgmFeePer(), 9);
	}

	@Test
	void testGetPlot() {
		assertEquals(0, management.getPlot().getX());
	}

	@Test
	void testToString() {
		property1 = new Property("Hello", "There", 9, "John", 1, 1, 1, 1);
		management.addProperty(property1);
		assertEquals("List of the properties for Alex Tseng, taxID: 123456789\n___________________________________\nHello,There,John,9.0\n___________________________________\n0.81", management.toString());
	}

}
