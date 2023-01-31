package com.example.functiondraw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private TextField TextResult;

    @FXML
    private Canvas canvas;



    @FXML
    public void Evaluate(ActionEvent event) throws Exception {
        String function =TextResult.getText();
        String Expression="";
        double height=canvas.getHeight();
        double width=canvas.getWidth();
        GraphicsContext gc = canvas.getGraphicsContext2D() ;
        gc.setLineWidth(1.0);
        gc.moveTo(width/2, 0);
        gc.lineTo(width/2, height);
        gc.stroke();
        gc.setLineWidth(1.0);
        gc.moveTo(0, height/2);
        gc.lineTo(width, height/2);
        gc.stroke();
        System.out.println(width+" "+height);


        double centerPoint =width/2;
        double centerHeight=height/2;
        for(double i=-100;i<100;i=i+.2)
        {
            for(int j=0;j<function.length();j++)
            {
               if(function.charAt(j)=='x'||function.charAt(j)=='X')
               {
                   Expression+=String.valueOf(i);
               }
               else if(function.charAt(j)=='*')
               {
                   Expression+="x";
               }
               else {
                   Expression += function.charAt(j);
               }
            }
            String result =Main_Algorithm.Calculator(Expression);
            if(result=="Error")
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.show();
            }else {
                double y = Double.parseDouble(result);
                gc.setLineWidth(1.0);
                gc.moveTo(centerPoint+i,(-y-.09+centerHeight));
                gc.lineTo(centerPoint+i, (-y+centerHeight));
                gc.stroke();
                System.out.println(i+" "+y);
                System.out.println(centerPoint+i+"    "+(y-.09+centerHeight));

            }
            Expression="";

        }

    }

    public void newScene(ActionEvent event) throws IOException {
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 700.0D, 500.0D);
        window.setTitle("Draw Function!");
        window.setScene(scene);
        window.show();
    }
}


