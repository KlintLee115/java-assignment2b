package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;

import exceptions.EmptyQueueException;
import implementations.MyQueue;
import implementations.MyStack;

/**
 * XML Parser that validates XML documents for proper syntax and structure
 * 
 * @author Klint Lee
 * @version 1.0
 */

public class XMLParser {

    /** Stack to store opening XML tags */
    private final MyStack<String> tagStack = new MyStack<>();
    
     /** Queue to store error messages */
    private final MyQueue<String> errorQueue = new MyQueue<>();
    
    /** Current line number being processed */
    private int lineNumber = 0;

    /**
     * Parses an XML file and validates its syntax
     * 
     * @param filePath the path to the XML file to be parsed
     * @throws EmptyQueueException if queue operations fail
     * @throws java.io.IOException if file reading fails
     */
    public void parseXML(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("<?xml")) continue;

                // Process each tag in the line
                int pos = 0;
                while (pos < line.length()) {
                    int tagStart = line.indexOf('<', pos);
                    if (tagStart == -1) break;

                    int tagEnd = line.indexOf('>', tagStart);
                    if (tagEnd == -1) {
                        logError("Malformed tag - missing '>'", lineNumber);
                        break;
                    }

                    String tag = line.substring(tagStart, tagEnd + 1);
                    String tagName = extractTagName(tag);
                    pos = tagEnd + 1;

                    if (tag.endsWith("/>")) {
                        continue; // Skip self-closing tags
                    }

                    if (tag.startsWith("</")) {
                        // Closing tag
                        if (!tagStack.isEmpty()) {
                            String openTag = (String)tagStack.peek();
                            if (!openTag.equals(tagName)) { // Case-sensitive comparison
                                logError("Mismatched closing tag: </" + tagName + "> for opening tag <" + openTag + ">", lineNumber);
                            }
                            tagStack.pop();
                        } else {
                            logError("Unexpected closing tag: </" + tagName + ">", lineNumber);
                        }
                    } else if (tag.startsWith("<")) {
                        // Opening tag
                        tagStack.push(tagName);
                    }
                }
            }

            MyStack<String> tempStack = new MyStack<>();
            while (!tagStack.isEmpty()) {
                tempStack.push(tagStack.pop());
            }

            while (!tempStack.isEmpty()) {
                String unclosedTag = tempStack.pop();
                logError("Unclosed tag <" + unclosedTag + ">", lineNumber);
            }

            printErrors();
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Extracts the tag name from an XML tag
     *
     * @param tag the XML tag string to process (e.g. "&lt;tag&gt;" or "&lt;/tag&gt;")
     * @return the tag name without brackets and attributes, or null if invalid format
     */
    private String extractTagName(String tag) {
        if (tag.startsWith("</")) {
            return tag.substring(2, tag.length() - 1).trim();
        } else if (tag.startsWith("<")) {
            String name = tag.substring(1, tag.length() - 1).trim();
            int spaceIndex = name.indexOf(' ');
            return spaceIndex != -1 ? name.substring(0, spaceIndex) : name;
        }
        return null;
    }

    /**
     * Logs an error message with line number to the error queue
     * 
     * @param message the error message to log
     * @param lineNum the line number where the error occurred
     */
    private void logError(String message, int lineNum) {
        errorQueue.enqueue("Error at line " + lineNum + ": " + message);
    }


    /**
     * Prints all accumulated errors from the error queue
     * If no errors are found, prints a success message
     * 
     * @throws EmptyQueueException if trying to dequeue from an empty queue
     */
    private void printErrors() throws EmptyQueueException {
        System.out.println("===============ERROR LOG===============");
        if (errorQueue.isEmpty()) {
            System.out.println("No errors found.");
            return;
        }
        while (!errorQueue.isEmpty()) {
            System.out.println(errorQueue.dequeue());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java XMLParser <xml-file>");
            return;
        }
        XMLParser parser = new XMLParser();
        parser.parseXML(args[0]);
    }
}