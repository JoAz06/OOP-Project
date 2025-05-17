package oopProject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class CustomLine extends Line{
	public CustomLine(int startX,int startY,int endX,int endY,Color color,int width) {
		setStartX(startX); 
		setStartY(startY); 
		setEndX(endX); 
		setEndY(endY);
	    setStroke(color);
	    setStrokeWidth(width);
	}
}
