import unittest

from book_suggestion_app_functions import *

class book_suggestion_app_functions_tests(unittest.TestCase):

    def test_that_display_main_menu_function_returns_main_menu(self):

        actual =display_main_menu()
        expected ="""
    1. Get Suggestion
    2. Add Book
    3. Remove Book
    4. Update Book
    5. Show All Books
    6. Exit
"""

        self.assertEqual(actual.strip(), expected.strip())

    def test_that_a_random_index_within_range_is_generated(self):
        books = ["the hobbit", "1984"]
        self.assertTrue(get_a_random_index_for_book_suggestion(books) <101)

    def test_check_pages_range(self):
        lengths = [1, 159]

        self.assertEqual(check_if_random_suggestion_has_pages_between_one_and_a_hundred(lengths, 0), True)
        self.assertEqual(check_if_random_suggestion_has_pages_between_one_and_a_hundred(lengths, 1), False)

    def test_check_if_book_already_exists(self):
        books = ["the hobbit", "1984"]
        self.assertEqual(check_if_book_already_exists(books, "the hobbit"), True)
        self.assertEqual(check_if_book_already_exists(books, "dracula"), False)

if __name__ == "__main__":
    unittest.main()
    
