def display_main_menu():

    main_menu ="""
    1. Get Suggestion
    2. Add Book
    3. Remove Book
    4. Update Book
    5. Show All Books
    6. Exit
"""
    return main_menu

def get_a_random_index_for_book_suggestion(books_in_storage):
    import random

    random_index =random.randrange(0, len(books_in_storage))
    
    return random_index

def check_if_random_suggestion_has_pages_between_one_and_a_hundred(lengths_of_books_in_storage, random_book_index):

    amount_of_pages =lengths_of_books_in_storage[random_book_index]
    if amount_of_pages >0 and amount_of_pages <101: return True
    else:   return False

def generate_random_index_for_book_suggestion_with_pages_between_0_to_101(books_in_storage, lengths_of_books_in_storage):

        random_book_index =get_a_random_index_for_book_suggestion(books_in_storage)

        while (check_if_random_suggestion_has_pages_between_one_and_a_hundred(lengths_of_books_in_storage, random_book_index) ==False):
            random_book_index =get_a_random_index_for_book_suggestion(books_in_storage)
            check_if_random_suggestion_has_pages_between_one_and_a_hundred(lengths_of_books_in_storage, random_book_index)

        return  random_book_index

def check_if_book_already_exists(books_in_storage, new_book):

    for book in books_in_storage:
        if book == new_book.lower():    return True

    return False

def return_book_index_in_a_list(books_in_storage, book_to_be_removed):

    for index,book in enumerate(books_in_storage):
        if book.lower() ==book_to_be_removed:   return index
    return "missing"

if __name__ == "__main__":
    unittest.main()
    
