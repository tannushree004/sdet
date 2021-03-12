package Activities;

import java.util.HashSet;

public class Activity3_2 {

	public static void main(String[] args) {
	HashSet <String> newhash = new HashSet<String>();
	newhash.add("Mounika");
	newhash.add("Deep");
	newhash.add("IBM");
	System.out.println("print the HasH Set:" + newhash.size());
	 newhash.remove("IBM");
	 newhash.remove("Karen");
	 System.out.println("check if set contains the object:" +newhash.contains("Deep"));
	 System.out.println("Updated Hash Set :" +newhash.size());

	}

}