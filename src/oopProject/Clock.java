package oopProject;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Clock extends Pane{
	String time;
	String formattedTime;
	Text digitalClock = new Text();
	TimeZone timeZone;
	Text info;
	public Clock(char type,TimeZone timeZone){
		this.timeZone = timeZone;
		this.setMinWidth(290);
		this.setMinHeight(150);
		this.setMaxWidth(290);
		this.setMaxHeight(150);
		this.setStyle("-fx-background-color: rgb(60,60,60);");
		digitalClock.setX(40);
		digitalClock.setY(80);
		Font digitalFont = Font.loadFont(getClass().getResourceAsStream("/DS-DIGI.TTF"), 70);
		digitalClock.setFont(digitalFont);
		digitalClock.setFill(Color.WHITE);
		info = new Text("This is UTC"+timeZone.utc+" time zone.");
		info.setX(80);
		info.setY(115);
		info.setFill(Color.WHITE);
		this.getChildren().add(digitalClock);
		this.getChildren().add(info);
		if (type=='p') {
			this.setLayoutX(1203);
			this.setLayoutY(9);
		}else {
			this.setLayoutX(1203);
			this.setLayoutY(167);
		}
	}
	public void updateTime(String time) {
		LocalTime currentTime = LocalTime.now(ZoneId.of("UTC")).plusHours(Integer.parseInt(timeZone.utc));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		formattedTime = currentTime.format(formatter);
		digitalClock.setText(formattedTime);	
	}
	public void swapClocks(TimeZone timeZone) {
		this.timeZone.isChosen=false;
		this.timeZone.imageView.setOpacity(0);
		this.timeZone= timeZone;
		this.timeZone.isChosen=true;
		this.timeZone.imageView.setOpacity(1);
		info.setText("This is UTC"+timeZone.utc+" time zone.");
		updateTime(Main.localTime);
	}
}
