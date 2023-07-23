public class App {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setAccountNumber(001);
        account1.setAccountOwner("Aron");
        account1.openAccount("CA");
        account1.deposit(256);
        account1.currentState();

    }
}
