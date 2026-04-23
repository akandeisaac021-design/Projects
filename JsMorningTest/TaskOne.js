const input = require("prompt-sync")

let number =Number(input("Enter a number: "));

let factor =0;

    for(let count =1;count <101; count +=1){

        if(number % count ==0){
            factor +=1;
        }
        console.log(number + "*" + count + "==>" + number * count);
    }

    console.log(number + "has" + factor + " factors");
