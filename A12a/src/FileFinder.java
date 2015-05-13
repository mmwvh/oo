import java.io.File;
import java.io.IOException;

/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */

public class FileFinder implements Runnable {

	private final File rootDir;
	private String goal;
	private File root;

	public FileFinder(String root, String goal) throws IOException {
		this.goal = goal;
		rootDir = new File(root);
		if (!(rootDir.exists() && rootDir.isDirectory())) {
			throw new IOException(root + " is not a directory.");
		}
		this.find(rootDir, goal);
	}

	/**
	 * Finds the directory of the filename
	 * 
	 * @param rootDir
	 *            File
	 * @param fileName
	 *            String
	 * @throws IOException
	 */
	private void find(File rootDir, String fileName) throws IOException {
		File[] files = rootDir.listFiles();
		if (files != null) {
			for (File file : files) {

				if (file.isFile() && file.getName().equals(fileName)) {
					System.out.println("Found at: " + file.getAbsolutePath());
					System.exit(0);
				} else if (file.isDirectory()) {
					Thread t = new Thread(new FileFinder(
							file.getAbsolutePath(), goal));
					t.start();
				}
			}
		}
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		try {
			find(root, goal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
