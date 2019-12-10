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
        rooms.add(room);
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
