import java.io.*;
import java.util.Scanner;
import java.util.Iterator;


public class CollectPerson {
	public static void main(String[] args) throws IOException {
		String fileName ="";
		String testfirstName;
		String testlastName;
		int rerun = 1;
		int check = 2;
		String answer;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		

		while(check == 2) {
	//	try {

			
			System.out.println("Enter the file name");
			fileName = in.next();
			File file = new File(fileName);
	   		Scanner reader = new Scanner(file);
	   		check =1;
	   		
	   		SortedABList<Person> myPeeps = new SortedABList<>(Person.ageComparator());
	   		build(myPeeps,reader);

	   		while(rerun == 1) {
	   			System.out.println("Enter the age");
	   			int testage = in.nextInt();
	   			Person test = new Person("","",testage,"","");
	   			/*
	   			System.out.println("Enter the ssn");
	   			String testssn = in.next();
		   		//System.out.println("Enter the first name");
		   		//testfirstName = in.next();
		   		//System.out.println("Enter the last name");
		   		//testlastName = in.next();
		   		Person test = new Person("","",0,"",testssn);
		   		//Person test = new Person(testfirstName,testlastName,0,"","");
		   		 */
		   		 
		   		if(myPeeps.contains(test)==true){
		   			System.out.println(myPeeps.get(test));
		   		}else{
		   			System.out.println("This person was not found, would you like to add the person? y/n");
		   			answer =in.next();
		   			if(answer.equalsIgnoreCase("y")) {
		   				personNotFound(myPeeps);
		   			}
		   		}
		   		 //Iterator<Person> listIter = myPeeps.iterator();
		   		
		   		 //Person item;
		   		 //while(listIter.hasNext())
		   		for(Person item : myPeeps)
		   		 {
		   			 //item = listIter.next();
		   			 System.out.println(item);
		   			 
		   		 }
		   		
		   		@SuppressWarnings("unused")
				String dummy = in.nextLine();
		   		System.out.println("Do you want to rerun this program? y/n");
		   		String response = in.next();
		   		
		   		
		   		if (response.equalsIgnoreCase("y")) {
		   			rerun = 1;	
		   		}else rerun = 2;
		   		
	   		}
		}
		
//		catch(Exception e) {
	//		System.out.println(e.getMessage());
	//		System.out.println("Something went wrong, try again");
	//	}
		
		}
		
//	}

	// read each person from the given Scanner, create a Person object, and add
	// the Person to mypeeps
	public static void build(CollectionInterface<Person> mypeeps, Scanner peopleFile) {
		String fname;
		String lname;
		int age;
		String cell;
		String dummy;
		Person onepeep;
		String ssn;

		// this code assumes that each field of the Person is on a separate line
		// in the input file
		while (peopleFile.hasNext()) {
			fname = peopleFile.nextLine();
			lname = peopleFile.nextLine();
			age = peopleFile.nextInt();
			// read the newline which is left after the call to nextInt
			dummy = peopleFile.nextLine();
			cell = peopleFile.nextLine();
			ssn = peopleFile.nextLine();
			onepeep = new Person(fname, lname, age, cell,ssn);
			mypeeps.add(onepeep);
		}
	}
	public static void personNotFound(CollectionInterface<Person> myPeeps) {
		Scanner in = new Scanner(System.in);
		String firstName;
		String lastName;
		int age;
		String cellNumber;
		String ssn;
		System.out.println("Please enter the first name");
		firstName = in.next();
		System.out.println("Please enter the last name");
		lastName = in.next(); 
		System.out.println("Please enter the age");
		age = in.nextInt();
		System.out.println("Please enter the phone number");
		cellNumber = in.next();
		System.out.println("Please enter the ssn");
		ssn = in.next();
		
		Person newPerson = new Person(firstName,lastName,age,cellNumber,ssn);
		myPeeps.add(newPerson);
	}

}
