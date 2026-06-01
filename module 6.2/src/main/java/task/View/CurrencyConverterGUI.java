//Your task is to implement a currency converter application.
//The application should allow the user to convert
// an amount of money from one currency to another.
//The application should have a graphical user interface,
// and it should be implemented with the MVC pattern.

//Requirements for the user interface:
//The user interface should consist of a window
// with appropriate dimensions to display the converter components.
//The window should have a title indicating the purpose of the application, such as "Currency Converter."
//Use appropriate layout(s) to organize the components effectively.
//The user interface should include the following components:
//Two text fields for inputting the amount to convert and displaying the converted amount.
//Two choice boxes or combo boxes for selecting the source currency and the target currency.
//A button labeled "Convert" to initiate the currency conversion.
//Labels to indicate the purpose of each input field, choice box, and the result field.
//The labels for the choice boxes should appear right on top of each choice box.
//The choice boxes should contain a list of available currencies that the user can select from.
//The list of currencies should be retrieved from the model, which should contain the abbreviation,
// name, and conversion rate to a fixed currency (e.g., USD).
//The user interface should provide clear instructions on how to use the converter.
//Implement the appropriate event handling for the button to trigger the controller.
//The controller should compute the actual result based on the information obtained
// from the model and update the result field accordingly.
//The user interface should handle any potential errors or invalid input gracefully,
// providing appropriate error messages if necessary.
//Adjust the font and font size using CSS to improve screen readability.
//The font should be changed to a sans-serif font for better legibility.
package task.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import task.Controller.ConverterController;

import java.util.Arrays;

public class CurrencyConverterGUI extends Application {
    private ConverterController ctrl;
    private final TextField result = new TextField();
    private final Label type = new Label();
    private final TextField from = new TextField();

    public void start(Stage stage){
        // outside margings
        Insets insets = new Insets(10, 10, 10, 10);
        Insets text = new Insets(5,10,10,10);
        Insets button = new Insets(0,10,10,10);

        Font f = Font.font("sans-serif", 15);
        Label t1 = new Label(("This program will convert the currency on the left to the one on the right."));
        t1.setFont(f);
        HBox.setMargin(t1, insets);
        Label t2 = new Label("You can press Tab and Shift+Tab to quickly move between input fields.");
        t2.setFont(f);
        HBox.setMargin(t2, insets);

        Button convert = new Button("Convert");
        convert.setFont(f);
        Button flip = new Button("Flip");
        flip.setFont(f);
        HBox flp = new HBox(flip);

        Label t3 = new Label("From:");
        t3.setFont(f);
        HBox fromLabel = new HBox(t3);
        Label t4 = new Label("=>");
        t4.setFont(f);
        HBox arrow = new HBox(t4);
        Label t5 = new Label("To:");
        t5.setFont(f);
        HBox toLabel = new HBox(t5);
        HBox tuto = new HBox(t1);
        HBox boxText = new HBox(t2);

        ChoiceBox<String> fromBox = new ChoiceBox<>(ctrl.getCrncs());
        ChoiceBox<String> toBox = new ChoiceBox<>(ctrl.getCrncs());
        fromBox.setStyle("-fx-font: 15px \"sans-serif\";");
        toBox.setStyle("-fx-font: 15px \"sans-serif\";");
        VBox side = new VBox();
        HBox mid = new HBox();
        HBox btm = new HBox();
        GridPane select = new GridPane();

        System.out.println(this+": Available currencies: "+Arrays.toString(ctrl.getCrncs().toArray()));

        stage.setTitle("◍ Currency Converter ◍");

        HBox.setMargin(type, text);
        HBox.setMargin(convert, button);

        VBox.setMargin(fromLabel, button);
        VBox.setMargin(toLabel, button);
        VBox.setMargin(flip, button);
        HBox.setMargin(boxText, insets);

        arrow.setMinWidth(30);
        fromLabel.setMinWidth(30);
        fromBox.setMinWidth(30);
        arrow.setAlignment(Pos.BASELINE_CENTER);
        flp.setAlignment(Pos.BASELINE_CENTER);
        fromLabel.setAlignment(Pos.BASELINE_CENTER);
        toLabel.setAlignment(Pos.BASELINE_CENTER);

        HBox.setMargin(tuto, insets);
        HBox.setMargin(from, button);
        HBox.setMargin(result, button);

        // space for result
        result.setMinWidth(30);
        result.setAlignment(Pos.CENTER);

        select.getColumnConstraints().add(new ColumnConstraints(70));
        select.getColumnConstraints().add(new ColumnConstraints(70));
        select.getColumnConstraints().add(new ColumnConstraints(70));
        select.getRowConstraints().add(new RowConstraints(20));
        select.getRowConstraints().add(new RowConstraints(30));
        select.setAlignment(Pos.BASELINE_CENTER);


        select.add(fromLabel, 0,0);
        select.add(arrow,1,0);
        select.add(toLabel, 2,0);

        select.add(fromBox,0,1);
        select.add(flp,1,1);
        select.add(toBox,2,1);


        tuto.setAlignment(Pos.BASELINE_CENTER);
        boxText.setAlignment(Pos.BASELINE_CENTER);
        mid.getChildren().addAll(from, convert);
        mid.setAlignment(Pos.BASELINE_CENTER);
        btm.getChildren().addAll(result,type);
        btm.setMinWidth(200);
        btm.setAlignment(Pos.BASELINE_CENTER);
        side.getChildren().addAll(tuto, select, boxText, mid, btm);
        fromBox.getSelectionModel().select(2);
        toBox.getSelectionModel().select(3);


        from.setPromptText("Monetary units");
        from.setFont(f);
        result.setPromptText("Result will show up here.");
        result.setFont(f);
        from.getParent().requestFocus();
        result.getParent().requestFocus();

        Scene sc = new Scene(side, 500,200);
        sc.getStylesheets().add("style.css");
        stage.setMinWidth(550);
        stage.setMinHeight(250);
        stage.setScene(sc);
        stage.show();

        /// Source - https://stackoverflow.com/a/30796829
        /// Posted by Evan Knowles, modified by community (& me to filter 'double' instead of 'int').
        /// See post 'Timeline' for change history
        /// Retrieved 2026-05-31, License - CC BY-SA 3.0
        // force the field to be 'double' only
        from.textProperty().addListener(
                (observable, oldValue, newValue) -> {
            if (!newValue.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
                if (from.getLength() == 0)
                    newValue="";
                else
                    newValue = from.getText().substring(0, from.getLength()-1);
                from.setText(newValue);
            }
        });

        convert.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                double currency = Double.parseDouble(from.getText()+0);
                ctrl.Convert(fromBox.getValue(), toBox.getValue(), 0+currency);
            }
        });
        flip.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String temp = fromBox.getValue();
                fromBox.setValue(toBox.getValue());
                toBox.setValue(temp);
            }
        });
    }

    public void init() {ctrl = new ConverterController(this);}

    public void setResult(double result, String to){
        if (result == -1){
            this.result.setText("Empty input.");
            this.type.setText("");
        } else {
            this.result.setText(result+"");
            this.type.setText(to);
        }
    }
}