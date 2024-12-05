package bankProject.Version2;


public class Account {
  private int balance;
  
  public void account() {
	  this.balance = 0;
  }
  public void deposit(int amount) {
	  if(amount > 0) {
		  balance += amount; 
	  }
  }
  public void withDraw(int amount) {
	  if(amount > 0 && amount <= balance) {
		  balance -= amount;
	  }
  }
  public int getBalance() {
	  return balance;
  }
  public void setBalance(int balance) {
	  this.balance = balance;
  }
  }

