const input = require("prompt-sync")

let passCounter =0
let failureCounter =0
let totalScore =0

for(let count =0; count <10; count +=1){
    let score =Number(input("Enter your score ==>"))
    if score >41{
        passCounter +=1
    }
    else{
        failureCounter +=1
    }
    totalScore +=score
}
console.log(passCounter +"students passed")

console.log(failureCounter +"students failed")

console.log("The Total Score is " + totalScore)

console.log("The average score is " + totalScore /10)
