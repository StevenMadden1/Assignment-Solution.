package ie.lyit.serialize;
import java.util.*;


import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ie.lyit.hotel.*;

import java.io.*;

public class CustomerSerializer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Customer> customers;
	
	private final String FILENAME = "customer.ser";
	
	//Default Constructor
	public CustomerSerializer() {
		//Construct customerList ArrayList
		customers = new ArrayList<Customer>();
	}

	//Method Name : add()
	//Return Type : void
	//Purpose : add a customer to the customer ArrayList
	public void add() {
		//Create a Customer Object
		Customer customer = new Customer();
		
		//Read its details
		customer.read();
		
		//And add it to the customer ArrayList
		customers.add(customer);
		
	}
	
	
	// Method Name : list()							      
	// Return Type : void			  				      
	// Parameters : None						 	      
	// Purpose : Lists all Customer records in the ArrayList  	
	public void list(){
	// for every Customer object in customers
	for(Customer tmpCustomer:customers)
	// display it
	System.out.println(tmpCustomer);
	}
	
	

	// Method Name : view()									  
	// Return Type : void								      
	// Parameters : None								      
	// Purpose : Displays the required Customer record on screen  
	//         : And returns it, or null if not found          
	public Customer view(){
	Scanner keyboard = new Scanner(System.in);		
	
	// Read the number of the customers to be viewed from the user
	System.out.println("Enter Customer Number : ");
	int custNo=keyboard.nextInt();
	
	// for every Customer object in customers
	for(Customer tmpCustomer:customers){
	// if it's number equals the number of the customersToView
	if(tmpCustomer.getNumber() == custNo){
	// display it
	System.out.println(tmpCustomer);
	return tmpCustomer;
	}
	}
	// if we reach this code the customer was not found so return null
	return null;		
	}
	

	// Method Name : delete()							
	// Return Type : void								
	// Parameters : None								
	// Purpose : Deletes the required Customer record from customers 
	public void delete(){	
	// Call view() to find, display, & return the customer to delete
	Customer tempCustomer = view();
	// If the customer != null, i.e. it was found then...
	if(tempCustomer != null)
	// ...remove it from customers
	customers.remove(tempCustomer);
	}
	

	// Method Name : edit()			  					
	// Return Type : void									
	// Parameters : None									 
	// Purpose : Edits the required Customer record in customers    
	public void edit(){	
	// Call view() to find, display, & return the customer to edit
	Customer tempCustomer = view();
	// If the customer != null, i.e. it was found then...
	if(tempCustomer != null){
	// get it's index
	int index=customers.indexOf(tempCustomer);
	// read in a new customer and...
	tempCustomer.read();
	// reset the object in customers
	customers.set(index, tempCustomer);
	}
	}
	
	
	
	//This method will serialize the customers ArrayList when called,
	//i.e it will write it to a file called customers.ser
	public void writeRecordsToFile() {
		try {
		
		//Serialize the ArrayList...
		FileOutputStream fileStream = new FileOutputStream(FILENAME);
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		os.writeObject(customers);
		os.close();
		}
		catch(FileNotFoundException fNFE) {
			System.out.println("Cannot create file to store customers.");
		}
		catch(IOException ioE) {
			System.out.println(ioE.getMessage());
		}
	}
	
	//Reading records from the file
	public void readRecordsFromFile(){
		try{
			// Deserialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);

			// COULD use code below to ensure it is an ArrayList
			// BUT no need-we are confident file contains an ArrayList
			// Object o = is.readObject(); 	// READ an object from the file
			// if(o instanceof ArrayList)  	// IF object is an ArrayList
			//    customers=(ArrayList<Customer>)o;//    ASSIGN object to customers			
			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find books file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			
		
		
	}
}
