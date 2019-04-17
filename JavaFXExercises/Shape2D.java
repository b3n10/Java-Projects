import javafx.application.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class Shape2D extends Application {
    @Override
    public void start(Stage primaryStage) {
        Path path = new Path();
        path.setStrokeWidth(20.0);

        ObservableList<PathElement> paths = path.getElements();
        paths.add(new MoveTo(108, 71));
        paths.add(new LineTo(321, 161));
        paths.add(new LineTo(126, 232));
        paths.add(new LineTo(232, 52));
        paths.add(new LineTo(269, 250));
        paths.add(new LineTo(108, 71));

        Group root = new Group(path);
        Scene scene = new Scene(root, 500, 500, Color.web("#f0f0f0"));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Shapes 2D");
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
