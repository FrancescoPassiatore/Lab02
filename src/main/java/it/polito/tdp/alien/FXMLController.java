package it.polito.tdp.alien;


import java.net.URL;
import java.util.ResourceBundle;


import it.polito.tdp.alien.model.ParolaTradotta;
import it.polito.tdp.alien.model.Traduttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Traduttore model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClearTxt;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtAreaDizionario;

    @FXML
    private TextField txtParolaInserita;
    
    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String ctrl = "qwertyuiopasdfghjklzxcvbnm";
    	String s[]= null;
    	s = this.txtParolaInserita.getText().toLowerCase().split(" ");
    	boolean check = true ;
    	for( String ss :s ) {
    		String temp[] = ss.split("");
    		for (String r : temp) {
    			if (ctrl.contains(r) == false) {
    				check=false;
    				}
    			}
    	}
    	if ( check == true) {
	    	if (s.length == 1) {
	    		this.txtAreaDizionario.setText(this.model.translate(s[0]));
	    	   }
	    	else if (s[1] != null){
	    	   model.addDizionario(s[0],s[1]);
	    	   }
	    	}
    	else if ( check == false) {
    		this.txtAreaDizionario.setText("Gli unici caratteri ammessi sono [a-z/A-Z]");
    	}
    }
    
    public void setModel(Traduttore model) {
    	this.model = model;
    }


    @FXML
    void initialize() {
        assert btnClearTxt != null : "fx:id=\"btnClearTxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaDizionario != null : "fx:id=\"txtAreaDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}