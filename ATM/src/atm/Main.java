package atm;

import java.util.Scanner;

public class Main {
	static Scanner sc;

	static database db;

	public static void main(String[] args) {
		db = new database();
		sc = new Scanner(System.in);
		System.out.println("--------ATM MACHINE---------");
		loop1: while (true) {
			System.out.println("\n1.EXISTING USER \n2.ACTIVATE ATM CARD \n3.EXIT");
			System.out.print("\nENTER NUMBER 1 OR 2:");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				existingUser();
				break;
			case 2:
				activateCard();
				break;
			default:
				break loop1;

			}
		}
	}

	public static void existingUser() {
		System.out.print("ENTER A PIN NUMBER :");
		int pin = sc.nextInt();
		boolean i = db.existinguser(pin);
		if (i == true) {

			for (UserInput value : db.users) {
				if (pin == value.getPin()) {
					int balance = value.getBalance();
					int withdraw = 0;
					int deposit = 0;

					db.switchcase(balance, withdraw, deposit);

				} else {
					System.out.println("INVALID USER");
				}

			}
		} else {
			System.err.println("ENTER CORRECT PIN NUMBER...!");
			existingUser();
		}
	}

	public static void activateCard() {
		System.out.print("ENTER A NAME           :");
		String name = sc.next();
		System.out.print("ENTER A PIN            :");
		int pin = sc.nextInt();
		if (db.userExists(pin)) {
			System.err.print("THIS PIN ALREADY EXISTS..!");
			activateCard();
		}
		System.out.print("ENTER A ACCOUNT NUMBER :");
		int account_number = sc.nextInt();
		System.out.print("ENTER A EMAIL          :");
		String email = sc.next();
		System.out.print("ENTER A BALANCE        :");
		int balance = sc.nextInt();
		System.out.println("ACCOUNT CREATED SUCCESSFULLLY...!");

		UserInput user = new UserInput(name, pin, account_number, email, balance);

		db.AddUser(user);
	}
}