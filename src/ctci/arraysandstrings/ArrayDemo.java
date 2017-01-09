package ctci.arraysandstrings;
import java.util.Arrays;

public class ArrayDemo {

	
	public static void main(String[] args) {
		
		System.out.println("Modulus of negative numbers : " + -5%2);
		// TODO Auto-generated method stub
		int array[] = {1,2,3,4,5,5,6,6,7};
		//displayUniqueElements(array);
		int array1[] = {0,1,1,2,2,3,4,4,5,5,6,7,8};
		//displayTheUnpairedElements(array1);
		
		//displayPyramid(5);
		calculateSum(array1);
	}
	
	
	private static void calculateSum(int[] array1) {
		int sum = 0;
		for(int i = 0; i < array1.length; i++){
			sum+=array1[i];
		}
		System.out.println("Total: " + sum);
	}


	private static void displayPyramid(int x) {
		for(int i = 0; i < x; i++){
			for(int j=0; j< i+2; j++)
				System.out.print("1");
			System.out.println();
		}
		
	}


	private static void displayTheUnpairedElements(int[] array1) {
		//displays all the element sin the array which are not paired
		
		for(int i = 0; i < array1.length; i++){
			if(i+1< array1.length){
				if(array1[i] == array1[i+1]){
					i++;
				}else{
					System.out.println("Unpaired Element: " + array1[i]);
				}
			}else{
				System.out.println("Unpaired Element: " + array1[i]);
			}
		}
	}

	private static void displayUniqueElements(int[] array) {
		//In place 
		
		int i = 0; 
		int j = 1;
		while(j < array.length){
			if(array[i] == array[j]){
				j++;
			}else{
				i++;
				array[i] = array[j];
				j++;
			}
		}
		int newArray[] = Arrays.copyOf(array, i+1);
		
		System.out.println("New Unique Array: " + Arrays.toString(newArray));
	}

	public int test(int arr[]){
	int start = arr[0];

	for(int i = 1;i < arr.length; i++ ){
		if(start < arr[i+1]){
			start = arr[i+1];
		}else if(start > arr[i]){
			//keep finding the number till u find the max number
			//calculate the fi
		}
		
		

	}
	
	return 0;
	}
}
	
