
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyGFATest {
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
    public void testToString() {
        sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);         
        mangementCo.addProperty(sampleProperty);    
        String pStr = "List of the properties for " + mangementCo.getName() + ", " + "taxID: " + mangementCo.getTaxID() + "\n";
        pStr += "______________________________________________________\n";
        pStr += "Sunsational,Beckman,BillyBob Wilson,2613.0\n";
        pStr += "______________________________________________________\n";
        pStr += "\n Total management Fee: " + (sampleProperty.getRentAmount() * mangementCo.getMgmFeePer()) / 100;
    }
}
