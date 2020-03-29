package cottrell_problem2;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Create a class called DuplicateCounter. 
 * Create an instance method called count that takes a single parameter called dataFile of type String (representing the path to a text file) 
 * and uses a Map of Strings to count how many times each word occurs in dataFile. The counts should be stored in an instance variable called wordCounter. 
 * Create an instance method called write that takes a single parameter called outputFile (representing the path to a text file) 
 * and writes the contents of wordCounter to the file pointed to by outputFile. The output file should be overwritten if it already exists, 
 * and created if it does not exist.
 */


public class DuplicateCounter {

	//int wordCounter = ;

	public void count(String dataFile) {
		//uses a Map of Strings to count how many times each word occurs in dataFile
		//counts should be stored in an instance variable called wordCounter
		
		
		
		try {
			Map<String, Integer> wordCounter = new HashMap<String, Integer>();
			Scanner input = new Scanner(new File(dataFile));
			
			while(input.hasNextLine()){
		
				String line = input.nextLine();
				String[] word = line.split(" ");
				
				for (int i = 0; i < word.length; i++) {
					//making words lower case
					String str = word[i].toLowerCase(); 
					
					Integer count = wordCounter.get(word);
					
					if(word[i] != null)
					{
						for(int j = i + 1; j < word.length; j++) 
						{
							if(word[i].contentEquals(word[j]))
							{
								word[j] = null;
							}
						}
					}
					//store in instance variable called wordCounter
			
				   
					
			}
			
			
			}
		}
		catch(Exception e) {
			//alert the user with a user-friendly message when exceptional IO event occurs
			System.out.println("Unable to open file: " +dataFile);
		}
		
	}
	
	public void write(String outputFile) {
		//writes the contents of wordCounter to the file pointer to by outputFIle
		
		//the output file should be overwritten if it already exists, and created if it does not
		
		try {
			
		}
		
		catch(Exception e) {
			System.out.println("Unable to write file: " +outputFile);
		}
		
	}
	
}
