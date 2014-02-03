package com.cwmni.nigelspal;

/**
 * Command Line Interfaces used to run quiz
 */
public final class QuizRunnerCLI
{
    /**
     * Run Quiz 
     * @param args - required arguments -user <me@google.com> -password <password123> -questions <10> 
     */
    public static void main(String[] args)
    {
        QuizSettings theQuizSettings = new QuizRunnerCLIPasser(args).getQuizSettings();
        new QuizRunner(theQuizSettings).run();
    }
}
