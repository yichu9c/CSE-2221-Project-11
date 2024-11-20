Project: Natural Number Calculator
Note: No late submissions will be accepted for this project!

Objectives
Exposure to using the Swing framework and components with the model-view-controller design pattern to develop a Java application with a graphical user interface.
The Problem
You have already written several methods involving the NaturalNumber component family. It's now time to develop a complete application that uses the NaturalNumber components: a natural number calculator. It should work pretty much like any other calculator—except that it does exact arithmetic with natural numbers that have no explicit bounds on their values, which is unlike any other calculator you have likely seen before.

Do not worry about these two potential complications that a professional version of this application might need to address: computing roots of very large natural numbers, say more than 20 digits, tends to be rather slow; and if the numbers get large enough, say hundreds of digits, then some operations can result in "stack overflow" because some recursion gets too deep for the default maximum size of the run-time stack of the JVM. Other than these issues, the calculator should be "bullet-proof" in the sense that a user cannot do anything to make your program crash.

Setup
For this project, instead of creating a new project, you will import a project already set-up for you to get started. First, you will need to download the project, NaturalNumberCalculator, to your computer. Click on this download link and save the file somewhere on your hard drive where you can easily find it. Make sure that you do not expand this archive. (If your browser automatically expands downloaded zip archives, that's OK too. Just pay attention to the special instructions in the following few steps. You may want to make a note of where you saved it.)

Import your new project into Eclipse by following these steps:

From the File menu select Import....
In the new window, expand General and select Existing Projects into Workspace. Click Next.
Click on the radio button next to Select archive file and then click the Browse... button. (If the archive was expanded when you downloaded the file to your own computer, click on Select root directory... instead.)
In the file selection window, find the NaturalNumberCalculator.zip file and select it. (If your browser expanded the archive, find the NaturalNumberCalculator directory instead.) Click OK.
Click Finish.
Start by examining the documentation. Expand the doc folder in your new project, and then open the file index.html in a browser; you might be able to double-click it to open it in a browser, or you might need to right-click on it and select Open With > Web Browser. First look at the documentation for NaturalNumberCalculator, which contains a brief description of the expected behavior of the calculator. Then move on to examine the documentation for the interfaces for the model (NNCalcModel), view (NNCalcView), and controller (NNCalcController). Note that contracts are provided in the interfaces for the model and controller, but not for the view. This is because a contract for the view would add no information to the informal descriptions provided with standard Javadoc comments; the "look and feel" of the calculator is left open this way. The contracts for the model and controller are important. You will need to implement several methods, and these contracts tell you what those methods are supposed to do!

Method
In following the instructions below, you will fill in the bodies of a number of methods in the model (NNCalcModel1), view (NNCalcView1), and controller (NNCalcController1) classes. While we recommend attacking them in this order, there is no requirement to do it this way. A testing strategy is also entirely up to you.

Based on the interface NNCalcModel implemented by the skeleton class NNCalcModel1 you have been provided, edit NNCalcModel1.java to add the required method bodies. Consider unit-testing your code with JUnit.
Based on the interface NNCalcView implemented by the skeleton class NNCalcView1 you have been provided, edit NNCalcView1.java to add the required method bodies. Note that it is hard to test user-interface code like this with JUnit, so be careful because errors here might be difficult to debug.
Based on the interface NNCalcController implemented by the skeleton class NNCalcController1 you have been provided, edit NNCalcController1.java to add the required method bodies. Consider trying to figure out how to unit-test with JUnit the model-related behavior (if not the view-related behavior) of the controller code.
Run the main program in NaturalNumberCalculator.java and do some "system testing" of your full calculator until you are satisfied it works.
Select your Eclipse project NaturalNumberCalculator (not just some of the files, but the whole project), create a zip archive of it, and submit the zip archive to the Carmen dropbox for this project, as described in Submitting a Project. Note: No late submissions will be accepted for this project!
Calculator Demo
A demo version of an executable solution to this project is provided for you to experiment with and possibly to emulate. The user interface in your solution is not required to match the one in the demo, but of course your solution must provide exactly the same functionality.

To run the demo, you need to import the program into Eclipse. First you need to download the project archive, natural-number-calculator.zip, to your computer. Click on this download link and save the file somewhere on your hard drive where you can easily find it. Make sure that you do not expand this archive. If your browser automatically expands downloaded zip archives, that's OK too. Just pay attention to the special instructions in the following few steps. You may want to make a note of where you saved it.

Import your new project in Eclipse by following these steps:

From the File menu select Import....
In the new window, expand General and select Existing Projects into Workspace. Click Next.
Click on the radio button next to Select archive file and then click the Browse... button. (If the archive was expanded when you downloaded the file to your own computer, click on Select root directory... instead.)
In the file selection window, find the natural-number-calculator.zip file and select it. (If your browser expanded the archive, find the natural-number-calculator directory instead.) Click OK.
Click Finish.
To run the program, find the RunCalculator.java file in the src folder in the project and run it as usual as a Java Application.

Additional Activities
Here are some possible additional activities related to this project. Any extra work is strictly optional, for your own benefit, and will not directly affect your grade.

Change the user interface so some or all of the buttons have appropriate labels in a non-English language of your choice. (Because of the MVC design, this requires modifications only to the view class because it involves only changes to the user interface, not to the calculator's functionality.)
Change the layout of the user interface so the buttons are arranged in three areas: a standard phone-style numeric keypad configuration with only "0" in the middle of the bottom row; a set of arithmetic operator buttons; and the set of operand manipulation buttons "Clear", "Swap", and "Enter". (As above, this requires modifications only to the view class.)
Keyboard input is ignored in the original design. Change it so keyboard input is also accepted when entering the digits of a number, and/or when selecting an arithmetic operator, and/or when manipulating the operand locations. (As above, this requires modifications only to the view class.)
Add a third "middle" operand location to the calculator. The problem with only two operands is that some computations such as (3+4)*(5+6) otherwise require writing down intermediate results. This example, for instance, can be done as follows if there are three operand locations: 3 ENTER 4 PLUS 5 ENTER 6 PLUS MULTIPLY. To support more complex calculation sequences like this, many RPN calculators have a "stack" of four or even more operand locations and generalize "Swap" in some way to allow operands to be moved among the locations. (Despite the MVC design, this requires modifications to all three classes because it involves changes to the calculator's functionality as well as the user interface.)
Another calculator feature that is often handy is a "memory" into which the bottom operand can be "stored", and from which the bottom operand can be "recalled". Add a memory feature to your calculator. (As above, all three classes must be changed to make this change.)
