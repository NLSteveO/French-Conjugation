French-Conjugation

==============Information==============

This is a little software project I started based
off of an idea my brother gave me. It is a way to 
help someone who is learning french to practise 
their conjugation of french verbs. 

The idea is that the person can randomly generate
two words and attempt to give the correct answer.
The prgram will then tell them if they are correct
or not allowing them to try again if it is the 
latter. In the graphical version the user will be 
able to generate each word individually.

==============How to Compile==============

To compile this program, type into your terminal
once in the directory containing the build.xml file:

	%ant compile
	
Or your other option to not use ant would be:

	%mkdir classes #(if the directory already 
	  exists this can be skipped)
	%javac -d classes src/*.java

==============How to Run the Program==============

Once the files are compiled, to run this program 
you have two options. 

	1) You can run the program in the consoles 
	   command line:
		%java -cp classes Tester
		
	2) The other option is that you can run 
	   the interface:
		%ant runUI
		
		
		
