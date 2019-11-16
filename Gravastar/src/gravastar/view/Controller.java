package gravastar.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller extends VBox
{
    public Button domsButton, newButt;
    public TextField commandBar;
    public TextFlow primaryTextFlow;
    public TilePane invTilePane;
    public Rectangle awesomeRect1;

    private Paint redPaint = Paint.valueOf("red");

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
        Text text1 = new Text("> " + commandBar.getText() + "\n");
        text1.setFill(Color.AQUA);
        text1.setFont(Font.font("Verdana", 25));
        primaryTextFlow.getChildren().add(text1);
                //("> " + commandBar.getText() + "\n");
        commandBar.setText("");
    }
}
