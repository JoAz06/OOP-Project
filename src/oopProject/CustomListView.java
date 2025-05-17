package oopProject;

import javafx.scene.control.ListView;

public class CustomListView extends ListView<String>{
	public CustomListView (int startX,int startY,int minW,int minH,int maxW,int maxH,String style) {
		setLayoutX(startX);
		setLayoutY(startY);
		setMinWidth(minW);
		setMinHeight(minH);
		setMaxWidth(maxW);
		setMaxHeight(maxH);
		setStyle(style);
	}
		
		
}	

