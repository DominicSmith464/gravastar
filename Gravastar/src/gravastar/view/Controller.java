package gravastar.view;


import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;


public class Controller extends VBox
{
    public Button domsButton, newButt;
    public TextField commandBar;
    public TextFlow primaryTextFlow;
    public TilePane invTilePane;
    public Rectangle awesomeRect1;
    public ScrollPane primaryScrollPane;

    private Paint redPaint = Paint.valueOf("red");
    private boolean isRed = false;

    public void handleButtonClick()
    {
        domsButton.setText("Hello World");
        //awesomeRect1 = new Rectangle(50, 50, bluePaint);
        newButt = new Button("Hi");
        invTilePane.getChildren().add(/*awesomeRect1*/newButt);
        //newButt.addEventHandler();
    }

    public void handleRectClicked()
    {
        awesomeRect1.setFill(redPaint);
    }

    public void handleCommandEntered()
    {
        Text t = new Text("> " + commandBar.getText() + "\n");

        if(isRed)
        {
            t.setFill(Color.RED);
            isRed = false;
        }
        else
        {
            t.setFill(Color.AQUA);
            isRed = true;
        }

        t.setFont(Font.font("Harlow Solid Italic", 25));
        primaryTextFlow.getChildren().add(t);

        commandBar.setText("");
        primaryScrollPane.setVvalue(primaryScrollPane.getVmax());
    }
}
