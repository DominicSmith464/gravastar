package gravastar.commandflow;

import gravastar.characters.Player;
import gravastar.helpers.WordParsing;
import gravastar.items.Door;
import gravastar.items.Gear;
import gravastar.items.Item;
import gravastar.items.ItemType;
import gravastar.rooms.Direction;
import gravastar.rooms.Map;
import gravastar.rooms.Room;
import gravastar.view.Controller;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Commands
{
    private static Controller window;
    private static Map map;
    private static ArrayList<String> input;



    public static void selector(Command commandC)
    {
        switch(commandC)
        {
            case invalid:
                window.colorPrintln(new String[]{input.get(0), " is not a valid verb."}, new Paint[]{Color.RED, Color.WHITE});
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
                Gear mySword = new Gear("sword", "It's a sword", true, ItemType.sword);
                window.normalPrintln(mySword.toString());
                break;

            default:
                //TODO: Bad command
                break;
        }
    }

    private static void clearHome()
    {
        Commands.window.clearTextFlow();
        Commands.window.normalPrintln("Cleared all text.");
    }

    private static void info()
    {
        Commands.window.normalPrintln(
                "Your name is " +
                        Player.getName() +
                        ".");
    }

    private static void look()
    {
        Room room = map.getRooms().get(Player.getRoomId());

        //Commands.window.normalPrintln(room.getName());
        Commands.window.normalPrintln(room.getDesc());
    }

    private static void travel()
    {
        Direction direction = Direction.getDirection(input.get(0));

        for(Item door : map.getRoom(Player.getRoomId()).getRoomItems())
        {
            if(door.isDoor())
            {
                if(door.getDoorDirection() == direction)
                {
                    Player.setRoomId(door.getExitRoomId());
                    window.setRoomLabel(map.getRooms().get(Player.getRoomId()).getName());
                }
                else
                {
                    Commands.window.normalPrintln("There is not a door there.");
                }
            }
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

    public static void setInput(ArrayList<String> input) {
        Commands.input = input;
    }
}
