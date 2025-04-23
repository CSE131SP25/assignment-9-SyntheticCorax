package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = Color.GREEN;
				
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size);
	}
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public void move(BodySegment des) {
		this.x = des.getX();
		this.y = des.getY();
		
	}
	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
		
	}
	
}
