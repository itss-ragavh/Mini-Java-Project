# Library Management System

## Description
The Library Management System is a Java-based project that enables users to manage library operations efficiently. With this program, users can:
- Add books (including details like book ID, title, and author).
- Issue books to users.
- Return books to the library.
- Display a list of all available books along with their status.

This project demonstrates the use of core Java concepts like:
- Object-Oriented Programming (OOP)
- Exception Handling
- Collections (HashMap)
- Input Handling

## Features
1. **Add Book**: Add a new book to the library with a unique ID, title, and author.
2. **Issue Book**: Mark a book as issued, preventing it from being issued again until returned.
3. **Return Book**: Mark a previously issued book as returned, making it available again.
4. **Display Books**: View all books in the library, including their status (issued or available).

## Technologies Used
- **Programming Language**: Java
- **Data Structures**: HashMap for managing books
- **Exception Handling**: To ensure smooth user interaction and handle errors like duplicate IDs or invalid operations

## How to Run
1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone this repository or download the source code.
3. Compile the code using the command:
   ```
   javac LibraryManagementSystem.java
   ```
4. Run the program using the command:
   ```
   java LibraryManagementSystem
   ```
5. Follow the on-screen menu to interact with the system.

## Sample Input/Output
### Example: Adding a Book
```
Enter Book ID: 101
Enter Book Title: The Great Gatsby
Enter Book Author: F. Scott Fitzgerald
Book added successfully.
```

### Example: Issuing a Book
```
Enter Book ID to issue: 101
Book issued successfully.
```

### Example: Displaying Books
```
Books in the library:
Book ID: 101, Title: The Great Gatsby, Author: F. Scott Fitzgerald, Issued: true
```

## Author
Harish Ragavendra.R
- Email: harishragavendra2305@gmail.com
- LinkedIn: www.linkedin.com/in/harishragavendra23


## Contributing
Contributions are welcome! If you'd like to contribute to this project, feel free to submit a pull request or raise an issue.

---
Thank you for exploring the Library Management System!

