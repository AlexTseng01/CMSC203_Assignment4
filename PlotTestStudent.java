import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2, plot3, plot4;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot();
		plot3 = new Plot(plot1);
		plot4 = new Plot(3, 4, 4, 3);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = null;
	}

	@Test
	void testOverlaps() {
		assertTrue(plot1.overlaps(plot4));
		assertFalse(plot1.overlaps(plot3));
		assertFalse(plot1.overlaps(plot2)); // test
		assertTrue(plot4.overlaps(plot1));
	}

	@Test
	void testEncompasses() {
		assertTrue(plot1.encompasses(plot3));
		assertTrue(plot4.encompasses(plot1));
		assertTrue(plot1.encompasses(plot4));
		assertFalse(plot1.encompasses(plot2));
		assertTrue(plot4.encompasses(plot1));
		assertTrue(plot3.encompasses(plot1));
	}

	@Test
	void testSetX() {
		plot1.setX(5);
		assertEquals(5, plot1.getX());
		plot2.setX(1);
		assertEquals(1, plot2.getX());
		plot3.setX(2);
		assertEquals(2, plot3.getX());
	}

	@Test
	void testSetY() {
		plot1.setX(3);
		assertEquals(3, plot1.getX());
		plot2.setX(2);
		assertEquals(2, plot2.getX());
		plot3.setX(5);
		assertEquals(5, plot3.getX());
	}

	@Test
	void testSetWidth() {
		plot1.setWidth(6);
		assertEquals(6, plot1.getWidth());
		plot2.setWidth(5);
		assertEquals(5, plot2.getWidth());
		plot3.setWidth(3);
		assertEquals(3, plot3.getWidth());
	}

	@Test
	void testSetDepth() {
		plot1.setDepth(3);
		assertEquals(3, plot1.getDepth());
		plot2.setDepth(1);
		assertEquals(1, plot2.getDepth());
		plot3.setDepth(4);
		assertEquals(4, plot3.getDepth());
	}

	@Test
	void testGetX() {
		assertEquals(2, plot1.getX());
		assertEquals(0, plot2.getX());
		assertEquals(2, plot3.getX());
	}

	@Test
	void testGetY() {
		assertEquals(2, plot1.getY());
		assertEquals(0, plot2.getY());
		assertEquals(2, plot3.getY());
	}

	@Test
	void testGetWidth() {
		assertEquals(6, plot1.getWidth());
		assertEquals(1, plot2.getWidth());
		assertEquals(6, plot3.getWidth());
	}

	@Test
	void testGetDepth() {
		assertEquals(6, plot1.getDepth());
		assertEquals(1, plot2.getDepth());
		assertEquals(6, plot3.getDepth());
	}

	@Test
	void testToString() {
		assertEquals("2,2,6,6", plot3.toString());
		assertEquals("0,0,1,1", plot2.toString());
		assertEquals("2,2,6,6", plot1.toString());
	}

}
