import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Line line = new Line();
        line.setStartX(50);
        line.setStartY(40);
        line.setEndX(400);
        line.setEndY(40);

        Text text = new Text("hello ethan");
        text.setFont(new Font(50));
        text.setX(50);
        text.setY(60);

        Group root = new Group();
        ObservableList<Node> list = root.getChildren();
        list.add(line);
        list.add(text);

        Scene scene = new Scene(root, 500, 500);

        stage.setTitle("Sample");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
