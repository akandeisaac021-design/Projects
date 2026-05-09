const pizza_menu = {
  "sapa size":   { slices: 4,  price: 2000 },
  "small money": { slices: 6,  price: 2400 },
  "big boys":    { slices: 8,  price: 3000 },
  "odogwu":      { slices: 12, price: 4200 },
};

function calculatePizzaOrder(numberOfGuests, pizzaType) {
  const pizza = pizza_menu[pizzaType.toLowerCase()];

  if (!pizza) {
    console.log("Invalid pizza type.");
    return null;
  }

  const boxes = Math.ceil(numberOfGuests / pizza.slices);
  const leftoverSlices = boxes * pizza.slices - numberOfGuests;
  const totalPrice = boxes * pizza.price;

  return { boxes, leftoverSlices, totalPrice };
}

function main() {
  console.log("\n Welcome to Iya Scambirah Pizza Joint, Ajegunle! ");
  console.log("─────────────────────────────────────────────────────");
  console.log("Pizza Menu:");
  console.log("  1. Sapa Size    – 4 slices  – ₦2,000/box");
  console.log("  2. Small Money  – 6 slices  – ₦2,400/box");
  console.log("  3. Big Boys     – 8 slices  – ₦3,000/box");
  console.log("  4. Odogwu       – 12 slices – ₦4,200/box");
  console.log("─────────────────────────────────────────────────────\n");

  const prompt = require('prompt-sync')();

  let guests = Number(prompt("Enter number of guests: "));
  let type = prompt("Enter pizza type (e.g. sapa size, small money, big boys, odogwu): ").toLowerCase();


  if (isNaN(guests) || guests <= 0) {
    console.log("Invalid number of guests.");
    return;
  }


  const result = calculatePizzaOrder(guests, type);

  if (!result) return; 

  console.log("\n─────────────────────────────────────────────────────");
  console.log(" ORDER SUMMARY");
  console.log("─────────────────────────────────────────────────────");
  console.log(` Number of boxes to buy  : ${result.boxes} box(es)`);
  console.log(` Leftover slices         : ${result.leftoverSlices} slice(s)`);
  console.log(` Total price             : ₦${result.totalPrice}`);
  console.log("─────────────────────────────────────────────────────\n");
}

main();
