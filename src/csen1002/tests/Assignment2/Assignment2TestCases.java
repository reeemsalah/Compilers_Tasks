package csen1002.tests.Assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import csen1002.main.assignment2.Assignment2Lexer;
import csen1002.main.assignment2.Assignment2Parser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment2TestCases {
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
    @Test
    public void T01(){
        assertEquals(0,sCheckValue("(((aa)|(((bb)e)a))|(bb))"));
    }
    @Test
    public void T02(){
        assertEquals(1,sCheckValue("((aa)|(bb))"));
    } @Test
    public void T03(){
        assertEquals(1,sCheckValue("((bb)|(aa))"));
    } @Test
    public void T04(){
        assertEquals(1,sCheckValue("(((aa)b)|(((ab)b)e))"));
    } @Test
    public void T05(){
        assertEquals(0,sCheckValue("(((aa)|(bb))|e)"));
    } @Test
    public void T06(){
        assertEquals(1,sCheckValue("(p|e)"));
    } @Test
    public void T07(){
        assertEquals(0,sCheckValue("(((aa)|(aa))|(aa))"));
    } @Test
    public void T08(){
        assertEquals(1,sCheckValue("(((aa)*)|((bb)*))"));
    } @Test
    public void T09(){
        assertEquals(0,sCheckValue("(((aa)p)|(bb)|p)"));
    } @Test
    public void T10(){
        assertEquals(1,sCheckValue("(((aa)a)|((bb)b))"));
    }
}
