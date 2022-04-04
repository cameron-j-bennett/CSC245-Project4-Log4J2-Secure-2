package edu.arapahoe.csc245;

import java.util.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * This program demonstrates log4j usage in a program.
 *
 * @since 2022-04-03
 * @author Cameron Bennett | CSC 245
 */
public class Exercise12_03 {
	// Using log4j to log traces and errors in the program.
	private static final Logger logger = LogManager.getLogger(Exercise12_03.class);

	public static void main(String[] args) {
		// Let the logger display trace level logs.
		Configurator.setLevel(logger.getName(), Level.TRACE);

		// Create an empty integer array of size 100.
		int[] data = new int[100];

		for(int i = 0; i < 100; i++) {
			// Get a random integer between 1 and 10000
			data[i] = (int) (Math.random() * 10000);

			// Only display the trace logs if trace level is enabled.
			if(logger.isEnabled(Level.TRACE)) {
				//logger.trace("Generated random int (" + data[i] + ") at index " + i);
				logger.trace("Generated random int {} at {}", data[i], i);
			}
		}

		// Create a new scanner to read the index input.
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an index between 0 and 99: ");

		// Get an integer from the scanner.
		int index = input.nextInt();

		try {
			// Print the number if it is within the bounds.
			System.out.println("The element is " + data[index]);
		}
		catch(Exception e) {
			// Only display the error logs if error level is enabled.
			if(logger.isEnabled(Level.ERROR)) {
				logger.error("Input out of bounds! {}", e.toString());
			}

			e.printStackTrace();
		}

		// Close the input stream.
		input.close();
	}
}