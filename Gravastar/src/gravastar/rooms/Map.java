package gravastar.rooms;

import java.util.ArrayList;

public class Map
{
    private ArrayList<Room> rooms = new ArrayList<>();
    private int nextRoomId = 0;

    public void generateRoom()
    {
        Room room = new Room(this.nextRoomId, Room.generateName(),
                "--",
                "short description");
        this.nextRoomId++;
        //room.addDoor(Direction.north, this.nextRoomId);
        rooms.add(room);
    }

    public static void generateMap(Map map)
    {
        Direction lastDir;
        for(int i = 0; i < map.getRooms().size() - 1; i++)
        {
            lastDir = map.getRooms().get(i).addRandomDoor(map.getRooms().get(i + 1).getRoomId());
            map.getRooms().get(i + 1).addDoor(lastDir.getOpposite(), map.getRooms().get(i).getRoomId());
        }

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
