def create_dictionary():
    students = {}

    return students

def create_dictionary_of_courses():

    department_courses = {
        "MATHS", "PHYSICS", "COMPUTER SCIENCE", "Biology", "Chemistry",
        "STATISTICS", "ENGLISH", "ECONOMICS", "HISTORY", "PHILOSOPHY",
        "SOCIOLOGY", "POLITICAL SCIENCE", "GEOGRAPHY", "PSYCHOLOGY", "ART",
        "MUSIC", "ENGINEERING", "LAW", "MEDICINE", "BUSINESS"
    }
    
    return department_courses

def create_student(username, name, age, courses, city, zip_code):

    students[username] = {
        "name": name,
        "age": age,
        "courses": set(courses),
        "address": {"city": city, "zip": zip_code}
    }

    return students

def display_student(username):
    return students.get(username, "Student not found")


def display_courses(username):
    return students[username]["courses"]


def display_zip(username):
    return students[username]["address"]["zip"]


def display_city(username):
    return students[username]["address"]["city"]


def add_course(username, course):
    if course in department_courses and course not in students[username]["courses"]:
        students[username]["courses"].add(course)
        return f"{course} added successfully."
    return "Invalid or duplicate course."


def remove_course(username, course):
    students[username]["courses"].discard(course)

def update_course(username, old_course, new_course):
    if old_course in students[username]["courses"]:
        students[username]["courses"].remove(old_course)
        add_course(username, new_course)


def update_student(username, name=None, age=None, city=None, zip_code=None):
    if name !=None: students[username]["name"] = name
    if age !=None: students[username]["age"] = age
    if city !=None: students[username]["address"]["city"] = city
    if zip_code !=None: students[username]["address"]["zip"] = zip_code


def total_students():
    return len(students)
