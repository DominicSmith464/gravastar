package gravastar.commandflow;

import gravastar.helpers.WordParsing;
import gravastar.view.Controller;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class StateHandler {

    private static int inputNumber = 0;
    private static ArrayList<String> wordList = new ArrayList<String>();
    private static ArrayList<UserInput> inputs = new ArrayList<UserInput>();

    public static void updateState(String input, Controller window)
    {
        parseInput(input);

        if(inputs.get(inputNumber - 1).getUserCommand() == Command.clear)
        {
            window.clearTextFlow();
        }

        window.colorPrintln(new String[] {"You just did the ",
                inputs.get(inputNumber - 1).getUserCommand().toString(),
                " command."},
                new Paint[] {Color.WHITE,
                        Color.RED,
                        Color.WHITE});

        window.colorPrintln(new String[] {"I think you said ", wordList.get(0)}, new Paint[] {Color.WHITE, Color.BLUE});

        window.normalPrintln("");
    }

    private static void parseInput(String input)
    {
        UserInput u = new UserInput(inputNumber);
        Command c = Command.invalid;

        inputNumber++;

        wordList = WordParsing.filterInput(WordParsing.splitIntoWords(input));

        //Send the first two words first
        if(wordList.size() > 1)
        {
            c = WordParsing.stringToCommand(wordList.get(0) + " " + wordList.get(1));
        }

        //Command was not two words long
        if(c == Command.invalid)
        {
            c = WordParsing.stringToCommand(wordList.get(0));
        }

        u.setUserCommand(c);

        //find item
        u.setItemId(1);

        inputs.add(u);
    }

}
