package window;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import infoWindow.InfoWindow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML
    private Button exitBtn, shifrBtn, deshifrBtn, back, tFile,fFile,startBtn;

    @FXML
    private Label tLabel,fLabel;

    @FXML
    private TextArea tTxt,fTxt;
    @FXML
    private TextField aField,bField,cField;

    @FXML
    private AnchorPane start, versions, formula;

    final String TO_FILE="TO_FILE",TO_TXT="TO_TXT",SHIFR="SHIFR",DESHIFR="DESHIFR";


    String to="",type="";

    File t=null,f=null;

    public void goD(ActionEvent event) {
        shifrBtn.setVisible(false);
        deshifrBtn.setDisable(true);
        exitBtn.setVisible(false);
        versions.setVisible(true);
        type=DESHIFR;
    }
    public void goS(ActionEvent event) {
        shifrBtn.setDisable(true);exitBtn.setVisible(false);
        type=SHIFR;
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
        to=TO_FILE;
    }

    public void txtfile(){
        tFileSetVisible(true);
        fTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to=TO_FILE;
    }

    public void txttxt(){
        tTxt.setVisible(true);
        fTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to=TO_TXT;
    }

    public void filetxt(){
        fFileSetVisible(true);
        tTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to=TO_TXT;
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

        if(valid(event)){System.out.println(valid(event));}
        else {
            new InfoWindow();
        }

    }

    public boolean valid(ActionEvent event){
         System.out.print("1: ");
            System.out.println(isNumeric(aField.getText())&&isNumeric(bField.getText())
                    &&isNumeric(cField.getText()));
            System.out.print("2: ");
            System.out.println((fLabel.getText().length()>0||fTxt.getText().length()>0));
            if(isNumeric(aField.getText())&&isNumeric(bField.getText())
                    &&isNumeric(cField.getText())&&(fLabel.getText().length()>0||fTxt.getText().length()>0)){
                if((to.compareTo(TO_FILE)==0&&tLabel.getText().length()>0)||to.compareTo(TO_TXT)==0){
                    return true;
                }
                else {
                    return false;
                }}
            else{
                return false;
            }


    }
    private static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
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
//        startBtn.setDisable(true);
        aField.setText("");
        bField.setText("");
        cField.setText("");
        to="";
    }

    public void choosetFile(){
        File file = chooseFile();
        if (file == null) {
            System.out.println("lol");
        }else{
            t=file;
            tLabel.setText(file.getAbsolutePath());
            System.out.println(tTxt.getText());
        }
    }

    public void choosefFile(){
        File file = chooseFile();
        if (file == null) {
            System.out.println("lol");
        }else{
            f=file;
            fLabel.setText(file.getAbsolutePath());
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
            System.out.println(fTxt.getText());
        }
    }

       public void close(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    private File chooseFile() {
        Stage stage = (Stage) start.getScene().getWindow();
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt", "*.txt"));
        return fc.showOpenDialog(stage);
    }

}
