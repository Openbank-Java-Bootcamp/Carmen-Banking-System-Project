# Banking-System-Project

This banking system project is used to transfer money between accounts.
You can create an account holder and a Third-party. The admin user is used to log in and to create different accounts. There are four types of accounts: Checking account, 
student account, saving account and credit card account.
If the account holder is less than 24 years old an student account would be created, if not a checking account one will be. An account holder can also have a saving account
and a credit card one. There is a penalty fee for all account of 40$.
Account holders can also transfer money to any other account, the transfer should only be processed if the account has sufficient funds.

![Class Diagram](https://user-images.githubusercontent.com/63664372/169709266-2786393e-6f94-4eef-b0ac-4ee71b7e39aa.png)

This project is made with Java based framework SpringBoot and MYSQL data base.

## Models

### User model
 * AccountHolder
 * Admin
 * ThirdParty
 * Address

### Account model
 * CheckingAccount
 * CreditCard
 * Role
 * Savings
 * StudentChecking
 * Money


## The project have the following routes:

| Method | Endpoint                              |  
| ------ | --------------------------------------|  
| GET    | `/api/users`                          | 
| POST   | `/api/users`                          |                                    
| POST   | `/api/accountholders`                 |                                  
| GET    | `/api/accountholders/{id}`            |                                  
| PUT    | `/api/accountholders/{id}`            |                                   
| DELETE | `/api/accountholders/{id}`            |                                   
| POST   | `/api/checkingaccounts`               |                                   
| GET    | `/api/checkingaccounts/{id}`          |                                   
| PUT    | `/api/checkingaccounts/{id}`          |                                   
| DELETE | `/api/checkingaccounts/{id}`          |                                   
| PATCH  | `/api/checkingaccounts/{id}/transfer` | 
| POST   | `/api/thirdparty`                     |                                   
| GET    | `/api/thirdparty/{id}`                |                                   
| PUT    | `/api/thirdparty/{id}`                |                                   
| DELETE | `/api/thirdparty/{id}`                |


### Trello

https://trello.com/b/6MpmaNrU/banking-system
## Resources
Google, Shaun and Raymond were used as a resources.

