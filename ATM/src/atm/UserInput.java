package atm;

public class UserInput {
	String name;
	int pin;
	int account_number;
	String email;
	int balance;
	
	public UserInput(String name,int pin,int account_number,String email,int balance) {
		this.name=name;
		this.pin=pin;
		this.account_number=account_number;
		this.email=email;
		this.balance=balance;
	}

	public UserInput() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public int getPin() {
		return pin;
	}

	public int getAccount_number() {
		return account_number;
	}

	public String getEmail() {
		return email;
	}
	public int getBalance() {
		return balance;
	}
	
	
    
}
