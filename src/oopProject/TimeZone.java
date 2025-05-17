package oopProject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TimeZone {
	static String SelectedTime;
	double x;
	String url;
	String utc;
	ImageView imageView;
	String time;
	String formattedTime;
	boolean isChosen = false;
	String[] countries;
	public TimeZone(String url,String utc,double x,String[] countries) {
		this.url=url;
		this.utc=utc;
		this.x=x;
		this.countries = countries;
		Image image = new Image(url);
		ImageView imageView = new ImageView(image);
		this.imageView=imageView;
		imageView.setOpacity(0);
		imageView.setPreserveRatio(true);
		imageView.setFitHeight(Main.stageHeight);
		imageView.setX(x);
		imageView.setOnMouseClicked(e -> Main.secondaryClock.swapClocks(this));
		imageView.hoverProperty().addListener(e ->handleImageHover());
		Main.listOfTimeZone.add(this);
	}
	public void handleImageHover() {
		if (imageView.isHover() || isChosen) {
			imageView.setOpacity(1);
		}else{
			imageView.setOpacity(0);
		}
	}
}
