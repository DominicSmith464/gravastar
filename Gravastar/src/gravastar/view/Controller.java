package gravastar.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Controller extends VBox
{
    public Button domsButton;
    public TextField commandBar;
    public TextArea primaryTextArea;
    public VBox primaryVBox;

    private boolean isFirstLine = true;

    public void handleButtonClick()
    {
        domsButton.setText("Hello World");
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
