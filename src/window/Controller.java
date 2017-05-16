package window;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private Button exitBtn, shifrBtn, deshifrBtn, back, tFile,fFile,startBnt;

    @FXML
    private Label tLabel,fLabel;

    @FXML
    private TextArea tTxt,fTxt;
    @FXML
    private TextField aField,bField,cField;

    @FXML
    private AnchorPane start, versions, formula;


    public void goD(ActionEvent event) {
        shifrBtn.setVisible(false);
        deshifrBtn.setDisable(true);
        exitBtn.setVisible(false);
        versions.setVisible(true);
    }
    public void goS(ActionEvent event) {
        shifrBtn.setDisable(true);exitBtn.setVisible(false);

        deshifrBtn.setVisible(false);
        versions.setVisible(true);

    }

    public void backAction(ActionEvent event) {
        deshifrBtn.setVisible(true);
        shifrBtn.setVisible(true);
        deshifrBtn.setDisable(false);
        shifrBtn.setDisable(false);
        versions.setVisible(false);
        exitBtn.setVisible(true);
    }

    public void filefile(){
        tFileSetVisible(true);
        fFileSetVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
    }

    public void txtfile(){
        tFileSetVisible(true);
        fTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
    }

    public void txttxt(){
        tTxt.setVisible(true);
        fTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
    }

    public void filetxt(){
        fFileSetVisible(true);
        tTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
    }


    private void formulaSetVisible(boolean flag){
        formula.setVisible(flag);
    }

    private void tFileSetVisible(boolean flag){
        tFile.setVisible(flag);
        tLabel.setVisible(flag);
    }

    private void fFileSetVisible(boolean flag){
        fFile.setVisible(flag);
        fLabel.setVisible(flag);
    }

    public void goWork(ActionEvent event){

    }

    public void backVariants(){
        versions.setVisible(true);
        formulaSetVisible(false);
        tFileSetVisible(false);
        fFileSetVisible(false);
        tTxt.setVisible(false);
        fTxt.setVisible(false);
        tTxt.setText("");
        fTxt.setText("");
        tLabel.setText("");
        fLabel.setText("");
        shifrBtn.setDisable(true);
        aField.setText("");
        bField.setText("");
        cField.setText("");
    }


       public void close(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

}
