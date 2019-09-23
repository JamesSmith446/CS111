
public class PayFee {

	public static void main(String[] args) {
		System.out.print("Input payment amount: ");
		double payment = IO.readDouble();
		double fee = 0;
		if (payment <= 500) {
			fee = 10;
		} else if (payment > 500 && payment < 5000) {
			if ((payment*.01) < 20) {
				fee = 20;
			} else {
				fee = payment*.01;
			}
		} else if (payment >= 5000 && payment < 10000) {
			if ((payment*.02) < 120) {
				fee = 120;
			} else {
				fee = payment*.02;
			}
		} else if (payment >= 10000) {
			double subFee1 = 0;
			double subFee2 = 0;
			if (payment > 10000) {
				if (payment >= 15000) {
					subFee1 = 5000 * .03;
					subFee2 = (payment - 15000) * .04;
				} else {
					subFee1 = (payment - 10000) * .03;
				}
			}
			fee = (10000 *.02) + subFee1 + subFee2;
		}
		IO.outputDoubleAnswer(fee);
	}

}
