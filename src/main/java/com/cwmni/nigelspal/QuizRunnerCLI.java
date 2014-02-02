package com.cwmni.nigelspal;

/**
 *
 */
public final class QuizRunnerCLI
{
    public static void main(String[] args) throws InterruptedException
    {
        QuizSettings theQuizSettings = new QuizRunnerCLIPasser(args).getQuizSettings();
        new QuizRunner(theQuizSettings).run();
    }
}
