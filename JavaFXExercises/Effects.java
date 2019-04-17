import javafx.application.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.effect.*;

public class Effects extends Application {
    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("https://a.espncdn.com/photo/2013/1219/nba_a_kobe-bryant2_mb_1296x864.jpg");

        ImageView imageView = new ImageView(image);
        imageView.setX(50);
        imageView.setY(50);
        imageView.setFitWidth(350);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);

        Glow glow = new Glow();
        glow.setLevel(1.0);
        imageView.setEffect(glow);

        Group root = new Group(imageView);
        Scene scene = new Scene(root, 500, 500, Color.web("#f0f0f0"));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Shapes 2D");
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
