package oopProject;

import javafx.scene.control.TextField;

public class CustomTextField extends TextField{
	public CustomTextField(int startX,int startY,int minW,int minH,int maxW,int maxH,String style,String prompt) {
		setLayoutX(startX);
		setLayoutY(startY);
		setMinWidth(minW);
		setMinHeight(minH);
		setMaxWidth(maxW);
		setMaxHeight(maxH);
		setStyle(style);
		setPromptText(prompt);
	}
}
