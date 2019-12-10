package gravastar.commandflow;

import gravastar.characters.Player;
import gravastar.helpers.WordParsing;
import gravastar.items.Gear;
import gravastar.items.ItemType;
import gravastar.rooms.Map;
import gravastar.rooms.Room;
import gravastar.view.Controller;

public class Commands
{
    private static Controller window;
    private static Map map;
    private static String input;



    public static void selector(Command commandC)
    {
        switch(commandC)
        {
            case invalid:
                break;

            case travel:
                travel();
                break;

            case inspect:
                break;

            case look:
                look();
                break;

            case clear:
                clearHome();
                break;

            case info:
                info();
                break;

            case sword:
                Gear mySword = new Gear("sword", true, ItemType.sword, 1);
                window.normalPrintln(mySword.toString());
                break;

            default:
                //TODO: Bad command
                break;
        }
    }

    public static void clearHome()
    {
        Commands.window.clearTextFlow();
        Commands.window.normalPrintln("Cleared all text.");
    }

    public static void info()
    {
        Commands.window.normalPrintln(
                "Your name is " +
                        Player.getName() +
                        ".");
    }

    public static void look()
    {
        Room room = map.getRooms().get(Player.getRoomId());

        Commands.window.normalPrintln(room.getName());
        Commands.window.normalPrintln(room.getDesc());
    }

    public static void travel()
    {
        if(WordParsing.splitIntoWords(input).get(0).equals("e"))
        {
            Player.setRoomId(Player.getRoomId() + 1);
        }
        else if(WordParsing.splitIntoWords(input).get(0).equals("w"))
        {
            Player.setRoomId(Player.getRoomId() - 1);
        }

        look();
    }

    public static void setWindow(Controller window)
    {
        Commands.window = window;
    }

    public static void setMap(Map map) {
        Commands.map = map;
    }

    public static void setInput(String input) {
        Commands.input = input;
    }
}
