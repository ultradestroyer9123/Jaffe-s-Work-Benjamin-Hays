package in.javatutorials;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Search for the files in a folder and prints all file details.
 */
public class WordCrawlerInFolder {

private static String directoryPath = "D://test";
private static String searchWord = "Java";

public WordCrawlerInFolder() {
super();
}

public static void main(String[] args) {
   WordCrawlerInFolder crawler = new WordCrawlerInFolder();
    File directory = new File(directoryPath);

    if (directory == null || !directory.exists()) {
           System.out.println("Directory doesn't exists!!!");
           return;
    }
    crawler.directoryCrawler(directory, searchWord);
}

/**
* Gets all the file and directories and prints accordingly
* @param directory
* Directory path where it should search
*/
public void directoryCrawler(File directory, String searchWord) {

// Get List of files in folder and print
File[] filesAndDirs = directory.listFiles();

// Print the root directory name
//System.out.println("-" + directory.getName());

// Iterate the list of files, if it is identified as not a file call
// directoryCrawler method to list all the files in that directory.
for (File file : filesAndDirs) {

if (file.isFile()) {
searchWord(file, searchWord);
//System.out.println(" |-" + file.getName());
} else {
directoryCrawler(file, searchWord);
}
}
}

/**
* Search for word in a given file.
* @param file
* @param searchWord
*/
private void searchWord(File file, String searchWord){
Scanner scanFile;
try {
scanFile = new Scanner(file);
while (null != scanFile.findWithinHorizon("(?i)\\b"+searchWord+"\\b", 0)) {
MatchResult mr = scanFile.match();
System.out.printf("Word found : %s at index %d to %d.%n", mr.group(),
mr.start(), mr.end());
}
scanFile.close();
} catch (FileNotFoundException e) {
System.err.println("Search File Not Found !!!!! ");
e.printStackTrace();
}
}
}
