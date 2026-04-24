import random

low =1
high =100

number_of_guesses =0

random_number =random.randint(low, high)

    guessed_number =int(input(f"Enter a number between ({low} - {high}): ")

while (guessed_number !=number):
    if (guessed_number <random_number):
        print(f"{guessed_number} is too low")
    elif (guessed_number >random_number):
        print(f"{guessed_number} is too high")
    else:
        print(f"{guessed_number} is correct")
