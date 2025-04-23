package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		x = Math.random();
		y = Math.random();
				
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(ColorUtils.solidColor());
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	
}
