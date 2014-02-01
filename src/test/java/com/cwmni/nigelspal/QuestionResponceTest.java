package com.cwmni.nigelspal;

import static com.cwmni.nigelspal.QuestionResponce.Operator.DIVIDE;
import static com.cwmni.nigelspal.QuestionResponce.Operator.SUBTRACT;
import static com.cwmni.nigelspal.QuestionResponce.Operator.ADD;
import static com.cwmni.nigelspal.QuestionResponce.Operator.MULTIPLY;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionResponceTest
{

    @Test
    public void testGetQuestionNumber()
    {
        assertEquals(1, new QuestionResponce("Q1. What is 2+2?").getQuestionNumber());
    }

    @Test
    public void testGetQuestionNumber_DiffrentOne()
    {
        assertEquals(56, new QuestionResponce("Q56. What is 2+2?").getQuestionNumber());
    }

    @Test
    public void testGetFirstNumber()
    {
        assertEquals(123, new QuestionResponce("Q10. What is 123+2?").getFirstNumber());
    }
    
    @Test
    public void testGetFirstNumber_DiffrentOne()
    {
        assertEquals(42, new QuestionResponce("Q10. What is 42+2?").getFirstNumber());
    }

    @Test
    public void testGetSecondNumber()
    {
        assertEquals(298, new QuestionResponce("Q10. What is 123+298?").getSecondNumber());
    }
    
    @Test
    public void testGetSecondNumber_DiffrentOne()
    {
        assertEquals(9, new QuestionResponce("Q10. What is 123+9").getSecondNumber());
    }

    @Test
    public void testGetOperand_Add()
    {
        assertEquals(ADD, new QuestionResponce("Q10. What is 123+298?").getOperator());
    }
    
    @Test
    public void testGetOperand_Subtract()
    {
        assertEquals(SUBTRACT, new QuestionResponce("Q10. What is 123-298?").getOperator());
    }
    
    @Test
    public void testGetOperand_Divide()
    {
        assertEquals(DIVIDE, new QuestionResponce("Q10. What is 123/298?").getOperator());
    }

    
     @Test
    public void testGetOperand_Multiply()
    {
        assertEquals(MULTIPLY, new QuestionResponce("Q10. What is 123*298?").getOperator());
    }

}
