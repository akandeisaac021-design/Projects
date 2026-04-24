import java.util.ArrayList;
    public class MethodsTransacLog{

    static ArrayList<String> transactions =new ArrayList<>();
    
    static String newBalance;
    static String transaction;

    static String deposit( double amount, double accountBalance){


String deposited ="#" + String.valueOf(amount);
System.out.print("Amount Deposited: ");
System.out.println(deposited);

newBalance =String.valueOf(accountBalance);
System.out.println("New Balance: ");
System.out.println(newBalance);


transaction ="+" + String.valueOf(amount);
System.out.println("Processing>>>>>>>>>>>>>");
 
    return transaction;
    }




    static String withdrawal( double amount, double accountBalance){



if (amount <= accountBalance){
    String withdrawn ="#" + (amount);
    System.out.print("Amount withdrawn: ");
    System.out.println(withdrawn);

    newBalance =String.valueOf(accountBalance - amount);
    System.out.print("New Balance: ");
    System.out.println(newBalance);

    transaction ="-" + (amount);

    System.out.println("Processing>>>>>>>>>>>>>");
    System.out.println("TRANSACTION SUCCESSFUL!!");

}

else if(amount > accountBalance){
    System.out.println("Withdrawal failed :due to insufficient funds");
    transaction ="FAILED!!";
}

    return transaction;
    
    }

    static String Transfer( double amount, double accountBalance, String recipientsBankName, String recipientsAccountNumber){
if (amount <= accountBalance){
    accountBalance -=amount;

    String transfered ="#" + (amount);
    System.out.print("Amount Transfered: ");
    System.out.println(transfered);

    newBalance =String.valueOf(accountBalance);
    String transaction ="-" + (amount);
    System.out.println("Processing>>>>>>>>>>>>>");
    System.out.println("TRANSACTION SUCCESSFUL!!");

    transaction ="Outgoing: -" + String.valueOf(amount);
System.out.println("Recipients Bank name: " + recipientsBankName);
System.out.println("Recepients Account Number: " + recipientsAccountNumber);
System.out.println("Payment method: Savings Wallet");

}

else if (amount > accountBalance){
    System.out.println("Withdrawal failed :due to insufficient funds");
    transaction ="FAILED";
}   
 
    return transaction;    

    }

    static ArrayList<String> storeTransaction(ArrayList<String> transactions, String transaction){

    transactions.add(transaction);

    return transactions;
    }    



    static void showTransaction(ArrayList<String> transactions){
for (int listCounter =0; listCounter <transactions.size(); listCounter++){
    System.out.println(transactions.get(listCounter));
}


      
    }
}
