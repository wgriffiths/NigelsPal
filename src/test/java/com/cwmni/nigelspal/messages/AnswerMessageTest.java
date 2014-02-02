package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)   
@PrepareForTest(
{
  QuestionMessage.class
})
public class AnswerMessageTest
{
    private QuestionMessage myQuestion;

    @Before
    public void setup()
    {
        myQuestion = PowerMockito.mock(QuestionMessage.class);
        Mockito.when(myQuestion.getQuestionNumber()).thenReturn(1);
        Mockito.when(myQuestion.getFirstNumber()).thenReturn(1);
        Mockito.when(myQuestion.getOperation()).thenReturn("+");
        Mockito.when(myQuestion.getSecondNumber()).thenReturn(2);
    }

    @Test
    public void testGetMessage_Add()
    {
        assertEquals("A1. 3", new AnswerMessage(myQuestion).getMessage());
    }
    
     @Test
    public void testGetMessage_Divide()
    {
        Mockito.when(myQuestion.getFirstNumber()).thenReturn(100);
        Mockito.when(myQuestion.getOperation()).thenReturn("/");
        Mockito.when(myQuestion.getSecondNumber()).thenReturn(20);

        assertEquals("A1. 5", new AnswerMessage(myQuestion).getMessage());
    }
    
     @Test
    public void testGetMessage_Multiply()
    {
        Mockito.when(myQuestion.getFirstNumber()).thenReturn(141085841);
        Mockito.when(myQuestion.getOperation()).thenReturn("*");
        Mockito.when(myQuestion.getSecondNumber()).thenReturn(1913237513);
                
        assertEquals("A1. 269930723554353433", new AnswerMessage(myQuestion).getMessage());
    }
    
     @Test
    public void testGetMessage_Subtract()
    {
        Mockito.when(myQuestion.getFirstNumber()).thenReturn(5);
        Mockito.when(myQuestion.getOperation()).thenReturn("-");
        Mockito.when(myQuestion.getSecondNumber()).thenReturn(10);
                
        assertEquals("A1. -5", new AnswerMessage(myQuestion).getMessage());
    }

    @Test
    public void testGetMessage_DiffrentQuestion()
    {
        Mockito.when(myQuestion.getQuestionNumber()).thenReturn(42);

        assertEquals("A42. 3", new AnswerMessage(myQuestion).getMessage());
    }

  
    @Test
    public void testGetMessage_ThreeDecimalPlaces()
    {
        Mockito.when(myQuestion.getFirstNumber()).thenReturn(1);
        Mockito.when(myQuestion.getOperation()).thenReturn("/");
        Mockito.when(myQuestion.getSecondNumber()).thenReturn(3);

        assertEquals("A1. 0.333", new AnswerMessage(myQuestion).getMessage());
    }

 
    @Test
    public void testGetMessage_HalfEven()
    {
        Mockito.when(myQuestion.getFirstNumber()).thenReturn(101335);
        Mockito.when(myQuestion.getOperation()).thenReturn("/");
        Mockito.when(myQuestion.getSecondNumber()).thenReturn(10000);

        assertEquals("A1. 10.134", new AnswerMessage(myQuestion).getMessage());
    }
     
   

}
