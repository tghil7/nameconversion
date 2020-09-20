package application;
	
import java.util.HashMap;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;



public class Main extends Application {
	
		
	@Override
	public void start(Stage primaryStage) {
		
		
		HashMap <Character, Integer> numbers = new HashMap<Character, Integer>();
		numbers.put('A', 1);
		numbers.put('B', 1);
		numbers.put('C', 1);
		numbers.put('D', 1);
		numbers.put('E', 1);
		numbers.put('F', 2);
		numbers.put('G', 2);
		numbers.put('H', 2);
		numbers.put('I', 2);
		numbers.put('K', 3);
		numbers.put('L', 3);
		numbers.put('M', 3);
		numbers.put('N', 3);
		numbers.put('O', 3);
		numbers.put('P', 4);
		numbers.put('Q', 4);
		numbers.put('R', 4);
		numbers.put('S', 4);
		numbers.put('T', 4);
		numbers.put('U', 5);
		numbers.put('V', 5);
		numbers.put('W', 5);
		numbers.put('X', 5);
		numbers.put('Y', 5);
		numbers.put('Z', 6);
		try {
			BorderPane pane = new BorderPane();
			Insets insets = new Insets(10);
			
			pane.setPadding(new Insets(10,10, 10, 10));
		   
			Scene scene = new Scene(pane,400,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Setting the pane for buttons and text fields
			HBox paneForDataEntry = new HBox();
			paneForDataEntry.setSpacing(5);
			Label nameLabel = new Label("Name");
			nameLabel.setWrapText(true);
			nameLabel.setMinWidth(Region.USE_PREF_SIZE);
		    nameLabel.setMaxWidth(Region.USE_PREF_SIZE);
		    paneForDataEntry.setPadding(new Insets(3,3,3, 3));
		    TextField name = new TextField();
		    Button submit = new Button("Submit");  //Defining the Submit button
		    Button clear = new Button("Clear");  //Defining the Clear button
		    
		    name.setPromptText("Enter your name.");
		    paneForDataEntry.getChildren().addAll(nameLabel, name, submit, clear );
		    paneForDataEntry.setAlignment(Pos.CENTER);
		    
		    //Add the first pane to the main pane
		    pane.setTop(paneForDataEntry);
		    
		   
		    
			primaryStage.setScene(scene);
			primaryStage.setTitle("Name Conversion");
			
			 //Set the pane for results
			
			VBox paneForResults = new VBox();
			paneForResults.setSpacing(5);
			paneForResults.setVisible(true);
			paneForResults.setId("RESULTS");
		    Label chiffreLabel = new Label("Chiffre de Vie"); 
		    
		   //Create an HBox to add  the name and label for chiffre de Vie
		    HBox chiffreBox = new HBox();
		    chiffreBox.setSpacing(5);
		    chiffreBox.setAlignment(Pos.CENTER_RIGHT);
		    TextField chiffreDeVie = new TextField();
		    //add the elements to the chiffre Box;
		    chiffreBox.getChildren().addAll(chiffreLabel, chiffreDeVie);
		    
		    HBox decomBox = new HBox();
		    decomBox.setAlignment(Pos.CENTER_RIGHT);
		    decomBox.setSpacing(5);
		    Label decomLabel = new Label("Decom"); 
		    TextField decom = new TextField();
		    decomBox.getChildren().addAll(decomLabel, decom);
		    
		    HBox decomVie1Box = new HBox();
		    decomVie1Box.setSpacing(5);
		    decomVie1Box.setAlignment(Pos.CENTER_RIGHT);
		    Label decomVie1Label= new Label("Decom de Vie Anterieure 1"); 
		    TextField decomDeVie1 = new TextField();
		    decomVie1Box.getChildren().addAll(decomVie1Label, decomDeVie1);
		    
		    HBox decomChiffre2Box = new HBox();
		    decomChiffre2Box.setSpacing(5);
		    decomChiffre2Box.setAlignment(Pos.CENTER_RIGHT);
		    Label chiffre2Label = new Label("Chiffre De Vie 2"); 
		    TextField chiffreDeVie2 = new TextField();
		    decomChiffre2Box.getChildren().addAll(chiffre2Label, chiffreDeVie2);
		    
		    HBox decom1Box = new HBox(10);
		    decom1Box.setSpacing(5);
		    decom1Box.setAlignment(Pos.CENTER_RIGHT);
		    Label decom1Label = new Label("Decom 1"); 
		    TextField decom1 = new TextField();
		    decom1Box.getChildren().addAll(decom1Label, decom1);
		    
		    HBox decomVie2Box = new HBox();
		    decomVie2Box.setSpacing(5);
		    decomVie2Box.setAlignment(Pos.CENTER_RIGHT);
		    Label decomVie2Label= new Label("Decom de Vie Anterieure 2"); 
		    TextField decomDeVie2 = new TextField();
		    decomVie2Box.getChildren().addAll(decomVie2Label, decomDeVie2);
		    
		    paneForResults.getChildren().addAll(chiffreBox, decomBox, decomVie1Box, decomChiffre2Box, decom1Box, decomVie2Box);
		    
		    pane.setCenter(paneForResults);
		    BorderPane.setMargin(paneForDataEntry, insets);
		    BorderPane.setMargin(paneForResults, insets);
		    
		    submit.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			    int total = 0;
			    	@Override
			    	    public void handle(ActionEvent e) {
			             
			    			String nameText =name.getText();
			    			for (int i = 0; i < nameText.length() ; i++) {
			    			    for (Map.Entry<Character, Integer> entry:numbers.entrySet()) {
			    			    	if (Character.toUpperCase(nameText.charAt(i)) == entry.getKey()) {
			    			    	  total += entry.getValue();
			    			    	}
			    			    }
			    			}
			    	      
			    			
			    		//Calculating the different values to populate in the fields
			    	       chiffreDeVie.setText(Integer.toString(total));
			    	       int decomValue = (total * 360)/72;
			    	       decom.setText(Integer.toString(decomValue));
			    	       
			    	       
			    	       int decomDeVie1Value = Calendar.getInstance().get(Calendar.YEAR) - decomValue;
			    	       decomDeVie1.setText(Integer.toString(decomDeVie1Value));
			    	       
			    	       
			    	       int chiffreDeVie2Value = Integer.parseInt(decomDeVie1.getText().substring(0,2)) + Integer.parseInt(decomDeVie1.getText().substring(2));
			    	      /* System.out.println("DecomVie1 part 1 : " + decomDeVie1.getText().substring(0,2) );
			    	       System.out.println("DecomVie1 part 2 : " +decomDeVie1.getText().substring(2) );*/
			    	       chiffreDeVie2.setText(Integer.toString(chiffreDeVie2Value)); //Set the value for the chiffre De Vie 2
			    	       int decom1Value = (chiffreDeVie2Value * 360)/72;
			    	       decom1.setText(Integer.toString(decom1Value));
			    	       decomDeVie2.setText(Integer.toString(decomDeVie1Value - decom1Value ));
			    	       total = 0;
			    	     }
			    	 });
		    
		    
		    //Setting an action for the Clear button to clear all text boxes 
		    clear.setOnAction(new EventHandler<ActionEvent>() {

		    @Override
		        public void handle(ActionEvent e) {
		    	name.clear();
		    	chiffreDeVie.clear();
		    	decom.clear();
		    	decomDeVie1.clear();
		    	chiffreDeVie2.clear(); 
		    	decom1.clear(); 
		    	decomDeVie2.clear();
		            
		        }
		    });
		    
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
			
	}
	
	
	
	
	

}
