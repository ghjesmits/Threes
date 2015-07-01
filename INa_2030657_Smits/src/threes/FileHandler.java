package threes;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	
		List<String> readTextFile(String aFileName) {
		List<String> returnList = null;
		
		try{
			Path path = Paths.get(aFileName);
			returnList =  Files.readAllLines(path, ENCODING);
		}
		catch (IOException e)
		{
			System.out.println("Error in readTextFile: " + e.getMessage());
		}
		return returnList;
	}
}
