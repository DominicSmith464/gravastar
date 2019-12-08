package gravastar.items;

public class Item
{
    private String name;
    private Boolean visible;
    private ItemType type;
    private int id_Number;

    Item(String name, Boolean visible, ItemType type, int id_number)
    {
        this.name = name;
        this.visible = visible;
        this.type = type;
        this.id_Number = id_number;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public int getId_Number() {
        return id_Number;
    }
}
