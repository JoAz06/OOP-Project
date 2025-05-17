package oopProject;


import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application{
	public static int stageWidth=1500;
	public static int stageHeight=650;
	public static String localTime;
	String formattedLocalTime;
	public static ArrayList<TimeZone> listOfTimeZone = new ArrayList<TimeZone>();
	static TimeZone utc_N10 = new TimeZone("-10.png","-10",0,new String[]{"Hawaii", "Cook Islands", "Tahiti (French Polynesia)"});
	static TimeZone utc_N9 = new TimeZone("-9.png","-9",0,new String[]{"Alaska (USA)", "Gambier Islands (French Polynesia)"});
	static TimeZone utc_N8 = new TimeZone("-8.png","-8",0,new String[]{"United States (Pacific Time)", "Canada (Pacific Time)", "Mexico (Pacific Time)", "Baja California"});
	static TimeZone utc_N7 = new TimeZone("-7.png","-7",0,new String[]{"United States (Mountain Time)", "Canada (Mountain Time)", "Mexico (Mountain Time)", "Arizona"});
	static TimeZone utc_N6 = new TimeZone("-6.png","-6",0,new String[]{"United States (Central Time)", "Canada (Central Time)", "Mexico (Central Time)", "Belize", "Costa Rica", "El Salvador", "Guatemala", "Honduras", "Nicaragua"});
	static TimeZone utc_N5 = new TimeZone("-5.png","-5",0,new String[]{"United States (Eastern Time)", "Canada (Eastern Time)", "Mexico (Eastern Time)", "Bahamas", "Barbados", "Cuba", "Haiti", "Jamaica", "Panama", "Colombia", "Ecuador", "Peru"});
	static TimeZone utc_N4 = new TimeZone("-4.png","-4",0,new String[]{"Venezuela", "Bolivia", "Chile (Easter Island)", "Puerto Rico", "Dominican Republic", "Aruba", "Curacao", "Barbados", "Cayman Islands", "Guyana", "Suriname"});
	static TimeZone utc_N3 = new TimeZone("-3.png","-3",0,new String[]{"Argentina", "Brazil (Some regions)", "Uruguay", "Suriname", "Paraguay", "Falkland Islands", "French Guiana (France)", "Chile", "Ecuador (Galapagos Islands)"});
	static TimeZone utc_N2 = new TimeZone("-2.png","-2",0,new String[]{"South Georgia and the South Sandwich Islands"});
	static TimeZone utc_N1 = new TimeZone("-1.png","-1",0,new String[]{"Azores", "Cape Verde", "Madeira"});
	static TimeZone utc_0 = new TimeZone("0.png","+0",0,new String[]{"United Kingdom", "Ireland", "Portugal", "Iceland", "Ghana", "The Gambia", "Liberia", "Sierra Leone", "Togo", "Burkina Faso", "Mali", "Mauritania", "Guinea", "Guinea-Bissau", "Senegal"});
	static TimeZone utc_P1 = new TimeZone("1.png","+1",0,new String[]{"Albania", "Andorra", "Austria", "Belgium", "Croatia", "Czech Republic", "France", "Germany", "Hungary", "Italy", "Luxembourg", "Malta", "Netherlands", "Poland", "Slovakia", "Slovenia", "Spain", "Switzerland", "Western Sahara", "Liechtenstein", "Monaco", "San Marino"});
	static TimeZone utc_P2 = new TimeZone("2.png","+2",0,new String[]{"Bulgaria", "Cyprus", "Egypt", "Estonia", "Finland", "Greece", "Israel", "Jordan", "Latvia", "Lithuania", "Moldova", "Romania", "South Africa", "Ukraine", "Syria", "Lebanon", "Palestinian Territories", "Tunisia"});
	static TimeZone utc_P3 = new TimeZone("3.png","+3",0,new String[] {"Iran","Arabian Standard Time (AST)", "Belarus", "Comoros", "Djibouti", "Iraq", "Kenya", "Kuwait", "Madagascar", "Malawi", "Qatar", "Saudi Arabia", "Somalia", "Sudan", "Syria", "Tanzania", "Turkey", "Uganda", "Yemen", "Ethiopia", "Rwanda", "Bahrain", "Oman"});
	static TimeZone utc_P4 = new TimeZone("4.png","+4",0,new String[] {"Afghanistan","Azerbaijan", "Armenia", "Georgia", "Mauritius", "Seychelles", "UAE (United Arab Emirates)", "Cocos (Keeling) Islands (Australia)", "Maldives"});
	static TimeZone utc_P5 = new TimeZone("5.png","+5",0,new String[] {"Pakistan", "Uzbekistan", "Turkmenistan", "Tajikistan", "Kyrgyzstan", "Kazakhstan (Eastern part)", "Maldives","India","Sri Lanka"});
	static TimeZone utc_P6 = new TimeZone("6.png","+6",0,new String[] {"Kazakhstan (Western part)", "Kyrgyzstan", "Bangladesh", "Bhutan", "Uzbekistan (Western part)"});
	static TimeZone utc_P7 = new TimeZone("7.png","+7",0,new String[] {"Cambodia", "Laos", "Thailand", "Vietnam", "Indonesia (Western regions)", "China (Western regions)", "Malaysia (Eastern regions)"});
	static TimeZone utc_P8 = new TimeZone("8.png","+8",0,new String[] {"China", "Hong Kong", "Malaysia", "Singapore", "Taiwan", "Philippines", "Brunei", "Australia (Western Australia)", "Mongolia", "Macau", "Indonesia (Eastern regions)", "Timor-Leste"});
	static TimeZone utc_P9 = new TimeZone("9.png","+9",0,new String[] {"Japan", "South Korea", "North Korea", "Indonesia (Eastern regions)", "Palau", "Federated States of Micronesia", "Chuuk", "Yap", "Kosrae", "Marshall Islands"});
	static TimeZone utc_P10 = new TimeZone("10.png","+10",0,new String[] {"Australia (Eastern Australia)", "Papua New Guinea", "Guam", "Northern Mariana Islands", "Vanuatu", "New Caledonia", "Federated States of Micronesia (Some regions)", "Bougainville (Papua New Guinea)", "Kiribati (Phoenix Islands)", "Solomon Islands", "Nauru", "Tuvalu"});
	static TimeZone utc_P11 = new TimeZone("11.png","+11",0,new String[] {"Solomon Islands", "Vanuatu", "New Caledonia", "Federated States of Micronesia (Some regions)", "Kosrae", "Nauru", "Tuvalu", "Wake Island"});
	static TimeZone utc_P12 = new TimeZone("12.png","+12",0,new String[] {"Kiribati", "Fiji", "Marshall Islands", "Nauru", "Tuvalu", "Wake Island", "Christmas Island (Australia)"});
	public static Clock primaryClock = new Clock('p',utc_P3);
	public static Clock secondaryClock = new Clock('s',utc_0);
	public static CustomListView listView = new CustomListView(0,40,290,260,290,260,"-fx-background-color: rgb(60,60,60); -fx-text-fill: white;");
	public static CustomTextField searchField = new CustomTextField(0,0,290,40,290,40,"-fx-background-color:rgb(60,60,60); -fx-text-fill: white;","Search Name of Country");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane primaryPane = new Pane();
		secondaryClock.timeZone.isChosen=true;
		secondaryClock.timeZone.imageView.setOpacity(1);
		//Importing Images
		Image fullMap = new Image("BlackMap.png");
	    ImageView fullMapView=new ImageView(fullMap);
	    
	    //Lines
	    CustomLine line1 = new CustomLine(1194,325,1500,325,Color.rgb(32, 32, 32),5);
	    CustomLine line2 = new CustomLine(1194,0,1194,650,Color.rgb(32, 32, 32),5); 
		
		//Properties for the Background image
		fullMapView.setPreserveRatio(true);
		fullMapView.setFitHeight(stageHeight);
		fullMapView.setOpacity(1);
		
		///Searching
		CustomPane searchPane = new CustomPane(1203,337,290,300,290,300);
		searchPane.getChildren().addAll(listView,searchField);
		listView.setCellFactory(e -> new ListCell<String>() {
		    @Override
		    protected void updateItem(String item, boolean empty) {
		        super.updateItem(item, empty);
		        setOnMouseClicked(e -> {
	                if (!isEmpty()) {
	                    String cellValue = getText();
	                    handleCellClick(cellValue);
	                }
	            });
		        if (empty || item == null) {
		            setText(null);
		        } else {
		            setText(item);
		            setTextFill(Color.WHITE); // Directly set the text color
		            setStyle("-fx-background-color: rgb(60,60,60);"); // Set the background color
		        }
		    }
		});
		Platform.runLater(() -> {       
			listView.lookup(".scroll-bar").setStyle("-fx-opacity: 1; -fx-background-color: rgb(60,60,60);");
		});
		searchPane.setStyle("-fx-background-color: rgb(60,60,60);");
		searchField.textProperty().addListener((observable, oldValue, newValue) -> {search(newValue);});   
		
		//Time Loop
		Timeline timeline = new Timeline( new KeyFrame(Duration.seconds(0), e -> updateClocks(localTime)),new KeyFrame(Duration.seconds(1), e -> updateClocks(localTime)));
	    timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
		//Adding images to primaryPane
		primaryPane.getChildren().addAll(fullMapView,utc_N10.imageView,utc_N9.imageView,utc_N8.imageView,utc_N7.imageView,utc_N6.imageView,utc_N5.imageView,
				utc_N4.imageView,utc_N3.imageView,utc_N2.imageView,utc_N1.imageView,utc_0.imageView,utc_P1.imageView,utc_P2.imageView,utc_P3.imageView,utc_P4.imageView,
				utc_P5.imageView,utc_P6.imageView,utc_P7.imageView,utc_P8.imageView,utc_P9.imageView);
		primaryPane.getChildren().addAll(utc_P10.imageView,utc_P11.imageView,utc_P12.imageView,line1,line2,primaryClock,secondaryClock,searchPane);
		primaryPane.setStyle("-fx-background-color: rgb(47,47,47);");
		Scene primaryScene = new Scene(primaryPane,stageWidth,stageHeight,Color.rgb(47,47,47));
		primaryStage.setResizable(false);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("World Clock");
		primaryStage.getIcons().add(new Image("clock-icon.png"));
		primaryStage.show();
	}
	public static ArrayList<String> searchList(String querie){
		ArrayList<String> results = new ArrayList<String>();
		for(int i = 0 ; i < listOfTimeZone.size();i++) {
			for(int y = 0 ; y < listOfTimeZone.get(i).countries.length;y++) {
				if(listOfTimeZone.get(i).countries[y].toUpperCase().indexOf(querie.toUpperCase()) != -1){
					results.add(listOfTimeZone.get(i).countries[y]);
				}
			}
		}
		return results;
	}
	public static void search(String querie) {
		listView.getItems().clear();
		listView.getItems().addAll(searchList(querie));
	}
	public static void handleCellClick(String countrie) {
		for(int i = 0 ;i<listOfTimeZone.size();i++) {
			for(int y = 0 ;y<listOfTimeZone.get(i).countries.length;y++) {
				if(countrie.equals(listOfTimeZone.get(i).countries[y])) {
					searchField.setText("");
					listView.getItems().clear();
					searchField.requestFocus();
					secondaryClock.swapClocks(listOfTimeZone.get(i));
					break;
				}
			}
		}
	}
	public void updateClocks(String localTime) {
		primaryClock.updateTime(localTime);
		secondaryClock.updateTime(localTime);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
