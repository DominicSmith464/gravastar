package gravastar.items;

public class Gear extends Item
{
    private String prefix= "", suffix = "";

    public Gear(String name,
                String desc,
                Boolean visible,
                ItemType type,
                String prefix,
                String suffix)
    {
        super(name, desc, visible, type);
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public Gear(String name,
                String desc,
                Boolean visible,
                ItemType type)
    {
        super(name, desc, visible, type);
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
