package cottrell_problem1;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/* Create a class called DuplicateRemover. 
 * 
 * Create an instance method called remove that takes a single parameter called dataFile of type String (representing the path to a text file) 
 * 	and uses a Set of Strings to eliminate duplicate words from the file referenced by dataFile.
 *  
 * The unique words should be stored in an instance variable called uniqueWords. 
 * 
 * Create an instance method called write that takes a single parameter called outputFile (representing the path to a text file) 
 * 	and writes the words contained in uniqueWords to the file pointed to by outputFile. 
 * 
 * The output file should be overwritten if it already exists, and created if it does not exist.
*/

public class DuplicateRemover {

	String uniqueWords = "";

	public void remove(String dataFile) {
	/*takes a single parameter called dataFile of type String and 
		uses a set of strings to eliminate duplicate words from the file 
		referenced by dataFile
	  the unique words should be stored in an instance variable called uniqueWords
	*/
		//scanner??
		
		try {
			
			LinkedHashSet<String> uniqueWords = new LinkedHashSet<String>();
			Scanner input = new Scanner(new File(dataFile));
			
			while(input.hasNextLine())
			{
				String line = input.nextLine();
				String[] words = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					
					//making words lower case
					String str = words[i].toLowerCase(); 
					
					//determine unique words contained in dataFile
					if(words[i] != null)
					{
						for(int j = i + 1; j < words.length; j++) 
						{
							if(words[i].contentEquals(words[j]))
							{
								words[j] = null;
							}
						}
					}
					
					//store unique words in associated DuplicateRemover object
					uniqueWords.add(str);
					
				}
			}
			
		}
		
	//shall terminate program and alert user when exceptional IO event occurs
		catch(Exception e) {
			//alert the user with a user-friendly message when exceptional IO event occurs
			System.out.println("Unable to open file: " +dataFile);
		}
		
	}
	
	public void write(String outputFile) {
		/* takes single parameter called outputFile and 
		 * writes the words contained in uniqueWords to the file pointed to by outputFile
		 * the output file should be overwritten it if already exists and created if it does not
		 */
		
	// shall print current collection of unique words to outputFile
		try {
			
			new File(outputFile).createNewFile();
			FileWriter fw = new FileWriter(outputFile);
			
				fw.write(uniqueWords);
				fw.close();
		}
		
	//shall terminate program and alert user when exceptional IO event occurs 
		catch(Exception e) {
			System.out.println("Unable to write file: " +outputFile);
		}
		
	}
	
	
}