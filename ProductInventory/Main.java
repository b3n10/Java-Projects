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

public class Main extends Application {
    private Button btn_qUP;
    private Button btn_qDOWN;

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

        EventHandler<ActionEvent> quantityChange = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int quantity = Integer.parseInt(txt_quantity.getText());

                if (event.getSource() == btn_qUP) {
                    quantity++; // increase quantity
                } else {
                    if (quantity != 0) quantity--; // decrease quantity
                }

                txt_quantity.setText(String.valueOf(quantity));
            }
        };

        btn_qUP.setOnAction(quantityChange);
        btn_qDOWN.setOnAction(quantityChange);

        GridPane gridPane = new GridPane();
        GridPane gridPane_quantity = new GridPane();

        gridPane.add(lbl_name, 0, 0);
        gridPane.add(txt_name, 1, 0);

        gridPane.add(lbl_price, 0, 1);
        gridPane.add(txt_price, 1, 1);

        gridPane.add(lbl_quantity, 0, 2);
        gridPane_quantity.add(btn_qUP, 0, 0);
        gridPane_quantity.add(txt_quantity, 1, 0);
        gridPane_quantity.add(btn_qDOWN, 2, 0);
        gridPane_quantity.setAlignment(Pos.CENTER);
        gridPane.add(gridPane_quantity, 1, 2);

        gridPane.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventory System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        Product colgate = new Product("Colgate", 10.2, 2);
        Product hersheys = new Product("Hersheys", 89.3, 5);

        Inventory inventory = new Inventory();
        inventory.add(colgate);
        inventory.add(hersheys);
        inventory.add(new Product("Xiaomi", 13_894.6, 3));

        double price = 0;

        /*
        System.out.println("All products:");
        for (Product product : inventory.getProducts()) {
            System.out.println(product.getName() + " (" + product.getQuantity() + "): " + product.getPrice());
            price += product.getQuantity() * product.getPrice();
        }

        System.out.println("\nTotal price of products: " + String.format("%.2f", price));
        */
    }
}
