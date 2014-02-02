package com.cwmni.nigelspal;

/**
 * Command Line Interfaces used to run quiz
 */
public final class QuizRunnerCLI
{
    public static void main(String[] args)
    {
        QuizSettings theQuizSettings = new QuizRunnerCLIPasser(args).getQuizSettings();
        new QuizRunner(theQuizSettings).run();
    }
}
