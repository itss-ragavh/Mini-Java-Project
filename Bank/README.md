# Banking Application

## Overview
This is a simple Java-based banking application that allows users to perform banking operations such as creating a new account, depositing money, withdrawing money, checking balance, and viewing account details.

## Features
```
- New User Registration: Users can create a new bank account by providing necessary details.
- Deposit Money: Allows users to deposit money into their account.
- Withdraw Money: Enables users to withdraw money from their account after verifying their PIN.
- Check Balance: Users can check their current balance after PIN verification.
- View Account Details: Displays the details of the user’s bank account.
- Account Management: Provides access to all banking operations in a single interface.
```

## Technologies Used
```
- Java (Core Java, JDBC for database connectivity)
- MySQL (Database for storing account details)
```

## Prerequisites
Ensure you have the following installed:
```
- Java Development Kit (JDK) 8 or later
- MySQL Database
```

## Setup Instructions
```
1. Clone the Repository
   git clone https://github.com/your-username/your-repository.git
   cd your-repository

2. Set Up Database
   - Create a database named `bankk` in MySQL.
   - Create a table `bankk` with columns: `acc_no`, `acc_name`, `phone_no`, `balance`, `email`, `pin`, `bank_name`.
   - Update the database connection details (URL, username, and password) in `BankFeatures.java`.

3. Compile and Run
   javac -d . bankk.java BankFeatures.java BankingApplication.java
   java bank.BankingApplication
```

## Project Structure
```
/BankingApplication
│── src/
│   ├── bank/
│   │   ├── bankk.java           # Model class for account details
│   │   ├── BankFeatures.java    # Contains banking operations (withdraw, deposit, etc.)
│   │   ├── BankingApplication.java  # Main class to run the application
│── Database/
|   │──database_setup.sql        # MySQL table creation script
│── README.md                    # Project description & setup guide
```

## Usage
```
1. Run the application.
2. Choose an option:
   - 1 to create a new user account.
   - 2 to manage an existing account (withdraw, deposit, check balance, view details).
   - 3 to exit.
```

## Future Enhancements
```
- Implement GUI for better user experience.
- Add transaction history.
- Introduce multi-user authentication.
```

## License
```
This project is licensed under the MIT License.
```

## Contact Information
```
- **Name:** Harish Ragavendra
- **Email:** harishragavendra2305@gmail.com
- **LinkedIn:** www.linkedin.com/in/harishragavendra23
- **GitHub:** https://github.com/itss-ragavh
```
