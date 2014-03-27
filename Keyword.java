package studentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Keyword {
	public TreeMap	<String,Integer> noDuplicates(){

		//create a treeMap to store the number of instances of a word.
		TreeMap	<String,Integer> tree_map =	new	TreeMap	<String,Integer>();	
		
		File _file = new File("C:\\Users\\Alan\\Documents\\2205\\example.txt");
		
		//need try-catch if we can't find the file source
		try{
			
			//create scanner obejct to read file
			Scanner input = new Scanner(_file);
					
			//keep taking in inputs from the file and count the occurrences
			while(input.hasNext()){
				String unfiltered_input = input.next().toLowerCase();
				
				//remove any numbers, remove any special characters
				unfiltered_input = unfiltered_input.replaceAll("\\d*", "");
				unfiltered_input = unfiltered_input.replaceAll("\\.", " ");			
				
				String current = unfiltered_input.replaceAll("\\W*", "");

				
				//the value already exists, get its key and increment it
				if(tree_map.containsKey(current)){
					int current_key = tree_map.get(current);
					current_key++;
					tree_map.put(current, current_key);
				}
				else{
					tree_map.put(current, 1);
				}
			}
			input.close();
			
			System.out.println(tree_map);
		
		}
		catch(FileNotFoundException ex){
			System.out.println("FileNotFoundException");
		}
		return tree_map;
	}
}
