package stringsearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringSearcher {
	private String pattern;
	private boolean ignoreCase;
	
	public StringSearcher(String pattern) {
		this(pattern, false);
	}
	
	public StringSearcher(String pattern, boolean ignoreCase) {
		this.pattern = pattern;
		this.ignoreCase = ignoreCase;
	}

	public void goThroughFile(String filename) {
		try (var br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (ignoreCase) {
					if (line.toLowerCase().contains(pattern.toLowerCase())) {
						System.out.println(line);
					}
				} else if (line.contains(pattern)) {
					System.out.println(line);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("error: file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
