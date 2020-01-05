package gravastar.rooms;

public enum Direction
{
    north,
    south,
    east,
    west,
    up,
    down,
    northeast,
    northwest,
    southeast,
    southwest,
    ;

    public static Direction getDirection(String input)
    {
        for(Direction direction : Direction.values())
        {
            if(input.equals(direction.toString()))
            {
                return direction;
            }
        }
        return null;
    }
}
