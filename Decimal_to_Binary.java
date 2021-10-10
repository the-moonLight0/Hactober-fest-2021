// Java program to convert a decimal
// number to binary number

public class Decimal_to_Binary {
	
	static void decimalToBinaryUtility(int n) {
		// array to store binary number
		int[] binaryNum = new int[32];

		// counter for binary array
		int i = 0;
		while (n > 0) {
			// storing remainder in binary array
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}

		// printing binary array in reverse order
		for (int j = i - 1; j >= 0; j--)
			System.out.print(binaryNum[j]);
	}

	// execution starts here.
	public static void main(String[] args) {
		int n = 17;
		decimalToBinaryUtility(n);
	}
}
