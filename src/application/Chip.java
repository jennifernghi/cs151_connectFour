package application;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
/**
 * 
 * 
 *
 */
public class Chip {
	/**
	 * EMPTY = 0  initial value represents empty slot
	 */
	public final static Integer EMPTY = 0;
	
	//fields
	Integer value;
	Paint color;
	/**
	 * default constructor
	 * chip value of EMPTY and color of white
	 */
	public Chip() {
		this(EMPTY, Color.WHITE);
		System.out.println("chip");
	}
	/**
	 * Constructor
	 * @param value - integer value corresponding to the player
	 * @param color - color of the chip
	 */
	public Chip(Integer value, Paint color) {
		this.value = value;
		this.color=color;
	}
	/**
	 * set value
	 * @param value int
	 */
	public void setValue(Integer value){
		this.value = value;
	}
	/**
	 * get value
	 * @return value
	 */
	public Integer getValue(){
		return this.value;
	}
	
	public Paint getColor() {
		return this.color;
	}
	/**
	 * toString()
	 * @return str - value of the chip
	 */
	public String toString() {
		String str = value.toString();
		return str;
		
	}
}
