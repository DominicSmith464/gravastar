package gravastar.commandflow;

public enum Command {
    invalid(new String[] {"invalid"}),
    travel(new String[] {"n","e","s","w"}),
    inspect(new String[] {"inspect", "look at"}),
    look(new String[] {"look"});

    private String[] aliases;

    //Text can be replaced with toString
    //.values() returns a list
    //.valueOf()
    //.ordinal()
    Command(String[] aliases)
    {
        this.aliases = aliases;
    }

    public int numAliases()
    {
        return this.aliases.length;
    }

    public String[] getAliases()
    {
        return this.aliases;
    }
}

