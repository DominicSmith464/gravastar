package gravastar.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;

public class Controller extends VBox
{
    public Button domsButton;
    public TextField commandBar;
    public TextArea primaryTextArea;
    public TilePane invTilePane;
    public Rectangle awesomeRect1;

    private boolean isFirstLine = true;
    private Paint bluePaint = Paint.valueOf("0x0000FF");

    public void handleButtonClick()
    {
        domsButton.setText("Hello World");
        Rectangle myRectum = new Rectangle(50, 50, bluePaint);
        invTilePane.getChildren().add(myRectum);
    }

    public void handleCommandEntered()
    {
        addLine(commandBar.getText());
        commandBar.setText("");
    }

    public void addLine(String newText)
    {
        if(isFirstLine)
        {
            primaryTextArea.setText(newText);
            isFirstLine = false;
        }
        else
        {
            primaryTextArea.setText(primaryTextArea.getText() + '\n' + newText);
        }
    }
}
