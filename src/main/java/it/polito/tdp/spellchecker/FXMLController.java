/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary model;
	private RichWord parola;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="inputText"
    private TextArea inputText; // Value injected by FXMLLoader

    @FXML // fx:id="labelErrori"
    private Label labelErrori; // Value injected by FXMLLoader

    @FXML // fx:id="labelTempo"
    private Label labelTempo; // Value injected by FXMLLoader

    @FXML // fx:id="outputText"
    private TextArea outputText; // Value injected by FXMLLoader

    @FXML // fx:id="tendinaLingue"
    private ComboBox<String> tendinaLingue; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	
    	inputText.clear();
    	outputText.clear();
    	

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	outputText.setText("");
    	
    	model.loadDictionary(tendinaLingue.getValue());
    	
    	String lingua = tendinaLingue.getValue();
    	
    	String input = inputText.getText().toLowerCase();
 
    	input.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	
    	String word;
    	LinkedList <RichWord> listaRich = new LinkedList();
    	
		
    	String array[] = input.split(" ");
    	int c=0;
    	
    	if(lingua.compareTo("Italian")==0) {
    	
    		while (array[c] != null) {
    		
    	
    			if(model.paroleItalian.contains(array[c])==true) 
    			{listaRich.add(new RichWord (array[c],true));}
    			else {listaRich.add(new RichWord (array[c],false));}
    			c++;
    	}}
		
    	
		if(lingua.compareTo("English")==0) {
			
			while (array[c] != null) {
				
	    	if(model.paroleEnglish.contains(array[c])==true) 
	    	{listaRich.add(new RichWord (array[c],true));}
	    	else {listaRich.add(new RichWord (array[c],false));}
	    	
	    	
	    	c++;
			}
			
		}
		
		
		
		for(RichWord s : listaRich)
		{
			if(s.isCorrect()==false) {
				outputText.appendText(s.getParola()+" ");
			}
		}
		
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert inputText != null : "fx:id=\"inputText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelErrori != null : "fx:id=\"labelErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelTempo != null : "fx:id=\"labelTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert outputText != null : "fx:id=\"outputText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tendinaLingue != null : "fx:id=\"tendinaLingue\" was not injected: check your FXML file 'Scene.fxml'.";
        tendinaLingue.getItems().clear();
        tendinaLingue.getItems().add("English");
        tendinaLingue.getItems().add("Italian");

    }

	public void setModel(Dictionary model) {
		this.model=model;
		// TODO Auto-generated method stub
		
	}

}
