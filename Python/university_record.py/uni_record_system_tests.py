import unittest

class TestStudentSystem(unittest.TestCase):
    
    def setUp(self):
        global students
        students = {}

    def test_create_student(self):

        create_student("jdoe", "John", 20, ["MATHS"], "Lagos", "101")
        self.assertIn("jdoe", students)
        self.assertEqual(students["jdoe"]["name"], "John")
        self.assertEqual(len(students["jdoe"]["courses"]), 1)

    def test_add_valid_course(self):

        create_student("jdoe", "John", 20, ["MATHS"], "Lagos", "101")
        result = add_course("jdoe", "PHYSICS")
        self.assertEqual(result, "PHYSICS added successfully.")
        self.assertIn("PHYSICS", students["jdoe"]["courses"])

    def test_add_case_insensitivity(self):

        create_student("jdoe", "John", 20, [], "Lagos", "101")
        add_course("jdoe", "biology") # input lowercase
        self.assertIn("BIOLOGY", students["jdoe"]["courses"])

    def test_prevent_duplicate_course(self):

        create_student("jdoe", "John", 20, ["MATHS"], "Lagos", "101")
        result = add_course("jdoe", "MATHS")
        self.assertEqual(result, "Duplicate course.")

    def test_invalid_department_course(self):

        create_student("jdoe", "John", 20, [], "Lagos", "101")
        result = add_course("jdoe", "DANCING")
        self.assertEqual(result, "Course not offered by department.")

    def test_student_not_found(self):

        result = add_course("ghost_user", "MATHS")
        self.assertEqual(result, "Student not found.")

if __name__ == "__main__":
    unittest.main()
