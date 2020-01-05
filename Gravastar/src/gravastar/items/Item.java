package gravastar.items;

import gravastar.rooms.Direction;

public class Item
{
    private String name, desc;
    private Boolean isVisible;
    private ItemType type;
    private int id_Number;

    private static int newId = 0;

    Item(String name, String desc, boolean isVisible, ItemType type)
    {
        this.name = name;
        this.desc = desc;
        this.isVisible = isVisible;
        this.type = type;
        this.id_Number = Item.getNextNewId();
    }

    public static int getNextNewId()
    {
        int returnId = newId;
        newId++;
        return returnId;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public int getId_Number() {
        return id_Number;
    }

    public boolean isDoor()
    {
        return false;
    }

    public boolean isAnchored()
    {
        return false;
    }

    public Direction getDoorDirection() { return null; }

    public int getExitRoomId()
    {
        return -1;
    }
}
