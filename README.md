-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCourseSequencer/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCourseSequencer/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCourseSequencer/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:
####Command: ant -buildfile studentCourseSequencer/src/build.xml run -Darg0=input.txt -Darg1=output.txt  -Darg2=errorLog.txt

## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:
1. I have defined a FileProcessor.java class to read and parse input.txt file and store these objects inside a global static data structure inside a static class.

2. I have used an global data structure arraylist to store the course preference of a student.

3. I have used a Student.java class to store student completed courses. I have used one arraylist to store all the completed courses and four other arraylist to store completed courses in respective group.

4. To implement given state machine, I have defined one base class State.java and five subclasses of this class named State1.java, State2.java, State3.java, State4.java and State5.java.

5. State.java implements logic of transition of state and total number of state transitions.

6. To implement transition of states, I have used an algorithm which is based on number of completed courses inside respective group. State uses Student object to get number of completed courses in each group. Each group is an arraylist stored inside the student object i.e. five groups so, five arraylists and each arraylist stores number of completed courses in that group. 

7. I started with state one and at end of each semester, I calculate number of completed courses inside each group of a Student object i.e. list length of all the five lists. A change of state occurs only when a student's number of completed courses in any other group is more than in the current group. 

8. I have used a Course.java class, which implements a method to return a prerequisite list of a given course.

9. I have used a Context.java class, which implements methods of CourseSequencerStateI.java. It has two methods scheduler() and determinechangeGroup().

10. Context.java implements scheduler() method to schedule the global preference list courses of a student.
 
11. To implement waitinglist logic inside the scheduler method, I get the preference course from preference global list and with the help of course logic, I get the prerequisite list of the given course and if a prerequisite course is not present inside the Student completed course then I add this course inside the waitinglist arraylist of the context object.

12. Context.java implements determinechangeGroup() which uses State base object to determine the next state of the given state machine.

13. I have used three arguements in the command line i.e. input.txt, output.txt and errorLog.txt.

14. Path for State Diagram:
####  studentCourseSequencer/stateDiagram_assign3.pdf










