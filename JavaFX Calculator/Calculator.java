import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.Scanner;

public class Calculator extends Application {
    
    private Scanner scan = new Scanner(input.getText());

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Scientific Calculator");
        BorderPane bpane = new BorderPane();
        bpane.setStyle("-fx-text-fill: #D4D4D4;");
        bpane.setPrefWidth(600);
        bpane.setPrefHeight(720);

        GridPane center = new GridPane();
        center.setPrefHeight(480);
        center.setPrefWidth(560);
        center.setVgap(20);
        center.setHgap(20);
        center.setPadding(new Insets(20));
        center.setBackground(new Background(new BackgroundFill(Color.web("#202831"), new CornerRadii(0), Insets.EMPTY)));

        VBox top = new VBox(30);
        top.setPrefHeight(200);
        top.setPadding(new Insets(20));
        top.setAlignment(Pos.BASELINE_CENTER);
        top.setBackground(new Background(new BackgroundFill(Color.web("#D4D4D4"), new CornerRadii(0), Insets.EMPTY)));

        TextField input = new TextField();
        input.setFont(Font.font("Arial", 22));
        input.setEditable(false);
        input.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #7D9185;");

        TextField output = new TextField();
        output.setFont(Font.font("Arial", 22));
        output.setEditable(false);
        output.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #7D9185;");

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("ERROR");

        Button squareButton = new Button("x^2");
        squareButton.setPrefHeight(460/7);
        squareButton.setPrefWidth(96);
        squareButton.setFont(Font.font("Arial", 30));
        squareButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(squareButton, 0, 1);
        squareButton.setOnMouseClicked(e -> {
            if (squareButton.getText().equals("x^2")) {
                input.setText(input.getText() + "^2");
            } else {
                input.setText(input.getText() + "\u221A");
            }
        });

        Button exponentButton = new Button("^");
        exponentButton.setPrefHeight(460/7);
        exponentButton.setPrefWidth(96);
        exponentButton.setFont(Font.font("Arial", 30));
        exponentButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(exponentButton, 0, 2);
        exponentButton.setOnMouseClicked(e -> {
            if (exponentButton.getText().equals("^")) {
                input.setText(input.getText() + "^");
            } else {
                if (input.getText().length() != 0) {
                    input.setText(input.getText().substring(0, input.getText().length() - 1) + "("
                        + input.getText().charAt(input.getText().length() - 1) + "x\u221A");
                } else {
                    errorAlert.setContentText("You must input an integer before inputting this character.");
                    errorAlert.showAndWait();
                }
            }
        });

        Button piButton = new Button("\u03C0");
        piButton.setPrefHeight(460/7);
        piButton.setPrefWidth(96);
        piButton.setFont(Font.font("Arial", 30));
        piButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(piButton, 0, 3);
        piButton.setOnMouseClicked(e -> input.setText(input.getText() + "\u03C0"));

        Button logButton = new Button("log(");
        logButton.setPrefHeight(460/7);
        logButton.setPrefWidth(96);
        logButton.setFont(Font.font("Arial", 30));
        logButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(logButton, 0, 4);
        logButton.setOnMouseClicked(e -> {
            if (logButton.getText().equals("log(")) {
                input.setText(input.getText() + "log(");
            } else {
                input.setText(input.getText() + "10^");
            }
        });

        Button lnButton = new Button("ln(");
        lnButton.setPrefHeight(460/7);
        lnButton.setPrefWidth(96);
        lnButton.setFont(Font.font("Arial", 30));
        lnButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(lnButton, 0, 5);
        lnButton.setOnMouseClicked(e -> {
            if (lnButton.getText().equals("ln(")) {
                input.setText(input.getText() + "ln(");
            } else {
                input.setText(input.getText() + "e^");
            }
        });

        Button openParenthesisButton = new Button("(");
        openParenthesisButton.setPrefHeight(460/7);
        openParenthesisButton.setPrefWidth(96);
        openParenthesisButton.setFont(Font.font("Arial", 30));
        openParenthesisButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(openParenthesisButton, 1, 0);
        openParenthesisButton.setOnMouseClicked(e -> input.setText(input.getText() + "("));

        Button sinButton = new Button("sin(");
        sinButton.setPrefHeight(460/7);
        sinButton.setPrefWidth(96);
        sinButton.setFont(Font.font("Arial", 30));
        sinButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(sinButton, 1, 1);
        sinButton.setOnMouseClicked(e -> {
            if (sinButton.getText().equals("sin(")) {
                input.setText(input.getText() + "sin(");
            } else {
                input.setText(input.getText() + "asin(");
            }
        });

