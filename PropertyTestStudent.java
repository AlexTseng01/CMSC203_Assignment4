import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	private Property property1, property2, property3, property4;
	
	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		property2 = new Property();
		property3 = new Property("Park", "Rockville", 3001.00, "John", 1, 1, 2, 2);
		property4 = new Property(property3);
	}

	@AfterEach
	void tearDown() throws Exception {
		property1 = property2 = property3 = property4 = null;
	}

	@Test
	void testGetPlot() {
		property1.getPlot().setX(5);
		property2.getPlot().setX(4);
		property3.getPlot().setX(3);
		property4.getPlot().setX(2);
		assertEquals(5, property1.getPlot().getX());
		assertEquals(4, property2.getPlot().getX());
		assertEquals(3, property3.getPlot().getX());
		assertEquals(2, property4.getPlot().getX());
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", property1.getPropertyName());
		assertEquals("", property2.getPropertyName());
		assertEquals("Park", property3.getPropertyName());
		assertEquals("Park", property4.getPropertyName());
	}

	@Test
	void testGetCity() {
		assertEquals("Rockville", property1.getCity());
		assertEquals("", property2.getCity());
		assertEquals("Rockville", property3.getCity());
		assertEquals("Rockville", property4.getCity());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, property1.getRentAmount());
		assertEquals(0, property2.getRentAmount());
		assertEquals(3001.00, property3.getRentAmount());
		assertEquals(3001.00, property4.getRentAmount());
	}

	@Test
	void testGetOwner() {
		assertEquals("Wells Fargo Bank", property1.getOwner());
		assertEquals("", property2.getOwner());
		assertEquals("John", property3.getOwner());
		assertEquals("John", property4.getOwner());
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank," + property1.getRentAmount(), property1.toString());
		assertEquals(",,," + property2.getRentAmount(), property2.toString());
		assertEquals("Park,Rockville,John," + property3.getRentAmount(), property3.toString());
		assertEquals("Park,Rockville,John," + property4.getRentAmount(), property4.toString());
	}

}
