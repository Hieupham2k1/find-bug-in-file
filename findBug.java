
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
public class findBug {
	public static void readFile(String path) {
		File file= new File(path);
		String line;
		try {
		FileReader fr= new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while ((line = br.readLine()) != null){
		       System.out.println(line);
		     }
		fr.close();
		}
		catch(Exception error) {
			System.out.println(error);
		}
	}
	public static void findWord(String word, String path) {
		File file= new File(path);
		String line;
		int i=0;
		try {
		FileReader fr= new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		System.out.println();
		while ((line = br.readLine()) != null){
			++i;
		    if(line.indexOf(word)!=-1) System.out.println("Line "+i+", found word \""+word+"\" in file: "+path);
		}
		fr.close();
		}
		catch(Exception error) {
			System.out.println(error);
		}
	}
	public static void findWordInFile(String word, String extend, String path) {
		File parent= new File(path);
		File[] children=parent.listFiles();
		for (File file : children) {
			if(file.isDirectory()) findWordInFile(word, extend, file.getAbsolutePath());
			if(file.getAbsolutePath().endsWith(extend)) findWord(word, file.getAbsolutePath());
        }
	}
	public static void main(String[] args) {
		String word="base64_decode";
		String extend="php";
		String folder="C:\\Users\\ASUS\\Desktop\\html";
		findWordInFile(word, extend, folder);
	}
}
