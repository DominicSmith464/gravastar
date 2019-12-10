package gravastar.items;

public class Gear extends Item
{
    private String prefix= "", suffix = "";

    public Gear(String name,
                Boolean visible,
                ItemType type,
                int id_number,
                String prefix,
                String suffix)
    {
        super(name, visible, type, id_number);
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public Gear(String name,
                Boolean visible,
                ItemType type,
                int id_number)
    {
        super(name, visible, type, id_number);
    }

    private static final String[] PREFIX_TITLES = new String[] {
            "Lord",
            "Sir",
            "King",
            "Queen",
            "Mr."
    };

    private static final String[] PREFIX_NAMES = new String[] {
            "Smith",
            "Fishskin",
            "Price",
            "Michael"
    };

    public static String createPrefix()
    {
        return PREFIX_TITLES[(int)(Math.random() * PREFIX_TITLES.length)] +
                " " +
                PREFIX_NAMES[(int)(Math.random() * PREFIX_NAMES.length)] +
                "'s";
    }

    public static String createSuffix()
    {
        return "of terror";
    }

    @Override
    public String toString()
    {
        if(this.prefix.equals("") && this.suffix.equals(""))
        {
            return super.toString();
        }
        else
        {
            return this.prefix + " " + super.toString() + " " + this.suffix;
        }
    }
}
