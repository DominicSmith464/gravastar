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
import gravastar.commandflow.*;


public class Controller extends VBox
{
    public Button domsButton, newButt;
    public TextField commandBar;
    public TextFlow primaryTextFlow;
    public TilePane invTilePane;
    public Rectangle awesomeRect1;
    public ScrollPane primaryScrollPane;

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

    //Handles commands entered in the text printing context
    public void handleCommandEntered()
    {
        String input = commandBar.getText().trim();
        Text t = new Text("> " + input + "\n");
        t.setFill(Color.YELLOWGREEN);

        t.setFont(Font.font("Eras Medium ITC", 25));
        primaryTextFlow.getChildren().add(t);

        commandBar.setText("");

        StateHandler.updateState(input);

        //Scrolls to the bottom
        primaryTextFlow.heightProperty().addListener(observable -> primaryScrollPane.setVvalue(1.0));

    }

    public void initialize()
    {
        Commands.setWindow(this);
        StateHandler.setWindow(this);
        StateHandler.updateState("");
    }

    public void normalPrintln(String myText)
    {
        Text t = new Text(myText);
        t.setFill(Color.WHITE);
        t.setFont(Font.font("Eras Medium ITC", 25));
        t.setText(t.getText() + "\n");

        primaryTextFlow.getChildren().add(t);
    }

    public void colorPrintln(String[] phraseList, Paint[] colors)
    {
        Text[] texts = new Text[phraseList.length];

        for(int i = 0; i < phraseList.length; i++)
        {
            texts[i] = new Text(phraseList[i]);
            texts[i].setFill(colors[i]);
            texts[i].setFont(Font.font("Eras Medium ITC", 25));
            primaryTextFlow.getChildren().add(texts[i]);
        }

        normalPrintln("");
    }

    public void clearTextFlow()
    {
        primaryTextFlow.getChildren().clear();
    }
}
