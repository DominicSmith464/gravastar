package gravastar.commandflow;

import gravastar.helpers.WordParsing;
import gravastar.view.Controller;

import java.util.ArrayList;

public class StateHandler {

    private static int inputNumber = 0;
    private static ArrayList<String> wordList = new ArrayList<String>();
    private static ArrayList<UserInput> inputs = new ArrayList<UserInput>();

    public static void updateState(String input, Controller window)
    {
        parseInput(input);
        window.normalPrintln("You just did the " +
                inputs.get(inputNumber - 1).getUserCommand().toString() +
                " command.");
    }

    private static void parseInput(String input)
    {
        UserInput u = new UserInput(inputNumber);
        inputNumber++;

        wordList = WordParsing.filterInput(WordParsing.splitIntoWords(input));

        //find command
        u.setUserCommand(WordParsing.stringToCommand(wordList.get(0)));

        //find item
        u.setItemId(1);

        inputs.add(u);
    }

}
