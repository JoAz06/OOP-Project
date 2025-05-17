package oopProject;

import javafx.scene.layout.Pane;

public class CustomPane extends Pane{
	public CustomPane(int startX,int startY,int minW,int minH,int maxW,int maxH) {
		setLayoutX(startX);
		setLayoutY(startY);
		setMinWidth(minW);
		setMinHeight(minH);
		setMaxWidth(maxW);
		setMaxHeight(maxH);
	}
}
