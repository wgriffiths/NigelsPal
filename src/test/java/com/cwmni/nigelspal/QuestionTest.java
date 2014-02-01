package com.cwmni.nigelspal;

import static com.cwmni.nigelspal.Question.Operation.DIVIDE;
import static com.cwmni.nigelspal.Question.Operation.SUBTRACT;
import static com.cwmni.nigelspal.Question.Operation.ADD;
import static com.cwmni.nigelspal.Question.Operation.MULTIPLY;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionTest
{

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_Invalid()
    {
        Question questionResponce = new Question("boom");
    }
    
    @Test
    public void testGetQuestionNumber()
    {
        assertEquals(1, new Question("Q1. What is 2+2?").getQuestionNumber());
    }

    @Test
    public void testGetQuestionNumber_DiffrentOne()
    {
        assertEquals(56, new Question("Q56. What is 2+2?").getQuestionNumber());
    }

    @Test
    public void testGetFirstNumber()
    {
        assertEquals(123, new Question("Q10. What is 123+2?").getFirstNumber());
    }

    @Test
    public void testGetFirstNumber_DiffrentOne()
    {
        assertEquals(42, new Question("Q10. What is 42+2?").getFirstNumber());
    }

    @Test
    public void testGetSecondNumber()
    {
        assertEquals(298, new Question("Q10. What is 123+298?").getSecondNumber());
    }

    @Test
    public void testGetSecondNumber_DiffrentOne()
    {
        assertEquals(9, new Question("Q10. What is 123+9").getSecondNumber());
    }

    @Test
    public void testGetOperation_Add()
    {
        assertEquals(ADD, new Question("Q10. What is 123+298?").getOperation());
    }

    @Test
    public void testGetOperation_Subtract()
    {
        assertEquals(SUBTRACT, new Question("Q10. What is 123-298?").getOperation());
    }

    @Test
    public void testGetOperation_Divide()
    {
        assertEquals(DIVIDE, new Question("Q10. What is 123/298?").getOperation());
    }

    @Test
    public void testGetOperation_Multiply()
    {
        assertEquals(MULTIPLY, new Question("Q10. What is 123*298?").getOperation());
    }

}
