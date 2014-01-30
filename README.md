# A XMPP bot that talks to Nigel the quiz bot

## Commands
Command supported by Nigel.

### Help
A message in the form **'help'** will return a Nigel's intro message.

### Start a quiz
A message in the form **'send me \<X\> questions.'** will start a quiz.

### Answer a question
A message in the form **'A\<N\>. \<ANSWER\>'** will answer a question, 
where N is the question number and ANSWER is the answer,which 
should have no more than three decimal places, no trailing zeros 
and should be rounded HALF_EVEN if necessary.

### Reset quiz
A message in the form **'reset'** will reset the quiz.

## Messages 
Message returned by Nigel

### Questions

Questions are sent by Nigel in the format **'Q\<N\>. What is \<INT\>\<OPERATOR\>\<INT\>?'**
Where N is the question number, INT is any Java Integer and OPERATOR can
be +, -, * or /.

### Answer Result

**'Correct'** is returned by Nigel if the submitted answer was correct.

TODO - What about wrong answer???


### Example


e.g.


* you: send me 10 questions.
* me: Q1. What is 2+2?
* you: A1. 4
* me: Correct.