        Button sevenButton = new Button("7");
        sevenButton.setPrefHeight(460/7);
        sevenButton.setPrefWidth(96);
        sevenButton.setFont(Font.font("Arial", 30));
        sevenButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(sevenButton, 1, 2);
        sevenButton.setOnMouseClicked(e -> input.setText(input.getText() + "7"));

        Button fourButton = new Button("4");
        fourButton.setPrefHeight(460/7);
        fourButton.setPrefWidth(96);
        fourButton.setFont(Font.font("Arial", 30));
        fourButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(fourButton, 1, 3);
        fourButton.setOnMouseClicked(e -> input.setText(input.getText() + "4"));

        Button oneButton = new Button("1");
        oneButton.setPrefHeight(460/7);
        oneButton.setPrefWidth(96);
        oneButton.setFont(Font.font("Arial", 30));
        oneButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(oneButton, 1, 4);
        oneButton.setOnMouseClicked(e -> input.setText(input.getText() + "1"));

        Button zeroButton = new Button("0");
        zeroButton.setPrefHeight(460/7);
        zeroButton.setPrefWidth(96);
        zeroButton.setFont(Font.font("Arial", 30));
        zeroButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(zeroButton, 1, 5);
        zeroButton.setOnMouseClicked(e -> input.setText(input.getText() + "0"));

        Button closeParenthesisButton = new Button(")");
        closeParenthesisButton.setPrefHeight(460/7);
        closeParenthesisButton.setPrefWidth(96);
        closeParenthesisButton.setFont(Font.font("Arial", 30));
        closeParenthesisButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(closeParenthesisButton, 2, 0);
        closeParenthesisButton.setOnMouseClicked(e -> input.setText(input.getText() + ")"));

        Button cosButton = new Button("cos(");
        cosButton.setPrefHeight(460/7);
        cosButton.setPrefWidth(96);
        cosButton.setFont(Font.font("Arial", 30));
        cosButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A");
        center.add(cosButton, 2, 1);
        cosButton.setOnMouseClicked(e -> {
            if (cosButton.getText().equals("cos(")) {
                input.setText(input.getText() + "cos(");
            } else {
                input.setText(input.getText() + "acos(");
            }
        });

        Button eightButton = new Button("8");
        eightButton.setPrefHeight(460/7);
        eightButton.setPrefWidth(96);
        eightButton.setFont(Font.font("Arial", 30));
        eightButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(eightButton, 2, 2);
        eightButton.setOnMouseClicked(e -> input.setText(input.getText() + "8"));

        Button fiveButton = new Button("5");
        fiveButton.setPrefHeight(460/7);
        fiveButton.setPrefWidth(96);
        fiveButton.setFont(Font.font("Arial", 30));
        fiveButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(fiveButton, 2, 3);
        fiveButton.setOnMouseClicked(e -> input.setText(input.getText() + "5"));

        Button twoButton = new Button("2");
        twoButton.setPrefHeight(460/7);
        twoButton.setPrefWidth(96);
        twoButton.setFont(Font.font("Arial", 30));
        twoButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(twoButton, 2, 4);
        twoButton.setOnMouseClicked(e -> input.setText(input.getText() + "2"));

        Button decimalButton = new Button(".");
        decimalButton.setPrefHeight(460/7);
        decimalButton.setPrefWidth(96);
        decimalButton.setFont(Font.font("Arial", 30));
        decimalButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(decimalButton, 2, 5);
        decimalButton.setOnMouseClicked(e -> input.setText(input.getText() + "."));

        Button delButton = new Button("DEL");
        delButton.setPrefHeight(460/7);
        delButton.setPrefWidth(96);
        delButton.setFont(Font.font("Arial", 28));
        delButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(delButton, 3, 0);
        delButton.setOnMouseClicked(e -> {
            if (input.getText.length() != 0) {
                input.setText(input.getText().substring(0, input.getText().length() - 1))
            }
        });

        Button tanButton = new Button("tan(");
        tanButton.setPrefHeight(460/7);
        tanButton.setPrefWidth(96);
        tanButton.setFont(Font.font("Arial", 30));
        tanButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(tanButton, 3, 1);
        tanButton.setOnMouseClicked(e -> {
                if (tanButton.getText().equals("tan(")) {
                    input.setText(input.getText() + "tan(");
                } else {
                    input.setText(input.getText() + "atan(");
                }
        });

        Button nineButton = new Button("9");
        nineButton.setPrefHeight(460/7);
        nineButton.setPrefWidth(96);
        nineButton.setFont(Font.font("Arial", 30));
        nineButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(nineButton, 3, 2);
        nineButton.setOnMouseClicked(e -> input.setText(input.getText() + "9"));

        Button sixButton = new Button("6");
        sixButton.setPrefHeight(460/7);
        sixButton.setPrefWidth(96);
        sixButton.setFont(Font.font("Arial", 30));
        sixButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(sixButton, 3, 3);
        sixButton.setOnMouseClicked(e -> input.setText(input.getText() + "6"));

