package com.cwmni.nigelspal.messages;


import static com.cwmni.nigelspal.messages.QuestionMessage.Operation.ADD;
import static com.cwmni.nigelspal.messages.QuestionMessage.Operation.DIVIDE;
import static com.cwmni.nigelspal.messages.QuestionMessage.Operation.MULTIPLY;
import static com.cwmni.nigelspal.messages.QuestionMessage.Operation.SUBTRACT;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionMessageTest
{

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_Invalid()
    {
        QuestionMessage questionResponce = new QuestionMessage("boom");
    }
    @Test
    public void testIsQuestion()
    {
        assertTrue(QuestionMessage.isOne("Q1. What is 2+2?"));
    }
    
    @Test
    public void testIsQuestion_False()
    {
        assertFalse(QuestionMessage.isOne("Q1 . What is 2+2?"));
    }
    
   
    @Test
    public void testGetQuestionNumber()
    {
        assertEquals(1, new QuestionMessage("Q1. What is 2+2?").getQuestionNumber());
    }

    @Test
    public void testGetQuestionNumber_DiffrentOne()
    {
        assertEquals(56, new QuestionMessage("Q56. What is 2+2?").getQuestionNumber());
    }

    @Test
    public void testGetFirstNumber()
    {
        assertEquals(123, new QuestionMessage("Q10. What is 123+2?").getFirstNumber());
    }

    @Test
    public void testGetFirstNumber_DiffrentOne()
    {
        assertEquals(42, new QuestionMessage("Q10. What is 42+2?").getFirstNumber());
    }

    @Test
    public void testGetSecondNumber()
    {
        assertEquals(298, new QuestionMessage("Q10. What is 123+298?").getSecondNumber());
    }

    @Test
    public void testGetSecondNumber_DiffrentOne()
    {
        assertEquals(9, new QuestionMessage("Q10. What is 123+9").getSecondNumber());
    }

    @Test
    public void testGetOperation_Add()
    {
        assertEquals(ADD, new QuestionMessage("Q10. What is 123+298?").getOperation());
    }

    @Test
    public void testGetOperation_Subtract()
    {
        assertEquals(SUBTRACT, new QuestionMessage("Q10. What is 123-298?").getOperation());
    }

    @Test
    public void testGetOperation_Divide()
    {
        assertEquals(DIVIDE, new QuestionMessage("Q10. What is 123/298?").getOperation());
    }

    @Test
    public void testGetOperation_Multiply()
    {
        assertEquals(MULTIPLY, new QuestionMessage("Q10. What is 123*298?").getOperation());
    }

}