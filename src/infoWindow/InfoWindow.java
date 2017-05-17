package infoWindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by rkara on 24.01.2017.
 */
public class InfoWindow {
    public InfoWindow() {
        Stage primaryStage = new Stage();
        String logo= "../image/encryption.png";
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        primaryStage.setResizable(false);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("info.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);

        // primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Ошибка ввода");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(logo)));
        primaryStage.show();
    }
}
