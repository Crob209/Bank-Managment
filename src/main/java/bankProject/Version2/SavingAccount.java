package bankProject.Version2;

public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount() {
        super();
        this.interestRate = 0.0; 
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

   
}

