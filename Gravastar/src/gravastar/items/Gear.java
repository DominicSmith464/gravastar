package gravastar.items;

public class Gear extends Item
{
    private String prefix, suffix;

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

    @Override
    public String toString()
    {
        return this.prefix + " " + super.toString() + " " + this.suffix;
    }
}
