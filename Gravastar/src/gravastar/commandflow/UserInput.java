package gravastar.commandflow;

public class UserInput {

    private Command userCommand;
    private int itemId;
    private int inputNumber;

    UserInput(int inputNumber)
    {
        this.inputNumber = inputNumber;
    }

    public void setUserCommand(Command c)
    {
        userCommand = c;
    }
    public Command getUserCommand()
    {
        return userCommand;
    }

    public void setItemId(int i) { itemId = i; }
    public int getItemId() { return itemId; }

    public int getInputNumber() {
        return inputNumber;
    }
}