        Button threeButton = new Button("3");
        threeButton.setPrefHeight(460/7);
        threeButton.setPrefWidth(96);
        threeButton.setFont(Font.font("Arial", 30));
        threeButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(threeButton, 3, 4);
        threeButton.setOnMouseClicked(e -> input.setText(input.getText() + "3"));

        Button negativeButton = new Button("(-)");
        negativeButton.setPrefHeight(460/7);
        negativeButton.setPrefWidth(96);
        negativeButton.setFont(Font.font("Arial", 30));
        negativeButton.setStyle("-fx-text-fill: #202831;" +
                            "-fx-background-color: #FFFFFF;");
        center.add(negativeButton, 3, 5);
        negativeButton.setOnMouseClicked(e -> {
                if (negativeButton.getText().equals("(-)")) {
                    input.setText(input.getText() + "-");
                } else {
                    input.setText(input.getText() + "Ans");
                }
        });

        Button clearButton = new Button("CLR");
        clearButton.setPrefHeight(460/7);
        clearButton.setPrefWidth(96);
        clearButton.setFont(Font.font("Arial", 28));
        clearButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A;");
        center.add(clearButton, 4, 0);
        clearButton.setOnMouseClicked(e -> input.setText(""));


        Button divideButton = new Button("/");
        divideButton.setPrefHeight(460/7);
        divideButton.setPrefWidth(96);
        divideButton.setFont(Font.font("Arial", 30));
        divideButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A");
        center.add(divideButton, 4, 1);
        divideButton.setOnMouseClicked(e -> input.setText(input.getText() + "/"));

        Button multiplyButton = new Button("*");
        multiplyButton.setPrefHeight(460/7);
        multiplyButton.setPrefWidth(96);
        multiplyButton.setFont(Font.font("Arial", 30));
        multiplyButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A");
        center.add(multiplyButton, 4, 2);
        multiplyButton.setOnMouseClicked(e -> input.setText(input.getText() + "*"));

        Button subtractButton = new Button("-");
        subtractButton.setPrefHeight(460/7);
        subtractButton.setPrefWidth(96);
        subtractButton.setFont(Font.font("Arial", 30));
        subtractButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A");
        center.add(subtractButton, 4, 3);
        subtractButton.setOnMouseClicked(e -> input.setText(input.getText() + "-"));

        Button addButton = new Button("+");
        addButton.setPrefHeight(460/7);
        addButton.setPrefWidth(96);
        addButton.setFont(Font.font("Arial", 30));
        addButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A");
        center.add(addButton, 4, 4);
        addButton.setOnMouseClicked(e -> input.setText(input.getText() + "+"));

        Button equalsButton = new Button("=");
        equalsButton.setPrefHeight(460/7);
        equalsButton.setPrefWidth(96);
        equalsButton.setFont(Font.font("Arial", 30));
        equalsButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #3D4A6A");
        center.add(equalsButton, 4, 5);
        equalsButton.setOnMouseClicked(e -> {
            Double answer = this.calculate(input.getText());
            input.setText("");
            output.setText(answer.toString());
        });

        Button secondButton = new Button("2nd");
        secondButton.setPrefHeight(460/7);
        secondButton.setPrefWidth(96);
        secondButton.setFont(Font.font("Arial", 30));
        secondButton.setStyle("-fx-text-fill: #FFFFFF;" +
                            "-fx-background-color: #B1C9F6;");
        center.add(secondButton, 0, 0);
        secondButton.setOnMouseClicked(e -> {
            if (lnButton.getText().equals("ln(")) {
                exponentButton.setText("x\u221A");
                squareButton.setText("\u221A");
                logButton.setText("10^x");
                sinButton.setText("asin(");
                lnButton.setText("e^x");
                cosButton.setText("acos(");
                tanButton.setText("atan(");
                negativeButton.setText("ANS");
            } else {
                exponentButton.setText("^");
                squareButton.setText("x^2");
                logButton.setText("log(");
                sinButton.setText("sin(");
                lnButton.setText("ln(");
                cosButton.setText("cos(");
                tanButton.setText("tan(");
                negativeButton.setText("(-)");
            }
        });


        top.getChildren().addAll(input, output);

        bpane.setCenter(center);
        bpane.setTop(top);

        Scene scene = new Scene(bpane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
        
    public Double calculate(String expression) {
        Double answer = 0.0;
        int index = 0;
        while (scan.hasNext()) {
            String operation = "";
            int prevNum = scan.nextInt();
            while (!scan.hasNextInt()) {
                operation += scan.next();
                if (operation == "^") {

                }
            }
        }
        return answer;
    } 
}