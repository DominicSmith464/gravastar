package gravastar.rooms;

import java.util.ArrayList;

public class Map
{
    private ArrayList<Room> rooms = new ArrayList<>();
    private int nextRoomId = 0;

    public void generateRoom()
    {
        Room room = new Room(this.nextRoomId, Room.generateName(), "description", "short description");
        this.nextRoomId++;
        //room.addDoor(Direction.north, this.nextRoomId);
        rooms.add(room);
    }

    public static void generateMap(Map map)
    {
        map.getRooms().get(0).addDoor(Direction.east, map.getRooms().get(1).getRoomId());
        map.getRooms().get(1).addDoor(Direction.west, map.getRooms().get(0).getRoomId());
    }

    public ArrayList<Room> getRooms()
    {
        return this.rooms;
    }

    public Room getRoom(int roomId)
    {
        return this.rooms.get(roomId);
    }

}
