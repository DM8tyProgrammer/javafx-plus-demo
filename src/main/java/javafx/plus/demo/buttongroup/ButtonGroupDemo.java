package javafx.plus.demo.buttongroup;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.plus.component.buttongroup.ButtonGroup;
import javafx.plus.util.ButtonBuilder;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.plus.component.*;

/**
 * @author theBeacon
 */
public class ButtonGroupDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        ButtonGroup bg = new ButtonGroup();

        bg.addButtons(new Button("AAAAA"),new Button("BBB"),new Button("C"));


        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(bg,0.0);
        AnchorPane.setLeftAnchor(bg,0.0);


        Button changeLayoutButton = ButtonBuilder.newBuilder().label("Change Layout").on(event -> {
            if(bg.getOrientation() == ButtonGroup.Orientation.HORIZONTAL) {
                bg.setOrientation(ButtonGroup.Orientation.VERTICAL);
            } else {
                bg.setOrientation(ButtonGroup.Orientation.HORIZONTAL);
            }
        }).build();

        AnchorPane.setLeftAnchor(changeLayoutButton,250.0);
        AnchorPane.setTopAnchor(changeLayoutButton,250.0);



        Button addButton = ButtonBuilder.newBuilder().label("Add a button").on(event -> {
            int times = (int)(Math.random()*9)+1;
            StringBuilder label = new StringBuilder();
            for(int i=0;i<times;i++) {
                label.append(times);
            }

            bg.addButton(new Button(label.toString()));
        }).build();

        AnchorPane.setLeftAnchor(addButton,120.0);
        AnchorPane.setTopAnchor(addButton,250.0);

        Button removeButton = ButtonBuilder.newBuilder().label("Remove First").on(event -> {
            if(!bg.getButtons().isEmpty()){
                bg.getButtons().remove(0);
            }
        }).build();

        AnchorPane.setLeftAnchor(removeButton,0.0);
        AnchorPane.setTopAnchor(removeButton,250.0);


        pane.setPadding(new Insets(10));


        pane.getChildren().addAll(bg,changeLayoutButton,addButton,removeButton);
        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(ButtonGroupDemo.class);
    }

}
