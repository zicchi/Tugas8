/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuisr5;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Evolved
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField tinggi;
    @FXML
    private JFXTextField berat;
    @FXML
    private TextField ideal;
    @FXML
    private JFXButton proses;
    @FXML
    private RadioButton cb1;
    @FXML
    private RadioButton cb2;
    @FXML
    private JFXButton reset;
    @FXML
    private TextArea hasil;
    @FXML
    private TextArea saran;
    @FXML
    private ToggleGroup kelamin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(ActionEvent event) {
        String Nama = nama.getText();
        int Tinggi = Integer.parseInt(tinggi.getText());
        int Berat = Integer.parseInt(berat.getText());
        
        int Ideal = 0 ;
        
        String srn="";
        String status = "";
        
        if(cb1.isSelected()){
            Ideal = Tinggi - 105;
            if(Berat > Ideal){
            status = "Overweight";
            srn = " 1.Anda harus berolahraga lebih giat\n2.Makan Sayuran dan Buah Buahan\n3.Hindari makanan berlemak";
        }
        else if(Berat == Ideal){
            status = "Ideal";
            srn = "Anda sudah Ideal";
        }
        else if(Berat < Ideal){
            status = "Underweight";
            srn = " 1.Makan Sayuran dan Buah Buahan\n2.Makan makanan berprotein tinggi";
        }
        
        }
        else if(cb2.isSelected()){
            Ideal = Tinggi - 110;
            if(Berat > Ideal){
            status = "Overweight";
        }
        else if(Berat == Ideal){
            status = "Ideal";
        }
        else if(Berat < Ideal){
            status = "Underweight";
        }
        
        if (Berat > Ideal){
        srn = " 1.Anda harus berolahraga lebih giat\n2.Makan Sayuran dan Buah Buahan\n3.Hindari makanan berlemak";
        }
        else if (Berat == Ideal){
        srn = "Anda sudah Ideal";
        }
        else if (Berat < Ideal){
        srn = " 1.Makan Sayuran dan Buah Buahan\n2.Makan makanan berprotein tinggi";
        }
        }
    
        
        ideal.setText(""+Ideal);
        hasil.setText("Nama "+Nama+",Anda "+status);
        saran.setText(srn);
    }

    @FXML
    private void reset(ActionEvent event) {
        cb1.setSelected(false);
        cb2.setSelected(false);
        nama.setText("");
        tinggi.setText("");
        berat.setText("");
        ideal.setText("");
        hasil.setText("");
    }
    
}
