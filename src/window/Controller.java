package window;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import infoWindow.InfoWindow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import window.logic.Common;
import window.logic.Deshifr;
import window.logic.Result;
import window.logic.Shifr;

import java.io.*;

public class Controller {

    @FXML
    private Button exitBtn, shifrBtn, deshifrBtn, back, tFile, fFile, startBtn;

    @FXML
    private Label tLabel, fLabel,okLabel;

    @FXML
    private TextArea tTxt, fTxt;
    @FXML
    private TextField aField, bField, cField;

    @FXML
    private AnchorPane start, versions, formula;

    @FXML
    private ProgressIndicator loading;

    final String TO_FILE = "TO_FILE", TO_TXT = "TO_TXT", SHIFR = "SHIFR", DESHIFR = "DESHIFR";


    String to = "", type = "";

    File t = null, f = null;

    public void goD(ActionEvent event) {
        shifrBtn.setVisible(false);
        deshifrBtn.setDisable(true);
        exitBtn.setVisible(false);
        versions.setVisible(true);
        type = DESHIFR;
    }

    public void goS(ActionEvent event) {
        shifrBtn.setDisable(true);
        exitBtn.setVisible(false);
        type = SHIFR;
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

    public void filefile() {
        tFileSetVisible(true);
        fFileSetVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to = TO_FILE;
    }

    public void txtfile() {
        tFileSetVisible(true);
        fTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to = TO_FILE;
    }

    public void txttxt() {
        tTxt.setVisible(true);
        fTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to = TO_TXT;
    }

    public void filetxt() {
        fFileSetVisible(true);
        tTxt.setVisible(true);
        formulaSetVisible(true);
        versions.setVisible(false);
        to = TO_TXT;
    }


    private void formulaSetVisible(boolean flag) {
        formula.setVisible(flag);
    }

    private void tFileSetVisible(boolean flag) {
        tFile.setVisible(flag);
        tLabel.setVisible(flag);
    }

    private void fFileSetVisible(boolean flag) {
        fFile.setVisible(flag);
        fLabel.setVisible(flag);
    }

    public void goWork(ActionEvent event) {

        if (valid(event)) {
            String text = "";
            if (fTxt.getText().length() > 0) {
                text = fTxt.getText();
            } else {
                try (BufferedReader br = new BufferedReader(new FileReader(fLabel.getText()))) {

                    String sCurrentLine;

                    while ((sCurrentLine = br.readLine()) != null) {
                        text += sCurrentLine + "\n";
                        System.out.println(sCurrentLine);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(text);
            int a = Integer.parseInt(aField.getText()), b = Integer.parseInt(bField.getText()), c = Integer.parseInt(cField.getText());
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            Thread thread = new Thread();
            if (type.compareTo(SHIFR) == 0) {
                Shifr  shirf = new Shifr(a, b, c, text);
                thread= new Thread(shirf);
            } else {
                Deshifr deshirf = new Deshifr(a, b, c, text);
                thread= new Thread(deshirf);
            }
            loading.setVisible(true);
            startBtn.setVisible(false);
            thread.start();
            while (thread.isAlive()) {
//                System.out.println("Imhere");
            }

                    loading.setVisible(false);

//            loading.setVisible(false);

                    okLabel.setVisible(true);


            for(int i=0;i<9; i++){

                        okLabel.setOpacity(1-(0.1*9));


                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

                    okLabel.setVisible(false);

//            okLabel.setVisible(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    okLabel.setOpacity(1);
                }
            });
//            okLabel.setOpacity(1);
            if(to.compareTo(TO_TXT)==0){
                tTxt.setText(Result.res);
            }
            else {

                FileWriter fw = null;
                try {
                    fw = new FileWriter(tLabel.getText());

                    fw.write(Result.res);

                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            loading.setVisible(false);
            startBtn.setVisible(true);

        } else {
            new InfoWindow();
        }

    }

    public boolean valid(ActionEvent event) {
        System.out.print("1: ");
        System.out.println(isNumeric(aField.getText()) && isNumeric(bField.getText())
                && isNumeric(cField.getText()));
        System.out.print("2: ");
        System.out.println((fLabel.getText().length() > 0 || fTxt.getText().length() > 0));
        if (isNumeric(aField.getText()) && isNumeric(bField.getText())
                && isNumeric(cField.getText()) && (fLabel.getText().length() > 0 || fTxt.getText().length() > 0)) {
            if ((to.compareTo(TO_FILE) == 0 && tLabel.getText().length() > 0) || to.compareTo(TO_TXT) == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public void backVariants() {
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
        to = "";
    }

    public void choosetFile() {
        File file = chooseFile();
        if (file == null) {
            System.out.println("lol");
        } else {
            t = file;
            tLabel.setText(file.getAbsolutePath());
            System.out.println(tTxt.getText());
        }
    }

    public void choosefFile() {
        File file = chooseFile();
        if (file == null) {
            System.out.println("lol");
        } else {
            f = file;
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
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("*.txt", "*.txt"));
        return fc.showOpenDialog(stage);
    }

}
