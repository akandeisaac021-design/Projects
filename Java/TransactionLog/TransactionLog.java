import java.util.Scanner;
import java.util.ArrayList;


public class TransactionLog{
    public static void main(String[] args){

double accountBalance =0;
int counter =0;
ArrayList<String> transactions =new ArrayList<>();

String newBalance =" ";


Scanner scanner =new Scanner(System.in);


String transactionOption = """
        Press 1 To Deposit
        Press 2 To Withdrawal
        Press 3 To Transfer
        Press 4 To Transaction History
        Press 5 To Exit
        """;
System.out.println(transactionOption);

System.out.println("Enter a choice: ");
int transactionLogChoice =scanner.nextInt();
while (transactionLogChoice !=5){
    switch(transactionLogChoice){
        case 1 ->{System.out.println("Deposit");

            System.out.print("Enter an amount: ");
            double amount =scanner.nextDouble();
            while(amount <=0){
                System.out.print("re-enter a valid amount: ");
                amount =scanner.nextInt();
            }
            accountBalance += amount;
            String transaction =MethodsTransacLog.deposit(amount, accountBalance);
            MethodsTransacLog.deposit(amount, accountBalance);
            MethodsTransacLog.storeTransaction(transactions, transaction);
            System.out.println("TRANSACTION SUCCESSFUL!!");
        }

        case 2 ->{System.out.println("Withdrawal");
            System.out.print("Enter an amount: ");
            double amount =scanner.nextDouble();
            while(amount <=0){
                System.out.print("re-enter a valid amount: ");
                amount =scanner.nextInt();
            }
            String transaction =MethodsTransacLog.withdrawal(amount, accountBalance);
            MethodsTransacLog.withdrawal(amount, accountBalance);
            if (!transaction.equals("Failed")){
                accountBalance -=amount;}
            MethodsTransacLog.storeTransaction(transactions, transaction);

        } 

        case 3 ->{System.out.println("Transfer");

            System.out.println("Enter the recipents Bank: ");
            String recipientsBankName =scanner.nextLine();

            scanner.nextLine();

            System.out.println("Enter Reciepients account number: ");
            String recipientsAccountNumber =scanner.nextLine();

            System.out.print("Enter an amount to transfer: ");
            double amount =scanner.nextDouble();
            scanner.nextLine();
            while(amount <=0){
                System.out.print("re-enter a valid amount: ");
                amount =scanner.nextInt();
            }
            String transaction =MethodsTransacLog.Transfer(amount, accountBalance, recipientsBankName, recipientsAccountNumber);
            MethodsTransacLog.Transfer(amount, accountBalance, recipientsBankName, recipientsAccountNumber);
            if (!transaction.equals("Failed")){
                accountBalance -=amount;}
            
            MethodsTransacLog.Transfer(amount, accountBalance, recipientsBankName, recipientsAccountNumber);
            MethodsTransacLog.storeTransaction(transactions, transaction);     

        }



        case 4 ->{System.out.println("Transaction History");
            MethodsTransacLog.showTransaction(transactions);

        }
        
       default->System.out.println("Invalid choice!");

    }
    String newTransactionOption = """
            Do you wish to make another transaction
                Press 1 For yes
                Press 2 For No
                """;
    System.out.println(newTransactionOption);
    System.out.println("Do you wish to make another transaction ?");
    int newTransactionOptionChoice =scanner.nextInt();
    while(newTransactionOptionChoice <1 ||newTransactionOptionChoice >2){
        System.out.println("Invalid Choice: ");
        System.out.println(newTransactionOption);
        System.out.println("Try again: ");
        newTransactionOptionChoice =scanner.nextInt();}

    if  (newTransactionOptionChoice ==2){
        break;}
    else if(newTransactionOptionChoice ==1){
        System.out.println(transactionOption);
        System.out.println("Enter a choice: ");
        transactionLogChoice =scanner.nextInt();}
    
}
System.out.println("Thank you for using I.B.I(International Bank of Isaac");
    }
}
