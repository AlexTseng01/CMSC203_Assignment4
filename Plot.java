
public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	// default constructor
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	// constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	// copy constructor
	public Plot(Plot otherPlot) {
		x = otherPlot.x;
		y = otherPlot.y;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}
	
	// overlaps
	// test if plot2 has at least 1 x coordinate between the x coordinates of plot1's corner
	// then, test if plot2 has at least 1 y coordinate between the y coordinates of plot1's corners
	public boolean overlaps(Plot plot) {
		// plot1
		int right1 = x + width;
		int left1 = x;
		int top1 = y + depth;
		int bottom1 = y;
		
		// plot2
		int right2 = plot.x + plot.width;
		int left2 = plot.x;
		int top2 = plot.y + plot.depth;
		int bottom2 = plot.y;
		
		// test 5 cases of overlapping
		if (((right1 > right2) && (right2 > left1) && (top1 > top2) && (top2 > bottom1)) || // test bottom left
				((right1 < right2) && (left2 < right1) && (top1 > top2) && (top2 > bottom1)) || // test bottom right
				((right1 > right2) && (right2 > left1) && (top1 < top2) && (bottom2 > bottom1)) || // test top left
				((right1 < right2) && (left2 > left1) && (top1 < top2) && (bottom2 > bottom1)) || // test top right
				((right1 > right2) && (left1 < left2) && (top1 > top2) && (bottom1 < bottom2))) { // test middle
			return true;
		}
		else if (((right2 > right1) && (right1 > left2) && (top2 > top1) && (top1 > bottom2)) || // test bottom left
				((right2 < right1) && (left1 < right2) && (top2 > top1) && (top1 > bottom2)) || // test bottom right
				((right2 > right1) && (right1 > left2) && (top2 < top1) && (bottom1 > bottom2)) || // test top left
				((right2 > right1) && (left1 < left2) && (top2 > top1) && (bottom1 < bottom2)) || // test top right
				((right2 > right1) && (left2 < left1) && (top2 > top1) && (bottom2 < bottom1))) { // test middle
			return true;
		}
		else {
			return false;
		}
	}
	
	// encompasses
	public boolean encompasses(Plot plot) {// plot1
		int right1 = x + width;
		int left1 = x;
		int top1 = y + depth;
		int bottom1 = y;
		
		// plot2
		int right2 = plot.x + plot.width;
		int left2 = plot.x;
		int top2 = plot.y + plot.depth;
		int bottom2 = plot.y;
		
		// test 6 cases of encompassing
		if (((right1 > right2) && (left1 < left2) && (top1 > top2) && (bottom1 < bottom2)) || // test middle
				((right1 == right2) && (left1 == left2) && (top1 == top2) && (bottom1 == bottom2)) || // test all sides
				((left1 == left2) && (top1 == top2) && (bottom1 == bottom2) && (right1 > right2)) || // test left
				((left1 < left2) && (top1 == top2) && (bottom1 == bottom2) && (right1 == right2)) || // test right
				((left1 == left2) && (top1 == top2) && (bottom1 < bottom2) && (right1 == right2)) || // test top
				((left1 == left2) && (top1 > top2) && (bottom1 == bottom2) && (right1 == right2))) { // test bottom
			return true;
		}
		else if (((right2 > right1) && (left2 < left1) && (top2 > top1) && (bottom2 < bottom1)) || // test middle
				((right1 == right2) && (left1 == left2) && (top1 == top2) && (bottom1 == bottom2)) || // test all sides
				((left1 == left2) && (top1 == top2) && (bottom1 == bottom2) && (right2 > right1)) || // test left
				((left2 < left1) && (top1 == top2) && (bottom1 == bottom2) && (right1 == right2)) || // test right
				((left1 == left2) && (top1 == top2) && (bottom2 < bottom1) && (right1 == right2)) || // test top
				((left1 == left2) && (top2 > top1) && (bottom1 == bottom2) && (right1 == right2))) { // test bottom
			return true;
		}
		else {
			return false;
		}
	}
	
	// setters
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// getters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	// toString
	@Override
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}

}
