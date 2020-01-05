package gravastar.rooms;

import gravastar.items.Door;
import gravastar.items.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Room
{
    private static final String[] ROOM_NAMES = new String[]
    {
            "Cafeteria",
            "Gym",
            "Hallway",
            "Snowy Courtyard",
            "Dorm Room",
            "Kennedy Hall Lobby",
            "Room 324"
    };

    //Rooms are taken when true
    private static boolean[] takenRooms = new boolean[ROOM_NAMES.length];

    private int roomId;
    private String name, desc, shortDesc;
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Door> roomDoors = new ArrayList<>();

    //Adds all directions to an ArrayList
    ArrayList<Direction> validDirections = new ArrayList<>(Arrays.asList(Direction.values()));

    public Room(int roomId,
                String name,
                String desc,
                String shortDesc)
    {
        this.roomId = roomId;
        this.name = name;
        this.desc = desc;
        this.shortDesc = shortDesc;
    }

    public int getRoomId()
    {
        return roomId;
    }

    public ArrayList<Item> getRoomItems()
    {
        return this.roomItems;
    }

    public ArrayList<Door> getRoomDoors() { return this.roomDoors; }

    public void addItem(Item item)
    {
        this.roomItems.add(item);
    }

    public void addDoor(Direction doorDirection, int exitId)
    {
        //Todo make a dynamic description based on the room it goes to maybe
        Door door = new Door(
                "--no name--",
                "--room desc--",
                true,
                doorDirection,
                false,
                exitId
                );
        this.roomItems.add(door);
        this.roomDoors.add(door);
    }

    public void addRandomDoor(int exitId)
    {
        int random = (int)(Math.random() * this.validDirections.size());
        this.addDoor(this.validDirections.remove(random), exitId);
    }

    public static String generateName()
    {
        int selectedIndex;
        ArrayList<String> remainingNames = new ArrayList<>();

        for(int i = 0; i < takenRooms.length; i++)
        {
            if(!takenRooms[i])
            {
                remainingNames.add(ROOM_NAMES[i]);
            }
        }

        if(remainingNames.size() == 0)
        {
            return "No rooms remaining";
        }

        selectedIndex = (int)(Math.random() * remainingNames.size());

        for(int i = 0; i < ROOM_NAMES.length; i++)
        {
            if(ROOM_NAMES[i].equals(remainingNames.get(selectedIndex)))
            {
                takenRooms[i] = true;
                return remainingNames.get(selectedIndex);
            }
        }

        return "Somehow we got this far";
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getShortDesc() {
        return shortDesc;
    }
}
