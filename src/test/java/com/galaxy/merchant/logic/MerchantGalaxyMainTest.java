/**
 * 
 */
package com.galaxy.merchant.logic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.galaxy.merchant.logic.processor.InputProcessor;
import com.galaxy.merchant.logic.processor.OutputProcessor;

/**
 * @author vrajesh
 *
 */
public class MerchantGalaxyMainTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	protected String filePath;

	@Before
	public void setUpStreams() {
		filePath = null;
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	/**
	 * Method tests a positive scenario of the application. Input file by default
	 * picked up by the input.
	 */
	public void testProgram() throws IOException {
		InputProcessor.ProcessFile(filePath);
		InputProcessor.MapTokentoIntegerValue();
		OutputProcessor.processReplyForQuestion();
		Assert.assertEquals("how many Credits is glob prok Iron ? glob prok Iron is 782.0 Credits\n"
				+ "how much is pish tegj glob glob ? pish tegj glob glob is 42.0\n"
				+ "how many Credits is glob prok Gold ? glob prok Gold is 57800.0 Credits\n"
				+ "how many Credits is glob prok Silver ? glob prok Silver is 68.0 Credits\n",
				removeWord(outContent.toString(), "OutContent :"));
	}

	private static String removeWord(String string, String word) {
		// Check if the word is present in string
		// If found, remove it using removeAll()
		if (string.contains(word)) {
			string = string.replaceAll(word, "");
		}

		// Return the resultant string
		return string;
	}

}
