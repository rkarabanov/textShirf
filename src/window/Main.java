package window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        String logo= "../image/encryption.png";
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Нелинейная функция - шифрование текста");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(logo)));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
