package gravastar.helpers;


import java.util.ArrayList;
import java.util.Arrays;
import gravastar.commandflow.Command;

public class WordParsing
{
    public static ArrayList<String> splitIntoWords(String phrase)
    {
        ArrayList<String> words = new ArrayList<String>();
        StringBuilder word = new StringBuilder(30);

        for(int i = 0; i < phrase.length(); i++)
        {
            if(phrase.charAt(i) != ' ')
            {
                //If you are at the last word
                if(i == phrase.length() - 1)
                {
                    words.add(word.toString());
                }
                //If you are not finished with a word
                else
                {
                    word.append(phrase.charAt(i));
                }
            }
            //If the word is finished
            else
            {
                words.add(word.toString());
                word.delete(0, word.length());
            }
        }

        return words;
    }

    public static ArrayList<String> filterInput(ArrayList<String> words)
    {
        ArrayList<String> filterWords = new ArrayList<String>();

        for (String word : words) {
            if (!(Arrays.asList("the", "a", "an", "that").contains(word))) {
                filterWords.add(word);
            }
        }

        return filterWords;
    }

    public static Command stringToCommand(String s)
    {
        for(Command c : Command.values())
        {
            if(s.equals(c.toString()))
            {
                return c;
            }
        }

        return Command.invalid;
    }
}
