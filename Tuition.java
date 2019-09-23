public class Tuition {

	public static void main(String[] args) {
		
		System.out.print("How many credits is the student taking this semester?: ");
		int credits = IO.readInt();
		System.out.print("Is the student an university employee? ");
		boolean isUniversityEmployee = IO.readBoolean();
		System.out.print("Is the student a state employee? ");
		boolean isStateEmployee = IO.readBoolean();
		System.out.print("Is the student paying in installments? ");
		boolean isPayingInInstallments = IO.readBoolean();
		if (credits < 0) {
			IO.reportBadInput();
		} else {
			double total = 5.75;
			double creditsCost = credits * 35;
			if (isStateEmployee == true) {
				total += (creditsCost * .20);
			} else if (isUniversityEmployee == false) {
				total += creditsCost;
			}
			if (isPayingInInstallments == true) {
				total = total + (total * .02);
			}
			IO.outputDoubleAnswer(total);
		}

	}

}

