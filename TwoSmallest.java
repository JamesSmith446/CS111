
public class TwoSmallest {

	public static void main(String[] args) {
		System.out.print("Input terminating value: ");
		double terminatingValue = IO.readDouble();
		double num;
		double min = Double.MAX_VALUE;
		double min2 = Double.MAX_VALUE;	
		int count = 0;
		boolean shouldRun = true;
		do {
			System.out.print("Input number: ");
			num = IO.readDouble();
			if (num != terminatingValue) {
				count++;
				if (num < min && num < min2) {
					min2 = min;
					min = num;
				} else if (num < min2) {
					min2 = num;
				}
			}
			if (count <= 1) {
				shouldRun = true;
			} else {
				if(terminatingValue == num) {
					shouldRun = false;
				}
			}
		} while (shouldRun);
		IO.outputDoubleAnswer(min);
		IO.outputDoubleAnswer(min2);
	}
}
