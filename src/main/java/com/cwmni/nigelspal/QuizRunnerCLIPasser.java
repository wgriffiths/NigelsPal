package com.cwmni.nigelspal;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Class used to parse command line arguments and create into quiz settings.
 */
class QuizRunnerCLIPasser
{

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final String NUMBER_OF_QUESTIONS = "questions";
    private final QuizSettings myQuizSettings;
    private final Options myOptions;

    /**
     * 
     * @param args - Command line arguments used. 
     */
    public QuizRunnerCLIPasser(String[] args)
    {
        myOptions = createOptions();

        CommandLine command = parseArguments(args);
        Username theUsername = new Username(command.getOptionValue(USERNAME));
        Password thePassword = new Password(command.getOptionValue(PASSWORD));
        String theNumber = command.getOptionValue(NUMBER_OF_QUESTIONS);
        NumberOfQuestions theNumberOfQuestions = new NumberOfQuestions(Integer.parseInt(theNumber));

        myQuizSettings = new QuizSettings(theUsername, thePassword, theNumberOfQuestions);

    }

    /**
     * @return Path to repository
     */
    public QuizSettings getQuizSettings()
    {
        return myQuizSettings;
    }

    private CommandLine parseArguments(String[] args)
    {
        try
        {
            return new BasicParser().parse(myOptions, args);
        } catch (ParseException ex)
        {
            String errorMessage = buildParseErrorMessage(ex.getMessage());
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private Options createOptions() throws IllegalArgumentException
    {
        Option theUserNameOption = new Option(USERNAME, true, "full username used to login");
        theUserNameOption.setRequired(true);
        theUserNameOption.setArgName("me@google.com");

        Option thePasswordOption = new Option(PASSWORD, true, "password used to login");
        thePasswordOption.setRequired(true);
        thePasswordOption.setArgName("password123");

        Option theQuestionsOption = new Option(NUMBER_OF_QUESTIONS, true, "number of questions required.");
        theQuestionsOption.setRequired(true);
        theQuestionsOption.setArgName("10");

        Options theOptions = new Options();
        theOptions.addOption(theUserNameOption);
        theOptions.addOption(thePasswordOption);
        theOptions.addOption(theQuestionsOption);

        return theOptions;
    }

    private String buildParseErrorMessage(String exceptionMessage)
    {
        int helpMessageWidth = 80;
        StringWriter stringWriter = new StringWriter();
        try (PrintWriter printWriter = new PrintWriter(stringWriter))
        {
            printWriter.write(exceptionMessage);
            printWriter.write(" ");
            new HelpFormatter().printUsage(printWriter, helpMessageWidth, "", myOptions);
            printWriter.close();
        }

        return stringWriter.toString();
    }
}
