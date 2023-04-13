package Convertisseur;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable
{

	   
	    @FXML
	    private TextField txtP2;

	    @FXML
	    private TextField txtP1;

	    @FXML
	    private ComboBox<String> cbo2;

	    @FXML
	    private TextField txtL2;

	    @FXML
	    private ComboBox<String> cbo1;

	    @FXML
	    private TextField txtL1;

	    @FXML
	    private ComboBox<String> cboP1;

	    @FXML
	    private ComboBox<String> cboP2;

	    @FXML
	    private TextField txt2;

	    @FXML
	    private ComboBox<String> cboL1;

	    @FXML
	    private TextField txt1;

	    @FXML
	    private ComboBox<String> cboL2;
	   
	    @FXML
	    private TextField txtT1;

	    @FXML
	    private TextField txtT2;
	    
	    @FXML
	    private ComboBox<String> cboT1;

	    @FXML
	    private ComboBox<String> cboT2;
	    
	    @FXML
	    private TextField txtA1;

	    @FXML
	    private TextField txtA2;
	    
	    @FXML
	    private ComboBox<String> cboA1;

	    @FXML
	    private ComboBox<String> cboA2;



    
    private ObservableList<String> listMonnaie=FXCollections.observableArrayList("CAN", "EU", "US", "GBP", "AUD");
    private double []monnaie= {1.0,0.658025,0.712350,0.573357,1.10369};//taux pour different monnaies
    
    private ObservableList<String> listLongeur=FXCollections.observableArrayList("Meter", "Kilometer", "Centimeter", "Millimeter","Micrometer"
    		, "Nanometer", "Mile", "Yard","Foot", "Inch");
    private double []longeur= {1.0, 0.001, 100, 1000, 1000000, 1000000000, 0.0006213689, 1.0936132983, 3.280839895, 39.37007874};//pour different longeur
    
    private ObservableList<String> listPoid=FXCollections.observableArrayList("Kilogram", "Gram", "Miligram", "Pound", "Ounce", "Carrat", "Metric Ton", "Long Ton", "Short Ton");
    private double []poid= {1.0, 1000, 1000000, 2.20462, 35.27399, 5000, 0.001, 0.0009842073, 0.0011023122};//pour different poid
    
    private ObservableList<String> listTemp=FXCollections.observableArrayList("Second", "Milisecond", "Minute", "Hour", "Day", "Week", "Year");
    private double []temp= {3600, 3600000, 60, 1.0, 0.0416666667, 0.005952381, 0.0001140771 };//pour different temp
    
    private ObservableList<String> listAire=FXCollections.observableArrayList("m2", "km2", "cm2", "Inch2", "Foot2", "Yard2", "Acres");
    private double []aire= {1, 0.000001, 10000, 1550.0031, 10.763910417, 1.1959900463, 0.0002471054 };//pour different aires
    
 
    
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources)
	{
		cbo1.setItems(listMonnaie);
		cbo2.setItems(listMonnaie);
		cbo1.getSelectionModel().selectFirst();
		cbo2.getSelectionModel().selectFirst();
		
		cboL1.setItems(listLongeur);
		cboL2.setItems(listLongeur);
		cboL1.getSelectionModel().selectFirst();
		cboL2.getSelectionModel().selectFirst();
		
		cboP1.setItems(listPoid);
		cboP2.setItems(listPoid);
		cboP1.getSelectionModel().selectFirst();
		cboP2.getSelectionModel().selectFirst();
		
		cboT1.setItems(listTemp);
		cboT2.setItems(listTemp);
		cboT1.getSelectionModel().selectFirst();
		cboT2.getSelectionModel().selectFirst();
		
		cboA1.setItems(listAire);
		cboA2.setItems(listAire);
		cboA1.getSelectionModel().selectFirst();
		cboA2.getSelectionModel().selectFirst();
		
		
	}
    
    
    @FXML
    private void verifNum(KeyEvent e)
    {
    TextField txt=(TextField)e.getSource();

    txt.textProperty().addListener((observable,oldValue,newValue)->

    {
    if(!newValue.matches("^-?[0-9](\\.[0-9]+)?$"))
    {
    txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
    }

    });
    }
	
    private double setTaux (ComboBox a, double tbl[])
    {
    	int item=a.getSelectionModel().getSelectedIndex();
    	double val=tbl[item];
    	return val;
    }
    
    private void convert(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
    {
    	double from =setTaux(a,tbl);
    	double depart=0;
    	
    	if(c.getText().equals(""))
    		depart=0;
    	else
    		depart=Double.parseDouble(c.getText());
    	double to=setTaux(b,tbl);
    	double dest=(to/from)*depart;
    	d.setText(String.valueOf(dest));
    }
	
    @FXML
    private void ConvertM1()
    {
    	convert(cbo1,cbo2,txt1,txt2,monnaie);
    }
    @FXML
    private void ConvertM2()
    {
    	convert(cbo2,cbo1,txt2,txt1,monnaie);
    }
    
    
    @FXML
    private void ConvertL1()
    {
    	convert(cboL1,cboL2,txtL1,txtL2,longeur);
    }
    @FXML
    private void ConvertL2()
    {
    	convert(cboL2,cboL1,txtL2,txtL1,longeur);
    }
    
    @FXML
    private void ConvertP1()
    {
    	convert(cboP1,cboP2,txtP1,txtP2,poid);
    }
    @FXML
    private void ConvertP2()
    {
    	convert(cboP2,cboP1,txtP2,txtP1,poid);
    }
    
    @FXML
    private void ConvertT1()
    {
    	convert(cboT1,cboT2,txtT1,txtT2,temp);
    }
    @FXML
    private void ConvertT2()
    {
    	convert(cboT2,cboT1,txtT2,txtT1,temp);
    }
    
    @FXML
    private void ConvertA1()
    {
    	convert(cboA1,cboA2,txtA1,txtA2,aire);
    }
    @FXML
    private void ConvertA2()
    {
    	convert(cboA2,cboA1,txtA2,txtA1,aire);
    }
    
    @FXML
    private void quitter()
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("Confirmation");
    	alert.setTitle("Sortie ");
    	alert.setContentText("Veux tu vraiment quitter?");
    	Optional <ButtonType> result=alert.showAndWait();
    	if(result.get()== ButtonType.OK)
    	{
    	System.exit(0);
    	}
    }

}
