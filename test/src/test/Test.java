package test;

public class Test {
	public static void main(String[] args) {
		int[] array = { 3, 5, 9, 9, 10, 14, 22, 35, 64 };
		
		reverseElements(array);
	}
	
	public static void reverseElements(int arr[]) {
		int mid = arr.length/2;
		System.out.println(mid);
	}
	/*
	public static void findSums(int[] A, int x) {
		int biggerThan = 0;
		int smallerThan = 0;
		// reference first and last elements of array
		int left = 0;
		int right = A.length-1;
		int index = 0;

		while (left <= right) { 
			int mid = (left + right)/2;
			if (A[mid] == x) {
				index = mid;
				break;
			} else if (A[mid] > x) {
				right = mid - 1;
			} else if (A[mid] < x) {
				left = mid + 1;
			}
		}
		
		left = index - 1;
		right = index;
		
		while (left >= 0) {
			if (A[left] != x) smallerThan += A[left];
			left--;
		}
		while (right < A.length) {
			if (A[right] != x) biggerThan += A[right];
			right++;
		}
		
		System.out.println("Bigger than: " + biggerThan);
		System.out.println("Smaller than: " + smallerThan); */
}
