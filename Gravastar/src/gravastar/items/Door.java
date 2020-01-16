package gravastar.items;

import gravastar.rooms.Direction;

public class Door extends Environmental
{
    private Direction doorDirection;
    private boolean locked;
    private int exitRoomId;

    public Door(String name, String desc, boolean visible, Direction doorDirection, boolean locked, int exitRoomId) {
        super(name, desc, visible, ItemType.door);
        this.doorDirection = doorDirection;
        this.locked = locked;
        this.exitRoomId = exitRoomId;
    }

    public String toString()
    {
        return this.doorDirection.toString();
    }

    @Override
    public boolean isDoor()
    {
        return true;
    }

    @Override
    public Direction getDoorDirection()
    {
        return doorDirection;
    }

    @Override
    public int getExitRoomId()
    {
        return exitRoomId;
    }

    public boolean isLocked()
    {
        return locked;
    }

    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }


}
