import java.util.*;

// class for a person
public class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private int age;
	private String cell;
	private String ssn;

	// default constructor
	Person() {}

	// initializing constructor
	Person(String first, String last, int aa, String cell, String ssn) {
		firstName = first;
		lastName = last;
		age = aa;
		this.cell = cell;
		this.ssn = ssn;
	}
	public int compareTo(Person o){
			Person person = (Person) o;
			if(this.lastName.equals(person.lastName)){
				if(this.firstName.equals(person.firstName)){
					return 0;
				}
				else return this.firstName.compareTo(person.firstName);
			}
			else return this.lastName.compareTo(person.lastName);
		
		
		
	
	}
	public boolean equals(Object o){
		if (o==this)
			return true;
		if(!(o instanceof Person))
			return false;
		Person person = (Person) o;
		return (this.firstName.equals(person.firstName)&& (this.lastName.equals(person.lastName)));
	}
	public String toString(){
		String a = ("Name: "+firstName+" "+lastName+
				"\nAge: "+age+"\nCell # : "+cell
				+"\nSSN: "+ssn);
		return a;
	}

	public static Comparator<Person> ssnComparator(){
		return new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return p1.ssn.compareTo(p2.ssn);
			}
		};
		
	}
	public static Comparator<Person> ageComparator(){
		return new Comparator<Person>(){
			public int compare(Person p1, Person p2){
				return (int)(p1.age - p2.age);
			}
		};
		
	}
}
