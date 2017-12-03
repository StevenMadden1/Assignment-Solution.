package ie.lyit.testers;
import ie.lyit.hotel.Menu;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {
	
	public static void main(String[] args) {
		// Create an object of CustomerSerializer
		CustomerSerializer customerFileHandler = new CustomerSerializer();
		
		// Deserialize the ArrayList from the File,
		// i.e. read the customers ArrayList from the file back into the ArrayList
		customerFileHandler.readRecordsFromFile();
		
	    // Create a Menu Object
		Menu menuObj = new Menu();
		
		do{
			// Call it's display() method
			menuObj.display();
			// Call it's readOption() method
			menuObj.readOption();
			// switch on the option and call the appropriate method
			switch(menuObj.getOption()){
			   case 1:customerFileHandler.add();break;
			   case 2:customerFileHandler.list();break;
			   case 3:customerFileHandler.view();break;
			   case 4:customerFileHandler.edit();break;
			   case 5:customerFileHandler.delete();break;
			   case 6:break;				
			   default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);	
																			
		// Serialize the ArrayList to the File
		// i.e. write the customers ArrayList back into the the file		
		customerFileHandler.writeRecordsToFile();
	}
}
