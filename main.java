//package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("HBox Experiment 1");

        TextField textField = new TextField();
        Button button = new Button("My Button");

        HBox hbox = new HBox(textField, button);
        button.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                A a=new A(textField.getText());
                Thread thread_object=new Thread(a);
                thread_object.start();
            }


        });

        Scene scene = new Scene(hbox, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class A implements Runnable
    {
        String to_print;
        A(String to_print){
            this.to_print=to_print;
        }
        public void run(){
            StringBuilder input = new StringBuilder();

            // append a string into StringBuilder input1
            input.append(this.to_print);

            // reverse StringBuilder input1
            input = input.reverse();
            System.out.println(input);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
