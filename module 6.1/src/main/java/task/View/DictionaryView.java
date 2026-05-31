//The DictionaryView class (View) is responsible for creating and displaying the user interface.
//Use a suitable layout (e.g., FlowPane) to display the components in the interface.
//
//Create a JavaFX application with a user interface for the dictionary.
//The user interface should include the following components:
//
//A text field where users can enter a word.
//A button to trigger the search for a word.
//A text area or label to display the word's meaning.
package task.View;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import task.Controller.DictionaryController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class DictionaryView extends Application {
    private DictionaryController cntrl;
    private Label result = new Label("");
    private final Label dot = new Label(":");
    private TextField searchW = new TextField();
    private TextField value = new TextField();
    private TextField string = new TextField();
    public void start(Stage stage) throws Exception {
        Button addWord = new Button("Add Word");
        Button search = new Button("Search");
        FlowPane top = new FlowPane();
        FlowPane mid = new FlowPane();
        FlowPane btm = new FlowPane();
        VBox vbox = new VBox();

        stage.setTitle("Dictionary");

        // outside margings
        Insets insets = new Insets(10, 10, 10, 10);

        top.setMargin(searchW, insets);
        top.setMargin(search, insets);
        mid.setMargin(value, insets);
        mid.setMargin(dot, insets);
        mid.setMargin(string, insets);
        mid.setMargin(addWord, insets);
        btm.setMargin(result, insets);

        // space for result
        result.setMinWidth(30);
        result.setAlignment(Pos.CENTER);

        top.getChildren().add(searchW);
        top.getChildren().add(search);
        mid.getChildren().add(string);
        mid.getChildren().add(dot);
        mid.getChildren().add(value);
        mid.getChildren().add(addWord);
        btm.getChildren().add(result);
        vbox.getChildren().addAll(top,mid,btm);

        //v: width, v1: height?
        Scene scene = new Scene(vbox, 500, 200);
        stage.setScene(scene);
        stage.show();

        addWord.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cntrl.addEntry(string.getText(), value.getText());
            }
        });

        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                cntrl.search(searchW.getText());
            }
        });
    }
    public void init(){
        cntrl = new DictionaryController(this);
    }

    public void setResult(String result){
        this.result.setText(result);
    }
}