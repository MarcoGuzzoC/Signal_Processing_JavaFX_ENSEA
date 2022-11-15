package ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main extends Application {
    @Override
public void start(Stage primaryStage) throws Exception{
    try {
        BorderPane root = new BorderPane();
        root.setTop(createToolbar());
        root.setBottom(createStatusbar());
        root.setCenter(createMainContent());
        Pane pane = new Pane(root);
        Scene scene = new Scene(pane, 1500, 800, true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The JavaFX audio processor");
        primaryStage.show();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}

private Node createToolbar(){
    Button button = new Button("Press here");
    ToolBar tb = new ToolBar(button, new Label("This is a label"),new Separator());
    button.setOnAction(event -> System.out.println("Press"));
    ComboBox<String> cb = new ComboBox<>();
    cb.getItems().addAll("Item 1","Item 2","Item 3");
    tb.getItems().add(cb);
    return tb;
}
private Node createStatusbar(){
    HBox statusbar = new HBox();
    statusbar.getChildren().addAll(new Label("Name:"), new TextField("     "));
    return statusbar;
    }
private Node createMainContent(){
    Group g = new Group();

    return g;
}

    public static void main(String[] args) {
        launch(args);
    }
}