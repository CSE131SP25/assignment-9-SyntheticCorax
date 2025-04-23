package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	private BodySegment lastMoved;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		segments = new LinkedList<BodySegment>();
		BodySegment initial = new BodySegment(0.5,0.5,SEGMENT_SIZE);
		segments.add(initial);
		lastMoved = new BodySegment(0.5,0.5,SEGMENT_SIZE);
		
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		lastMoved.move(segments.get(segments.size()-1));
		for (int i = segments.size()-1; i >= 1 ; i--) {
			segments.get(i).move(segments.get(i-1));
		}
		segments.get(0).move(deltaX, deltaY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment seg: segments){
			seg.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		for (BodySegment seg: segments) {
			if ((Math.sqrt(Math.pow(seg.getX() - f.getX(), 2) + Math.pow(seg.getY() - f.getY(), 2))) < Food.FOOD_SIZE + SEGMENT_SIZE) {
				BodySegment add = new BodySegment(lastMoved.getX(), lastMoved.getY(),SEGMENT_SIZE);
				segments.add(add);
				return true;
		}
		}
		return false;
	}
	
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
	    return head.getX() >= 0 && head.getX() <= 1 &&
	           head.getY() >= 0 && head.getY() <= 1;
	}
}
