/*
 * Class :CMSC203
 * Instructor: Dr. Monshi
 * Description: A property management program that creates a management company, letting the user add plots. 
 * Each plot is tested using overlapping/encompassing methods on each other.
 * The program will refuse to add a property if properties exceeds 5, overlaps/encompasses each other, or when property is a null value
 * Due: 4/4/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Name: Alex Tseng
 */

public class ManagementCompany {
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	
	private String name;
	private String taxID;
	private double mgmFee;
	private Plot plot;
	private int x, y, width, depth;
	
	private Property[] properties;
	
	private int numberOfProperties;
	
	private int iteration = 0;
	
	// constructors
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0.0;
		
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this(name, taxID, mgmFee);
		
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee);

		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property p = new Property(name, city, rent, owner);
		int index = 0;
		
		// check -1 to -3
		if (isPropertiesFull()) {
			return -1;
		}
		else if (p == null) {
			return -2;
		}
		else if (!(plot.encompasses(p.getPlot()))) {
			return -3;
		}

		for (int i = iteration; i < MAX_PROPERTY;) {
			// count how many null values are in properties array
			int count = 0;
			for (int j = 0; j < MAX_PROPERTY; j++) {
				if (properties[j] == null) {
					count++;
				}
			}
			// if array is empty, property at index 0 is given the Property object, doesn't need to check for overlaps
			if (count == 5) {
				properties[0] = p;
			}
			// if array has at least 1 space left
			else if (count < 5 && count > 0) {
				for (int j = 0; j < MAX_PROPERTY - count; j++) {
					if (p.getPlot().overlaps(properties[j].getPlot()))
						return -4;
				}
			}
			
			index = i;
			iteration++;
			break;
		}
		
		if (isPropertiesFull()) {
			return -1;
		}
		
		properties[index] = p;
		return index;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property p = new Property(name, city, rent, owner, x, y, width, depth);
		int index = 0;
		
		// check -1 to -3
		if (isPropertiesFull()) {
			return -1;
		}
		else if (p == null) {
			return -2;
		}
		else if (!(plot.encompasses(p.getPlot()))) {
			return -3;
		}

		for (int i = iteration; i < MAX_PROPERTY;) {
			// count how many null values are in properties array
			int count = 0;
			for (int j = 0; j < MAX_PROPERTY; j++) {
				if (properties[j] == null) {
					count++;
				}
			}
			// if array is empty, property at index 0 is given the Property object, doesn't need to check for overlaps
			if (count == 5) {
				properties[0] = p;
			}
			// if array has at least 1 space left
			else if (count < 5 && count > 0) {
				for (int j = 0; j < MAX_PROPERTY - count; j++) {
					if (p.getPlot().overlaps(properties[j].getPlot()))
						return -4;
				}
			}
			
			index = i;
			iteration++;
			break;
		}
		
		if (isPropertiesFull()) {
			return -1;
		}
		
		properties[index] = p;
		return index;
	}

	public int addProperty(Property property) {
		Property p = new Property(property);
		int index = 0;
		
		// check -1 to -3
		if (isPropertiesFull()) {
			return -1;
		}
		else if (property == null) {
			return -2;
		}
		else if (!(plot.encompasses(property.getPlot()))) {
			return -3;
		}

		for (int i = iteration; i < MAX_PROPERTY;) {
			// count how many null values are in properties array
			int count = 0;
			for (int j = 0; j < MAX_PROPERTY; j++) {
				if (properties[j] == null) {
					count++;
				}
			}
			// if array is empty, property at index 0 is given the Property object, doesn't need to check for overlaps
			if (count == 5) {
				properties[0] = property;
			}
			// if array has at least 1 space left
			else if (count < 5 && count > 0) {
				for (int j = 0; j < MAX_PROPERTY - count; j++) {
					if (property.getPlot().overlaps(properties[j].getPlot()))
						return -4;
				}
			}
			
			index = i;
			iteration++;
			break;
		}
		
		if (isPropertiesFull()) {
			return -1;
		}
		
		properties[index] = p;
		return index;
	}
	
	public void removeLastProperty() {
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i].equals(null)) {
				properties[i - 1] = null;
			}
			else {
				properties[MAX_PROPERTY - 1] = null;
			}
		}
	}
	
	public boolean isPropertiesFull() {
		int count = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				count++;
			}
		}
		
		if (count == 0) {
			return true; // means that array is filled
		}
		else {
			return false; // means that array has at least 1 open slot
		}
	}
	
	public int getPropertiesCount() {
		int count = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				count++;
			}
		}
		
		numberOfProperties = count;
		
		return numberOfProperties;
	}

	public double getTotalRent() {
		double totalRent = 0.0;
		
		int count = 0;
		
		for (int j = 0; j < MAX_PROPERTY; j++) {
			if (properties[j] == null) {
				count++;
			}
		}
		
		for (int i = 0; i < MAX_PROPERTY - count; i++) {
			totalRent += properties[i].getRentAmount();
		}
		
		return totalRent;
	}

	public Property getHighestRentProperty() {
		Property max = new Property();
		
		int count = 0;
		
		for (int j = 0; j < MAX_PROPERTY; j++) {
			if (properties[j] == null) {
				count++;
			}
		}
		
		for (int i = 0; i < MAX_PROPERTY - count; i++) {
			 if (max.getRentAmount() < properties[i].getRentAmount()) {
				 max = properties[i];
			 }
		}

		return max;
	}

	public boolean isManagementFeeValid() {
		if (mgmFee > 0 && mgmFee < 100) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public double getMgmFeePer() {
		return mgmFee;
	}
	
	public Plot getPlot() {
		return plot;
	}

	@Override
	public String toString() {
		int count = 0;
		
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				count++;
			}
		}
		
		String result = "";
		
		for (int i = 0; i < count; i++) {
			if (i != count - 1)
				result += properties[i] + "\n";
			else
				result += properties[i];
		}
		
		double totalFee = (getTotalRent() * mgmFee) / 100.0;
		
		return "List of the properties for " + name + ", taxID: " + taxID + "\n___________________________________\n" + result + "\n___________________________________\n" + totalFee;
	}

}
