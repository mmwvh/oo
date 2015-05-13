import java.io.IOException;

/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */

public class FileFinderTest {
	public static void main(String[] args) {
		FileFinderTest fft = new FileFinderTest();
	}

	public FileFinderTest() {
		try {
			String goal = "FileFinder.java";
			String root = "/home"; // "C:\\" for Windows, "/" or "/home" for Linux
			FileFinder ff = new FileFinder(root, goal);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
