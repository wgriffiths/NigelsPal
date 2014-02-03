

package com.cwmni.nigelspal;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)   
@PrepareForTest(
{
  QuizRunnerCLI.class,QuizSettings.class,QuizRunnerCLIPasser.class,QuizRunner.class
})
public class QuizRunnerCLITest {

    private static final String[] ARGS = new String[]{"boom","bang"};
    private static QuizRunner myQuizRunner;
    
    @BeforeClass
    public static void setupClass() throws Exception{
        QuizSettings thSettings = PowerMockito.mock(QuizSettings.class);
        
        QuizRunnerCLIPasser theParser = PowerMockito.mock(QuizRunnerCLIPasser.class);
        PowerMockito.whenNew(QuizRunnerCLIPasser.class).withArguments(ARGS).thenReturn(theParser);
        Mockito.when(theParser.getQuizSettings()).thenReturn(thSettings);
        
        myQuizRunner = PowerMockito.mock(QuizRunner.class);
        PowerMockito.whenNew(QuizRunner.class).withArguments(thSettings).thenReturn(myQuizRunner);
    }
    
    
    @Test
    public void testMain() throws Exception
    {
        QuizRunnerCLI.main(ARGS);
        Mockito.verify(myQuizRunner).run();
    }


}