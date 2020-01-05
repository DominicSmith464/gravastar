package gravastar.commandflow;

import gravastar.characters.Player;
import gravastar.helpers.WordParsing;
import gravastar.rooms.Map;
import gravastar.view.Controller;

import java.util.ArrayList;

public class StateHandler {

    private static ArrayList<String> wordList = new ArrayList<>();
    private static ArrayList<UserInput> inputHistory = new ArrayList<>();
    private static Controller window;
    private static Query queryType;
    private static Gamestate state = Gamestate.initialize;
    private static int inputNumber = 0;

    private final static int NUM_ROOMS = 7;
    private static Map gameMap;

    public static void updateState(String input)
    {
        //Prepare for input
        switch (state)
        {
            case initialize:
                window.normalPrintln(
                        "Welcome to Gravastar! \n" +
                                "Hope you find your way...\n" +
                                "\n" +
                                "What is your name?\n");
                queryType = Query.noResponse;
                break;

            case normal:
                //Todo: Text that happens before the entry?
                queryType = Query.standard;
                break;

            default:
                queryType = Query.textResponse;
                break;
        }

        //Handle input
        switch (queryType)
        {
            case standard:
                parseInput(input);
                Commands.setInput(wordList);
                break;

            case textResponse:
                wordList.add(input);
                Commands.setInput(wordList);
                break;

            case itemElaboration:
                //TODO: name an item
                break;

            case noResponse:
                //Do nothing
                break;

            default:
                //Not sure what to do here
                break;
        }

        //Commit action
        switch (state)
        {
            case initialize:
                generateRandomMap();
                Player.setRoomId(0);
                window.setRoomLabel(gameMap.getRooms().get(Player.getRoomId()).getName());

                state = Gamestate.giveName;
                break;

            case normal:
                Commands.selector(inputHistory.get(inputNumber - 1).getUserCommand());
                window.normalPrintln("");
                break;

            case giveName:
                Player.setName(input);
                window.normalPrintln("Good luck, " + Player.getName() + ".");
                window.normalPrintln("You wake up covered in opened ketchup packets.\n");
                state = Gamestate.normal;
                break;

            default:
                //What here?
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

    private static void generateRandomMap()
    {
        gameMap = new Map();
        Commands.setMap(gameMap);

        for(int i = 0; i < NUM_ROOMS; i++)
        {
            gameMap.generateRoom();
        }
        Map.generateMap(gameMap);
    }

    public static void setWindow(Controller window)
    {
        StateHandler.window = window;
    }

}
