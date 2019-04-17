import javafx.application.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;

public class UIControls extends Application {
    private TextField tf_name;
    private PasswordField tf_password;

    @Override
    public void start(Stage primaryStage) {
        Text txt_name = new Text("Name:");
        Text txt_password = new Text("Password:");

        tf_name = new TextField();
        tf_password = new PasswordField();

        Button btn_login = new Button("Login");
        btn_login.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = tf_name.getText();
                if (! name.equals("")) {
                    System.out.println("name: " + tf_name.getText());
                }
            }
        });

        Button btn_exit = new Button("X");
        btn_exit.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 0, 0, 0));
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.add(txt_name, 0, 0);
        gridPane.add(tf_name, 1, 0);
        gridPane.add(txt_password, 0, 1);
        gridPane.add(tf_password, 1, 1);
        gridPane.add(btn_login, 0, 2);
        gridPane.add(btn_exit, 0, 3);

        GridPane.setMargin(tf_name, new Insets(0,0,0,10));
        GridPane.setMargin(tf_password, new Insets(0,0,0,10));

        Scene scene = new Scene(gridPane, 500, 500, Color.web("#f0f0f0"));

        primaryStage.setScene(scene);
        primaryStage.setTitle("UI Controls");
        primaryStage.show();
    }

    public static void main(String [] args) {
        launch(args);
    }
}
