# Task-3-Library-mgmt-system
## objective
build a java based system to manage books and users using OOP concepts
## Key concept
- Abstraction: Classes like 'Book', 'User', 'Library'
- Encapsulation: Data and methods are grouped
- Polymorphism:(if extended): Could be user for staff vs student users
  ## Features:
- Add books and users
- Issue and return books
- View all books and status
## EXPLANATION
In class BOOK
id: unique ID for each book
title: name of the book
isIssued: tells if the book is already given to someone
issuedTo: stores the user who took the book
Constructor:
Sets the ID and title when a book is created
display():
Prints the book info and whether it's issued or not
Library class:
This class manages everything:
List of all books
List of all users
Book issuing and returning
Fields:
books: stores all Book objects
users: stores all User objects
sc: for taking user input
addBack(): Asks for book ID and title->creates book->adds it to list
addUser():Asks for UserId and name->creates user->adds to user list.
issueBook(): Ask for bookId and finds the book
Asks for user Id and finds the user
If the book is not Already issued, it assigns it to user
returnBook(): Asks for bookId
If it was issued,marks it as not issued
removes the user info
viewBooks(): print all books in system
findBook(int id) and findUser(int id): Searches through the list to find a bok or user by ID
## HOW TO USE WHICH OOPS CONCEPT
# Abstraction: Hides logic methods like issueBook()
# Encapsulation: Keeps book/User data and methods together
# Objects: Creates many book and user objects
# Classes: Book,User, Library organise the structure
