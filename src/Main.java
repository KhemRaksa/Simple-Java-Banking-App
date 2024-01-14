import java.util.Scanner;

class BankDetails {
    private String account_number;
    private String name;
    private String account_type;
    private long balance;

    Scanner scanner = new Scanner(System.in);

    public void openAccount(){
        System.out.println("Enter Account Number: ");
        this.account_number = scanner.next();
        System.out.println("Enter Account Type: ");
        this.account_type = scanner.next();
        System.out.print("Enter Name: ");
        this.name = scanner.next();
        System.out.println("Enter Balance: ");
        this.balance = scanner.nextLong();
    }

    public void showAccount(){
        System.out.println("Name of Account Holder: " + this.name);
        System.out.println("Account Number: " + this.account_number);
        System.out.println("Account Type: " + this.account_type);
        System.out.println("Balance: " + this.balance);
    }

    public void deposit() {
        long atm;
        System.out.println("Enter the amount you want to deposit: ");
        atm = scanner.nextLong();
        this.balance = this.balance + atm;
    }

    public void withdrawal() {
        long atm;
        System.out.println("Enter the amount you want to withdraw: ");
        atm = scanner.nextLong();
        if(this.balance >= atm) {
            this.balance = this.balance - atm;
            System.out.println("Balance After Withdrawal: " + this.balance);
        }else{
            System.out.println("Your balance is less than " + atm + "\t Transaction failed");
        }
    }

    public boolean search (String account_number){
        if(this.account_number.equals(account_number)){
            showAccount();
            return (true);
        }
        return false;
    }


}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many customers do you want to input ?");

        int number = scanner.nextInt();

        BankDetails C[] = new BankDetails[number];

        for(int i=0; i < C.length; i++){
            C[i] = new BankDetails();
            C[i].openAccount();
        }

        int choice;
        do {

            System.out.println("*** Simple Banking Application ***");
            System.out.println("1. Display all account details");
            System.out.println("2. Search Account Number");
            System.out.println("3. Deposit The Amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice){

                case 1:
                    for(int i = 0; i < C.length; i++){
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.println("Enter account number you want to search: ");
                    String account_number = scanner.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++){
                        found = C[i].search(account_number);
                        if(found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account doesn't exist");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    account_number = scanner.next();
                    found = false;
                    for (int i = 0; i < C.length; i++){
                        found = C[i].search(account_number);
                        if(found){
                            C[i].deposit();
                            break;
                        }
                    }
                case 4:
                    System.out.println("Enter Account Number: ");
                    account_number  = scanner.next();
                    found = false;
                    for (int i = 0; i < C.length; i++){
                        found = C[i].search(account_number);
                        if(found){
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account doesn't exist..!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon!");
                    break;
            }
        }while(choice!=5);
    }
}

