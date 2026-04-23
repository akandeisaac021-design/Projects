const input = require("prompt-sync")

let number =Number(input("Enter a number ==>"));

let factorial =1;

    for(let multiple =number;multiple >1;multiple){
        factorial *=multiple;
    }

console.log("The factorial of " + number + "is" + factorial)
