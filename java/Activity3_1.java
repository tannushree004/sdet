package Activities;

import java.util.ArrayList;

public class Activity3_1 {

	public static void main(String[] args) {
		ArrayList<String> myList =new ArrayList<String>();
		myList.add("Mounika");
		myList.add("Car");
		myList.add("sundeep");
		myList.add("Apple");
		myList.add("IBM");
		
		System.out.println("Print all objects in string:");
		for (String s:myList) {
			System.out.println(s);
		}
		
		System.out.println("Remove the 3rd element:" +myList.get(3));
		System.out.println("Is object in the List:" +myList.contains("sundeep"));
		System.out.println("size of the array:" +myList.size());
		myList.remove("IBM");
		System.out.println("Size of the array again: " +myList.size());

	}

}