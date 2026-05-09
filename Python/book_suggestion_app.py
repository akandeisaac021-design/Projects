from book_suggestion_app_functions import *

books_in_storage =["the hobbit", "i-am-rhema", "roblox"]
lengths_of_books_in_storage =[47, 5, 100000]

print("Welcome to the Book Suggestion System!")

print(display_main_menu())

main_menu_choice =int(input("What would you like to do ==>"))

while (main_menu_choice >0 and main_menu_choice <101):
    match(main_menu_choice):
        case 1: 
            try_again ="yes"

            while (try_again.lower() =="yes"):

                book_index =generate_random_index_for_book_suggestion_with_pages_between_0_to_101(books_in_storage, lengths_of_books_in_storage)
                print ("Book for the day ==>", f"---->Book Title ==>{books_in_storage[book_index]}", sep ="\n")
                print (f"Page ==>{lengths_of_books_in_storage[book_index]}")

                try_again =input("Would you like to try again?(yes/no) ==>")

        case 2:
            new_book =input("Enter the name of the book to be added ==>")

            while (check_if_book_already_exists(books_in_storage, new_book) ==True):
                print("Error 419: Book already exists")
                new_book =input("Enter the name of the book to be added ==>")
            books_in_storage.append(new_book.lower())

            new_book_length =int(input("Enter the book length ==>"))
            lengths_of_books_in_storage.append(new_book_length)


        case 3:
            book_to_be_removed =input("Enter the book to be removed ==>")

            while (check_if_book_already_exists(books_in_storage, book_to_be_removed) ==True):
                print("Error 911: Book dosen\'t exist")
                book_to_be_removed =input("Enter the book to be removed ==>")

            index_of_book_to_be_removed =return_book_index_in_a_list(books_in_storage, book_to_be_removed)

            books_in_storage.remove(book_to_be_removed)
            lengths_of_books_in_storage.pop(index_of_book_to_be_removed)

            print(f"\"{book_to_be_removed}\" has been added sucesfully")

        case 4:
            book_to_be_updated =input("Enter the book to be removed ==>")

            while (check_if_book_already_exists(books_in_storage, book_to_be_updated) ==False):
                print("Error 911: Book dosen\'t exist")
                book_to_be_updated =input("Enter the book to be removed ==>")

            for index,book in enumerate(books_in_storage):
                if book_to_be_updated == book:
                    book_new_name =input("Enter a new book name ==>")
                    book_new_length =input("Enter the number of pages ==>")
                    books_in_storage.append(book_new_name)
                    lengths_of_books_in_storage.append(book_new_length)
                    break

        case 5:
            for index,book in enumerate(books_in_storage):  print(f"{index+1}. {book.title()}")

        case 6:
            print("Thanks for using the app")
            break

    print(display_main_menu())
    main_menu_choice =int(input("What would you like to do ==>"))
