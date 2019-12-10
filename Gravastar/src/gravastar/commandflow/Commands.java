package gravastar.commandflow;

import gravastar.characters.Player;
import gravastar.view.Controller;

public class Commands
{
    private static Controller window;

    public static void setWindow(Controller window)
    {
        Commands.window = window;
    }

    public static void selector(Command commandC)
    {
        switch(commandC)
        {
            case invalid:
                break;

            case travel:
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
        Commands.window.normalPrintln("You are in ----- room.");
    }
}
