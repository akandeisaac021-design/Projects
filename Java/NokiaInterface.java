import java.util.Scanner;

public class NokiaInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String appMenu = """
                NOKIA CONNECTING PEOPLE AND THINGS - Isaac's Hardwork

                Press 1 For Phone book
                Press 2 For Messages
                Press 3 For Chat
                Press 4 For Call Register
                Press 5 For Tones
                Press 6 For Settings
                Press 7 For Call divert
                Press 8 For Games
                Press 9 For Calculator
                Press 10 For Remainders
                Press 11 For Clock
                Press 12 For Profile
                Press 13 For SIM services
                """;

        System.out.print(appMenu);
        int menuFunction = input.nextInt();

        switch (menuFunction) {
            case 1 -> {
                System.out.println("Phonebook");
                String phoneBook = """
                        PHONEBOOK
                        Press 1 For Search
                        Press 2 For Service Number
                        Press 3 For Add name
                        Press 4 For Erase
                        Press 5 For Edit
                        Press 6 For Assign tone
                        Press 7 For Send b'card
                        Press 8 For Options
                        Press 9 For Speed dials
                        Press 10 For Voice tags
                        """;
                System.out.print(phoneBook);
                System.out.print("Enter a choice:");
                int phonebookChoice = input.nextInt();
                switch (phonebookChoice) {
                    case 1 ->   System.out.print("Search");
                    case 2 ->   System.out.print("Service number");
                    case 3 ->   System.out.print("Add name");
                    case 4 ->   System.out.print("Erase");
                    case 5 ->   System.out.print("Edit");
                    case 6 ->   System.out.print("Assign tone");
                    case 7 ->   System.out.print("Send b'card");
                    case 8 -> {
                        System.out.print("Options");
                        String options = """
                                Press 1 For Type of view
                                Press 2 For Memory Status
                                """;
                        System.out.print(options);

                        System.out.print("Enter a choice:");                        
                        int optionsChoice = input.nextInt();
                        switch (optionsChoice) {
                            case 1 ->   System.out.print("Type of view");
                            case 2 ->   System.out.print("Memory status");
                        }
                    }
                    case 9 ->   System.out.print("Speed dials");
                    case 10 ->  System.out.print("Voice tags");
                }
            }


            case 2 -> {
                  System.out.print("Messages");
                String messages = """
                        MESSAGES
                        Press 1 For Write messages
                        Press 2 For Inbox
                        Press 3 For Outbox
                        Press 4 For Picture messages
                        Press 5 For Templates
                        Press 6 For Smileys
                        Press 7 For Send b'card
                        Press 8 For Info service
                        Press 9 For Voice mailbox number
                        Press 10 For Service command editor
                        """;
                  System.out.print(messages);

                System.out.print("Enter a choice:");
                int messageChoice =input.nextInt();
                  switch (messageChoice) {
                    case 1 ->   System.out.print("Write messages");
                    case 2 ->   System.out.print("Inbox");
                    case 3 ->   System.out.print("Outbox");
                    case 4 ->   System.out.print("Picture messages");
                    case 5 ->   System.out.print("Templates");
                    case 6 ->   System.out.print("Smileys");
                    case 7 -> {
                          System.out.print("Send b'card");
                        String sendBdayCard ="""
                                Press 1 For SET 1
                                Press 2 For Common
                                """;
                          System.out.print(sendBdayCard);

                        System.out.print("Enter a choice:");
                        int sendBdayCardChoice=input.nextInt();
                        switch (sendBdayCardChoice){
                            case 1 ->{
                                  System.out.print("Set 1");
                                String set1 ="""
                                    Press 1 For Message center number
                                    Press 2 For Message sent as 
                                    Press 3 For Message validity
                                    """;
                                  System.out.print(set1);

                                System.out.print("Enter a choice:");
                                int set1Choice =input.nextInt();
                                  switch(set1Choice){
                                    case 1->  System.out.print("Message center number");
                                    case 2->  System.out.print("Message sent as ");
                                    case 3->  System.out.print(" Message validity");
                                  }  
                            }
                        

                            case 2->{
                                  System.out.print("Common");
                                 String common ="""
                                    Press 1 For Delivery reports
                                    Press 2 For Reply via same center 
                                    Press 3 For Charater support
                                    """;
                                  System.out.print(common);

                                System.out.print("Enter a choice:");
                                int commonChoice =input.nextInt();
                                  switch(commonChoice){
                                    case 1 ->  System.out.print("Delivery");
                                    case 2 ->  System.out.print("Reply via same center");
                                    case 3 ->  System.out.print("Delivery"); 
                                  }
                            }
                        }                         
                    }             
                                
                    
                    case 8 ->   System.out.print("Info Services");
                    case 9 ->   System.out.print("Voice mailbox");
                    case 10 ->   System.out.print("Service Command editor");
                }
            }

            case 3 ->   System.out.print("Chat");


            case 4 ->{
                  System.out.print("Call Register");
                String callRegister ="""
                    Press 1 For Missed calls
                    Press 2 For Recieved calls
                    Press 3 For Dialled numbers
                    Press 4 For Erase recent calls list 
                    Press 5 For Show call duration
                    Press 6 For Show call cost
                    Press 7 For Call cost settings
                    Press 8 For Prepaid credit
                """;
                  System.out.print(callRegister);

                System.out.print("Enter a choice:");
                int callRegisterChoice=input.nextInt();
                  switch (callRegisterChoice){
                    case 1->  System.out.print("Missed calls");
                    case 2->  System.out.print("Received calls");
                    case 3->  System.out.print("Dialled numbers");
                    case 4->  System.out.print("Erase recent calls list");
                    case 5->{
                          System.out.print("Show call duration");
                        String showCallDuration ="""
                            Press 1 For Last call duration
                            Press 2 For All calls duration
                            Press 3 For Recieved calls duration
                            Press 4 For Dialled calls duration
                            Press 5 For Clear timers
                            """;
                          System.out.print(showCallDuration);

                        System.out.print("Enter a choice:");
                        int showCallDurationChoice=input.nextInt();
                        switch(showCallDurationChoice){
                            case 1->  System.out.print("Last call duration");
                            case 2->  System.out.print("All calls duration");
                            case 3->  System.out.print("Recieved calls duration");
                            case 4->  System.out.print("Dialled calls duration");
                            case 5->  System.out.print("Clear timers");
                        }
                    }


                    case 6->{
                          System.out.print("Show call cost");
                        String showAllCost ="""
                            Press 1 For Last call cost
                            Press 2 For All calls cost
                            Press 3 For Clear counters
                            """;
                          System.out.print(showAllCost);

                        System.out.print("Enter a choice:");
                        int showAllCallCostChoice=input.nextInt();
                          switch(showAllCallCostChoice){
                            case 1->  System.out.print("Last call cost");
                            case 2->  System.out.print("All calls cost");                         
                            case 3->  System.out.print("Clear counters");
                        }
                    }

                    
                    case 7->  System.out.print("Call cost settings");
                    case 8->  System.out.print("Prepaid credit");
                }
            }

            case 5 ->{
                  System.out.print("Tones");
                String tones ="""
                    Press 1 For Ringing Tone                
                    Press 2 For Ringing volume 
                    Press 3 For Incoming call alert
                    Press 4 For Composer
                    Press 5 For Message alert tone
                    Press 6 For Keypad Tones
                    Press 7 For Warning and game tones
                    Press 8 For Vibrating tones
                    Press 9 For Screen saver
                    """;
                  System.out.print(tones);

                System.out.print("Enter a choice:");
                int tonesChoice=input.nextInt();
                  switch(tonesChoice){
                    case 1->  System.out.print("Ringing Tone");
                    case 2->  System.out.print("Ringing volume");                          
                    case 3->  System.out.print("Incoming call alert");
                    case 4->  System.out.print("Composer");
                    case 5->  System.out.print("Message alert tone");                          
                    case 6->  System.out.print("Keypad Tones");
                    case 7->  System.out.print("Warning and game tones");
                    case 8->  System.out.print("Vibrating tones");
                    case 9->  System.out.print("Screen saver");
            }
                }
            case 6 -> {
                System.out.println("Settings");
                // ... settings submenu code here ...
            }

            case 7 -> System.out.println("Call divert");
            case 8 -> System.out.println("Games");
            case 9 -> System.out.println("Calculator");
            case 10 -> System.out.println("Reminders");

            case 11 -> {
                System.out.println("Clock");
                String clock = """
                    Press 1 For Alarm clock
                    Press 2 For Clock settings
                    Press 3 For Date settings
                    Press 4 For Stopwatch
                    Press 5 For Countdown timer
                    Press 6 For Auto update of date and time
                    """;
                System.out.println(clock);

                System.out.print("Enter a choice: ");
                int clockChoice = input.nextInt();

                switch (clockChoice) {
                    case 1 -> System.out.println("Alarm clock");
                    case 2 -> System.out.println("Clock settings");
                    case 3 -> System.out.println("Date Settings");
                    case 4 -> System.out.println("Stopwatch");
                    case 5 -> System.out.println("Countdown timer");
                    case 6 -> System.out.println("Auto update of date and time");
                }
            }

            case 12 -> System.out.println("Profile");
            case 13 -> System.out.println("SIM services");
            default -> System.out.println("Invalid choice!");
        }
    }
}




