package gravastar.commandflow;

public enum Command {
    invalid("invalid"),
    travel("Travel"),
    inspect("Inspect"),
    look("Look");

    private String text;

    //Text can be replaced with toString
    //.values() returns a list
    //.valueOf()
    //.ordinal()
    Command(String text)
    {
        this.text = text;
    }
}

