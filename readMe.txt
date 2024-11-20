
Here’s a comprehensive readMe.txt file for Assignment 2 Data Structures and XML Parser:


Assignment 2: Data Structures and XML Parser


Overview
	This project implements custom data structures (Array List, Doubly Linked List, Stack, Queue) to create a functional XML Parser. 	The parser reads XML files, validates their syntax, and reports errors.

	This document provides installation, usage instructions, and project details for using the XML Parser program.


Usage Instructions
1. Navigate to the Directory:

	Open a terminal/command prompt.
	Change to the directory where Parser.jar is located:
	
2. Run the Parser:

	Execute the following command:

	java -jar Parser.jar <path_to_xml_file>
	Replace <path_to_xml_file> with the full or relative path to your XML file.

Examples:

	1. If the XML file is in the same directory:
		java -jar Parser.jar sample1.xml

	2. If the XML file is elsewhere:
		java -jar Parser.jar "C:\Users\Documents\sample1.xml" for example where the path is the absolute path

3. Output:

	The program will parse the XML file and print:
	Errors (if any), with the line numbers and descriptions.
	"No errors found" if the file is valid.


Features
1. Custom Data Structures:

	Array List, Doubly Linked List, Stack, and Queue implemented from scratch.
	Efficient use of these structures to parse XML files.

2. XML Validation:

	Detects unmatched tags, improper nesting, missing closing tags, and invalid structure.

3. Command-line Execution:

	Supports input of XML file paths directly from the command line.

4. Clear Error Reporting:

	Reports all structural issues in the order they occur.