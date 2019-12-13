import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.event.ActionEvent;
import java.util.ArrayList;

public class Main extends Application {
    private Inventory inventory;

    public Main() {
        inventory = new Inventory();
    }

    @Override
    public void start(Stage primaryStage) {
        Label lbl_name = new Label("Name:");
        Label lbl_price = new Label("Price:");
        Label lbl_quantity = new Label("Quantity:");

        TextField txt_name = new TextField();
        TextField txt_price = new TextField();
        TextField txt_quantity = new TextField("0");
        txt_quantity.setPrefColumnCount(3);
        txt_quantity.setAlignment(Pos.CENTER);

        Button btn_qUP = new Button("+");
        Button btn_qDOWN = new Button("-");
        Button btn_save = new Button("Save");
        Button btn_new = new Button("New");

        EventHandler<ActionEvent> quantityChange = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int quantity = Integer.parseInt(txt_quantity.getText());

                // increase quantity
                if (event.getSource() == btn_qUP) quantity++;
                // decrease quantity
                else
                    if (quantity != 0) quantity--;

                txt_quantity.setText(String.valueOf(quantity));
            }
        };

        EventHandler<ActionEvent> saveProduct = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = txt_name.getText();
                String price = txt_price.getText();
                String quantity = txt_quantity.getText();
                ArrayList<String> names = new ArrayList<>();

                for (Product product : inventory.getProducts()) {
                    names.add(product.getName());
                }

                if (! name.equals("") && ! price.equals("") && ! quantity.equals("")) {
                    if (names.contains(name)) {
                        System.out.println("Product already in the list.");
                    } else {
                        inventory.add(new Product(name, Double.parseDouble(price), Integer.parseInt(quantity)));
                    }

                    for (Product product : inventory.getProducts()) {
                        System.out.println(product.getName().toUpperCase() + " (" + product.getQuantity() + "): " + product.getPrice() );
                    }
                } else {
                    System.out.println("Incomplete inputs.");
                }

            }
        };

        EventHandler<ActionEvent> newProduct = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt_name.setText("");
                txt_price.setText("");
                txt_quantity.setText("0");
                txt_name.requestFocus();
            }
        };

        btn_qUP.setOnAction(quantityChange);
        btn_qDOWN.setOnAction(quantityChange);
        btn_save.setOnAction(saveProduct);
        btn_new.setOnAction(newProduct);

        GridPane gp_main = new GridPane();
        GridPane gp_quantity = new GridPane();

        gp_main.add(lbl_name, 0, 0);
        gp_main.add(txt_name, 1, 0);

        gp_main.add(lbl_price, 0, 1);
        gp_main.add(txt_price, 1, 1);

        gp_main.add(lbl_quantity, 0, 2);
        gp_main.add(gp_quantity, 1, 2);

        gp_main.add(btn_save, 0, 3);
        gp_main.add(btn_new, 1, 3);

        gp_quantity.add(btn_qUP, 0, 0);
        gp_quantity.add(txt_quantity, 1, 0);
        gp_quantity.add(btn_qDOWN, 2, 0);
        gp_quantity.setAlignment(Pos.CENTER);

        gp_main.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(gp_main);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
