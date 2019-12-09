package gravastar.characters;

public class Player
{
    private static int roomId;
    private static String name;


    public static int getRoomId() {
        return roomId;
    }

    public static void setRoomId(int roomId) {
        Player.roomId = roomId;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Player.name = name;
    }
}
