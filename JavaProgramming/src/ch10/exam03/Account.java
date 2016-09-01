package ch10.exam03;

public class Account {
	private long balance;
	
	public Account(){}

	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money){
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException{
		if(balance>=money){
			balance -= money;
		} else{
			throw new BalanceInsufficientException("잔고부족");
		}
	}
	
}
