package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class database {
	static Scanner sc;

	ArrayList<UserInput> users = new ArrayList<>();

	public void AddUser(UserInput data) {

		users.add(data);

	}

	public boolean existinguser(int pin) {
		boolean f = false;
		for (UserInput data : users) {
			if (pin == data.getPin()) {
				f = true;
			}
		}
		return f;

	}

	public boolean userExists(int pin) {
		boolean f = false;
		for (UserInput value : users) {
			if (value.getPin() == pin) {
				f = true;
				break;
			}
		}
		return f;
	}

	public void switchcase(int balance, int withdraw, int deposit) {

		sc = new Scanner(System.in);
		loop: while (true) {
			System.out.println("\nENTER 1 -----> CHECK BALANCE");
			System.out.println("ENTER 2 -----> WITHDRAW");
			System.out.println("ENTER 3 -----> DEPOSIT MONEY");
			System.out.println("ENTER 4 -----> TAKE RESIPT");
			System.out.println("ENTER 5 -----> EXIT");
			int n = sc.nextInt();
			switch (n) {
			case 1:

				System.out.println("YOUR CURRENT BALANCE IS : " + balance);

				break;

			case 2: {
				System.out.print("ENTER THE WITHDRAWAL AMOUNT : ");
				withdraw = sc.nextInt();

				if (withdraw < balance) {
					balance = balance - withdraw;
					System.out.println("YOU BALANCE IS : " + balance);
				} else {
					System.out.println("INSUFFICIENT BALANCE....!\n YOUR BALANCE IS :" + balance);
				}
			}
				break;

			case 3: {
				System.out.print("ENTER AMOUNT : ");
				deposit = sc.nextInt();

				balance = deposit + balance;
				System.out.println("NOW YOUR BALANCE IS : " + balance);
			}
				break;
			case 4: {

				System.out.println("-------ATM MACHINE GENERATED RECEIPT-------");
				System.out.println("  YOUR BALANCE AMOUNT IS  : " + balance);
				System.out.println("  LAST WIDTHDRAWAL AMOUNT : " + withdraw);
				System.out.println("  LAST DEPOSIT AMOUNT     : " + withdraw);
				System.out.println("--------------------------------------------");
				System.out.println("             THANKS FOR COMING.             ");

			}
				break loop;
			default: {
				System.err.println("ENTER THE NUMBER BELOW 5");
				break loop;
			}
			}
		}
	}

}
