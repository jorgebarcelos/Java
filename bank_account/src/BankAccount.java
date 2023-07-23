public class BankAccount {
    public int accountNumber;
    protected String accountType;
    private String accountOwner;
    private float accountBalance;
    private boolean accountStatus;


    public void currentState(){
        System.out.println("Accout number: " + this.getAccountNumber());
        System.out.println("Account type : " + this.getAccountType());
        System.out.println("Account owner:" + this.getAccountOwner());
        System.out.println("Account balance:" + this.getAccountBalance());
        System.out.println("Account status: " + this.getAccountStatus());
    }


    public BankAccount() {
        this.setAccountBalance(0);
        this.setAccountStatus(false);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void openAccount(String type) {
        this.setAccountType(type);
        this.setAccountStatus(true);

        if ("CA".equals(type)) {
            this.setAccountBalance(50);
        } else if ("SA".equals(type)) {
            this.setAccountBalance(150);
        }
    }

    public void ocloseAccount() {
        if (this.getAccountBalance() > 0) {
            System.out.println("Account canot be closed, you still have money!!");
        } else if (this.getAccountBalance() < 0){
            System.out.println("Account canot be closed, you're in negative balance!!");
        } else {
            this.setAccountStatus(false);
            System.out.println("Your Account has been successfully Closed.");
        }
    }

    public void deposit(float value) {
        if (this.getAccountStatus()) {
            this.setAccountBalance(this.getAccountBalance() + value);
            System.out.println("Deposit ok in account of: " + this.getAccountOwner());
        } else {
            System.out.println("Impossible to accomplish deposit in a closed account!");
        }
    }

    public void withdraw(float value) {
        if (this.getAccountStatus()) {
            if (this.getAccountBalance() >= 0) {
                this.setAccountBalance(this.getAccountBalance() - value);
                System.out.println("withdraw accomplish in accout: " + this.getAccountOwner());
            } else {
                System.out.println("You don't have enough funds for that operation! ");
            }
        }else {
            System.out.println("Cannot perform the requested action on an inactive account!");
        }
    }

    public void payTax(int value) {
        if (this.getAccountType() == "CA"){
            value = 12;
        } else if (this.getAccountType() == "SA"){
            value = 20;
        }
        if (this.getAccountStatus()) {
            this.setAccountBalance(this.getAccountBalance() - value);
            System.out.println("Tax paid with success!");
        } else {
            System.out.println("tax not paid, the account is closed!");
        }
    }
}