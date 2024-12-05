package stringsearch;

public class Lab4 {
	public static void main(String[] args) {
		// parse command line arguments
		if (args.length != 3) {
			System.err.println("usage: search <pattern> <file>");
			System.exit(-1);
		}
		
		var pattern = args[1];
		var filename = args[2];
		
		var ss = new StringSearcher(pattern);
		
		ss.goThroughFile(filename);
	}
}
