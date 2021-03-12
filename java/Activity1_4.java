package Activities;

public class Activity1_4 {

	public static void main(String[] args) {
		int array[] = {9,7,2,0,5};
		int temp=0;
		
		// print original array
		System.out.println("print original array");
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i] +" ");
		}
		// sort array in ascending order
		for (int i=0;i<array.length;i++) {
			for(int j=i+1; j<array.length; j++) {
				temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				}
			}
		System.out.println();
		// display sorted array
		System.out.println("print sorted array:");
		for (int i=0; i<array.length;i++) {
			System.out.print(array[i] +" ");
		}

	}

}