# A XMPP bot that talks to Nigel the quiz bot

[![Build Status](https://travis-ci.org/wgriffiths/NigelsPal.png?branch=master)](https://travis-ci.org/wgriffiths/NigelsPal)


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

### Questions

Questions are sent by Nigel in the format **'Q\<N\>. What is \<INT\>\<OPERATOR\>\<INT\>?'**
Where N is the question number, INT is any Java Integer and OPERATOR can
be +, -, * or /.

### Answer Result

**'Correct'** is returned by Nigel if the submitted answer was correct.

**'Incorrect'** is returned by Nigel if the submitted answer was correct.

### End of Quiz

**'Quiz over - there are no more questions. You got <CORRECT> correct out of <QUESTIONS> (<PERCENTAGE>%)'** 
Is returned when quiz contained questions.

or

**'There are no more questions.'**
Is returned if quiz did not contained questions.

### Example


e.g.


* you: send me 10 questions.
* me: Q1. What is 2+2?
* you: A1. 4
* me: Correct.

