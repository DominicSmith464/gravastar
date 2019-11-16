package gravastar.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextFlow;

public class Controller extends VBox
{
    public Button domsButton, newButt;
    public TextField commandBar;
    public TextFlow primaryTextArea;
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
        primaryTextArea.appendText("> " + commandBar.getText() + "\n");
        commandBar.setText("");
    }
}
