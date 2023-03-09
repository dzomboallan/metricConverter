package metricconverter;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MetricConverter extends Application {

    @Override
    public void start(Stage stage) {
        DecimalFormat df = new DecimalFormat("0.0#");

        // first the components for converting back and forth from inches to centimeters
        // create input fields, and labels to show the units
        TextField cmText = new TextField();
        Label cmLabel = new Label("Cm");
        TextField inchText = new TextField();
        Label inchLabel = new Label("Inches");

        // create buttons to perform the calculations
        Button cmToInchButton = new Button(" ===> ");
        Button inchToCmButton = new Button(" <=== ");

        // create a VBox to hold the buttons
        VBox inchButtons = new VBox();
        inchButtons.getChildren().addAll(cmToInchButton, inchToCmButton);

        // create a  HBox to hold all items for the first row
        HBox inchCmPanel = new HBox(10);
        inchCmPanel.getChildren().addAll(cmText, cmLabel, inchButtons, inchText, inchLabel);
        inchCmPanel.setAlignment(Pos.CENTER);

        // next the components for converting back and forth from miles to kilometers
        // create input fields, and labels to show the units
        TextField kmText = new TextField();
        Label kmLabel = new Label("Km");
        TextField mileText = new TextField();
        Label mileLabel = new Label("Miles  ");

        // create buttons to perform the calculation
        Button kmToMileButton = new Button(" ===> ");
        Button mileToKmButton = new Button(" <=== ");

        // create a VBox to hold the buttons
        VBox mileKmButtons = new VBox();
        mileKmButtons.getChildren().addAll(kmToMileButton, mileToKmButton);

        // create a  HBox to hold all items for the secong row
        HBox mileKmPanel = new HBox(10);
        mileKmPanel.getChildren().addAll(kmText, kmLabel, mileKmButtons, mileText, mileLabel);
        mileKmPanel.setAlignment(Pos.CENTER);

        // finally the components for converting back and forth from pounds to kilograms
        // create input fields, and labels to show the units
        TextField kgText = new TextField();
        Label kgLabel = new Label("Km");
        TextField poundText = new TextField();
        Label poundLabel = new Label("Miles  ");

        // create buttons to perform the calculation
        Button kgToPoundButton = new Button(" ===> ");
        Button poundToKgButton = new Button(" <=== ");

        // create a VBox to hold the buttons
        VBox poundKgButtons = new VBox();
        poundKgButtons.getChildren().addAll(kgToPoundButton, poundToKgButton);

        // create a  HBox to hold all items for the third row
        HBox poundKgPanel = new HBox(10);
        mileKmPanel.getChildren().addAll(kgText, kgLabel, poundKgButtons, poundText, poundLabel);
        mileKmPanel.setAlignment(Pos.CENTER);

        //create VBox to hold all these rows
        VBox root = new VBox(10);
        root.getChildren().addAll(inchCmPanel, mileKmPanel, poundKgPanel);
        root.setAlignment(Pos.CENTER);

        // write the code for the buttons
        cmToInchButton.setOnAction(e -> {
            String s = new String(cmText.getText());
            double d = Double.parseDouble(s);
            d = d / 2.54;
            s = df.format(d);
            inchText.setText(s);
        });

        cmToInchButton.setOnAction(e -> {
            String s = new String(inchText.getText());
            double d = Double.parseDouble(s);
            d = d * 2.54;
            s = df.format(d);
            cmText.setText(s);
        });

        cmToInchButton.setOnAction(e -> {
            String s = new String(kmText.getText());
            double d = Double.parseDouble(s);
            d = d / 1.609;
            s = df.format(d);
            mileText.setText(s);
        });

        cmToInchButton.setOnAction(e -> {
            String s = new String(mileText.getText());
            double d = Double.parseDouble(s);
            d = d * 1.609;
            s = df.format(d);
            kmText.setText(s);
        });

        cmToInchButton.setOnAction(e -> {
            String s = new String(kgText.getText());
            double d = Double.parseDouble(s);
            d = d * 2.2;
            s = df.format(d);
            poundText.setText(s);
        });

        cmToInchButton.setOnAction(e -> {
            String s = new String(poundText.getText());
            double d = Double.parseDouble(s);
            d = d / 2.2;
            s = df.format(d);
            kgText.setText(s);
        });

        // create a new scene
        Scene scene = new Scene(root);

        // add the scene to the stage, then configure the stage and make it visible
        stage.setScene(scene);
        stage.setTitle("Metric Converter");
        stage.setWidth(1000);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
