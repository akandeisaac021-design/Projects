const prompt =require("prompt-sync")

let basePay =5000;
let amountPerParcel =0;
let counter =0;

while (counter <500){
    let successfulDeliveries =Number(prompt("Enter your successful deliveries: "));
    while (successfulDeliveries <0 || successfulDeliveries >100){
        successfulDeliveries =Number(prompt("Re-enter a valid number: "));
    }

    if(successfulDeliveries < 50){
        amountPerParcel =160;
    }

    else if(successfulDeliveries >=50 && successfulDeliveries <=59){
        amountPerParcel =200;
    }

    else if(successfulDeliveries >=60 && successfulDeliveries <=69){
        amountPerParcel =250;
    }

    else if(successfulDeliveries >=70){
        amountPerParcel =500;
    }

    let daysWage =successfulDeliveries * amountPerParcel + basePay;
    console.log("Today's wage is : " + daysWage);


    let reRun ="""
            Press 1 To Continue
            Press 2 To End
    """;
    console.log(reRun);
    let reRunOption =Number(prompt("Do you wish to contine ?"))


    while (reRunOption <1 || reRunOption >2){
        reRunOption =Number(prompt("Re-enter a valid value: ")); 
    }
        if(reRunOption ==1){
            console.log("Back To Sender");    }
        else if(reRunOption ==2){
            break;
        }    
        
}


    }
}
