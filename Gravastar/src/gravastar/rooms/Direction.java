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

    public Direction getOpposite()
    {
        switch(this)
        {
            case north:
                return south;

            case south:
                return north;

            case east:
                return west;

            case west:
                return east;

            case northeast:
                return southwest;

            case southwest:
                return northeast;

            case northwest:
                return southeast;

            case southeast:
                return northwest;

            case up:
                return down;

            case down:
                return up;

            default:
                return north;
        }
    }
}
