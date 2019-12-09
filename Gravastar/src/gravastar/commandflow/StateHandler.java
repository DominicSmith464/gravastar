package gravastar.commandflow;

import gravastar.characters.Player;
import gravastar.helpers.WordParsing;
import gravastar.view.Controller;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class StateHandler {

    private static ArrayList<String> wordList = new ArrayList<>();
    private static ArrayList<UserInput> inputHistory = new ArrayList<>();
    private static Query queryType;
    private static Gamestate state;
    private static int inputNumber = 0;

    public static void updateState(String input, Controller window)
    {
        switch (state)
        {
            case initialize:
                window.normalPrintln(
                        "Welcome to Gravastar! \n" +
                                "Hope you find your way...\n" +
                                "\n" +
                                "What is your name?");
                queryType = Query.textResponse;
                break;

            case normal:
                window.normalPrintln("You are in the cafeteria.\n");
                queryType = Query.standard;
                break;
        }

        switch (queryType)
        {
            case standard:
                parseInput(input);
                break;

            case textResponse:
                //TODO: text only
                break;

            case itemElaboration:
                //TODO: name an item
                break;

            default:
                parseInput(input);
                break;
        }

        switch (state)
        {
            case initialize:
                Player.setName();
                break;

            default:
                //TODO: Send the command through the ringer
                break;
        }

        /*

                String userCommandString;
                userCommandString = inputHistory.get(inputNumber - 1).getUserCommand().toString();

                window.colorPrintln(
                        new String[] {
                            "You just did the ",
                            userCommandString,
                            " command."},
                        new Paint[] {
                            Color.WHITE,
                            Color.RED,
                            Color.WHITE});

                window.colorPrintln(
                        new String[] {
                                "I think you said ",
                                wordList.get(0)},
                        new Paint[] {
                                Color.WHITE,
                                Color.BLUE});

                window.normalPrintln("");

        */
    }

    /* This is the most basic input parser. It takes the text
     * that the user entered and converts it to a UserInput
     * object. This method is used when the player is expected
     * to provide a verb and an item.
     * TODO: If the command called does not require an item, the item part is skipped.
     */
    private static void parseInput(String input)
    {
        /* A UserInput is a condensed form of the text
         that the player puts into the entry bar.*/
        UserInput userInputU = new UserInput(inputNumber);
        Command commandC = Command.invalid;

        //Adds the UserInput to the history list
        inputHistory.add(userInputU);

        //Increment the entry number for user inputs
        inputNumber++;

        /* Takes a string and turns it into a list of useful words.
        *  It also sanitizes the input, trimming spaces and making
        * everything lowercase. */
        wordList = WordParsing.filterInput(WordParsing.splitIntoWords(input.toLowerCase().trim()));

        //Send the first two words first to check for two word commands
        if(wordList.size() > 1)
        {
            commandC = WordParsing.stringToCommand(wordList.get(0) + " " + wordList.get(1));
        }

        //Command was not two words long, check for a one word command
        if(commandC == Command.invalid)
        {
            commandC = WordParsing.stringToCommand(wordList.get(0));
        }

        //Set the command for the UserInput
        userInputU.setUserCommand(commandC);

        //find item

        //Set the itemID for the UserInput
        userInputU.setItemId(1);
    }

}
