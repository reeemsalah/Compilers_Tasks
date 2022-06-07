package csen1002.main.assignment2;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Assignment2Runner {

    /**
     * Parses a provided string using Task 9's grammar
     * and gets the value of the attribute "check" of the variable "s'
     *
     * @param input a string to parse
     * @return the value of the attribute "check" of the variable "s'
     */
    public static int sCheckValue(String input) {
        Assignment2Lexer lexer = new Assignment2Lexer(CharStreams.fromString(input));
        Assignment2Parser parser = new Assignment2Parser(new CommonTokenStream(lexer));
        return parser.s().check;
    }

    public static void main(String[] args) {

        System.out.println(sCheckValue("(((aa)|(((bb)e)a))|(bb))"));
        System.out.println(sCheckValue("(((aa)a)|((bb)b))"));
        System.out.println(sCheckValue("b"));
    }
}
