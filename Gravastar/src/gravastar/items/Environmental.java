package gravastar.items;

public class Environmental extends Item
{

    Environmental(String name, String desc, boolean isVisible, ItemType type) {
        super(name, desc, isVisible, type);
    }

    @Override
    public boolean isAnchored()
    {
        return true;
    }
}
