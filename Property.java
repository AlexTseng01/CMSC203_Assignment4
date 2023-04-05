
public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	Plot plot;
	
	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this(propertyName, city, rentAmount, owner);
		
		plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
		// check if otherProperty is null
		if (otherProperty == null) {
			propertyName = "";
			city = "";
			rentAmount = 0.0;
			owner = "";
			
			plot = new Plot();
		}
		else {
			propertyName = otherProperty.getPropertyName();
			city = otherProperty.getCity();
			rentAmount = otherProperty.getRentAmount();
			owner = otherProperty.getOwner();
			
			plot = new Plot(otherProperty.getPlot().getX(), otherProperty.getPlot().getY(), otherProperty.getPlot().getWidth(), otherProperty.getPlot().getDepth());
		}
	}
	
	// getters
	public Plot getPlot() {
		return plot;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public String getCity() {
		return city;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public String getOwner() {
		return owner;
	}
	// toString
	@Override
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}

}
