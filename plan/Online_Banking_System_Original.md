# System Design | Online Banking System
Last Updated :
14 Feb, 2024
In the digital era, the layout of a Online Banking System is a critical element of any commercial enterprise, it not only affects user experience but also the growth of a service-providing company. This article explores the comprehensive guide to designing a Online Banking System for its efficient use. From practical and non-useful requirements to low-level and High-level design, we'll delve into each aspect with a focus on readability and effectiveness.

## Table of Content

- Functional Requirements
- Non-Functional Requirements
- Usecase Diagram
- Capacity Estimation
- Low-Level Design
- High-Level Design
- Database Design
- Microservices
## APIs Used in System Design of Online Banking System
- API Code Implementation
- Scalability
## Functional Requirements | System Design | Online Banking System
### User Registration

Allow users to create their accounts safely.
Collect important information for identification and communication.
### Payment Processing

Support various kinds of payment methods like credit cards, debit cards, digital wallets, and bank transfers.
Ensure stable and efficient processing of transactions.
### Transaction History

Maintain a complete document of user transactions.
Enable users to access and assessment their transaction history.
### User Authentication and Authorization

Implement a strong system for user authentication.
Ensure steady authorization to perform numerous operation within the system.
## Non-Functional Requirements | System Design | Online Banking System
### Response Time

Define perfect reaction times for specific operations.
Ensure quick and efficient device responsiveness.
### System Availability

Establish the desired level of machine uptime.
Implement redundancy and failover mechanisms to minimize downtime.
### Data Encryption Standards

Uses industry standards to protect sensitive information from any threat.
use best practices for stable data transmission and storage.
### Regulatory Compliance

Stay informed and observe if any new applicable enterprise rules.
Implement capabilities and practices to fulfill legal requirements.
## Usecase Diagram | System Design | Online Banking System
A use case diagram visually represents the system's functionality through actors (users, administrators) and their interactions with the system. It showcases various use cases consisting of account creation, payment initiation, and also access to the transaction history.

payment-system-design

In the above diagram:

To use the services provided by the bank, a customer must first create an account. For every new customer, the bank confirms the information and opens a new account. The online banking system's Add Account capability is Use-Case, and each customer is an actor in the Use-Case Diagram.
Every customer has the ability to view their account balance and request an account transfer across different Bank offices. A cashier is a bank employee that assists with customer service.
Customers can carry out cash transactions in which they must either take cash from their account or add cash value to their bank account. To properly complete one or more transactions, one of the two—credit or debit cash—or both may be used.
Customers may or may not choose to get details for further action following each successful transaction. To verify and validate information, the manager might examine the interest value for every account linked to the transaction.
A consumer may also apply for a loan at a bank, but they must include all necessary information in their loan request.
The consumer must specify the kind of loan that best suits their needs and goals, as well as the length of time they want to pay it back.
The management of each bank branch is free to reject loan requests based on terms and circumstances or to accept and approve the loan to start the procedure.
The bank keeps records for every employee, and the bank oversees every employee in every bank branch. Each branch manager is free to decide whether to give bonuses to staff members. Keep in mind that while all employees receive compensation as part of staff management, not all employees will receive bonuses or promotions.
## Capacity Estimation | System Design | Online Banking System
You can estimate the system capacity by analyzing certain data like traffic, number of transaction are executing , number of new user joining platform etc. By analyzing whole data we can further calculate the required storage capacity for whole year. Here is the simplified calculation given:

Traffic is 100million per month 



Traffic per second = 100,000,000/30*24*60*60
                                   = 38.50
Assumption: 30% of the traffic are new user registrations.
                       40% are using payment process.



TPS = 30+40 =70
Storage per second(100 KB/transaction)=  70*100 = 7000 KB/S = 7 MB/S
Storage required per year = 7*60*60*24*365 = 221 TB



## Low-Level Design | System Design | Online Banking System
LLD

Low-level design involves specification of various components and their involvement in System Design of Online Banking System. It includes:

### Payment Gateway
In the Low-Level Design (LLD), the Payment Gateway is established with a complete class hierarchy to facilitate the intricacies of payment processing. The magnificence includes techniques tailor-made for various components together with fee initiation, refund handling, and seamless integration with external payment processors. These strategies encapsulate middle transactional operations, dealing with validation, processing, and exceptions.

### Authentication Service
Within the Low-Level Design, the Authentication Service is delineated via a based magnificence hierarchy that manages user authentication techniques. This class encapsulates the logics for verifying person credentials and conducting authorization exams to envision get access permissions. The internal methods deal with the authentication process, validating user credentials towards saved data, and executing authorization check to decide consumer access to ranges.

### Transaction Processing Service
The Transaction Processing Service's magnificence structure is cautiously crafted to manage methods for processing transactions and updating user account balances. This class performs a pivotal function in making sure the consistency and integrity of financial records. Internal techniques are designed for efficient transaction validation, processing, and updating of user account balances.

### Database Interaction
In the Low-Level Design's database interplay segment, pattern SQL queries are meticulously crafted for crucial operations together with retrieving person statistics and updating transaction repute. These queries are optimized for performance and cling to best practices in database interactions.

## High-Level Design | System Design | Online Banking System
HLD

High-level design mainly focus on the overall architecture of the Online Banking System, defining the interaction among its major components. It includes

### System Architecture
The Online Banking System includes essential additives consisting of the User Interface, Payment Gateway, Database, Authentication Service, Notification Service, Transaction Processing Service, Fraud Detection Service, and Logging and Monitoring Service. Communication is secured thru HTTPS, and interaction amongst components is facilitated by means of way of RESTful APIs. Real-time updates are enabled thru Websockets.

The system is designed for scalability, using horizontal scaling to make certain excessive availability and deal with improved masses. Security measures encompass HTTPS for constant data transmission, encryption for sensitive statistics like credit card statistics, and tokenization for more desirable protection. Availability is maintained through load balancing for visitors distribution and redundancy mechanisms for immoderate availability.

### Data Flow
The payment process starts with a user-initiated pay request dispatched from the User Interface to the Payment Gateway. The Payment Gateway validates the request and forwards it to the Authentication Service, which verifies consumer credentials and performs important authorizations. Valid transactions proceed to the Transaction Processing Service, interacting with the Database to replace user account balances.

### Transaction Logging and Auditing
In the High-Level Design (HLD), an quintessential issue is the incorporation of a sturdy transaction logging and auditing device. This system ensures that each one essential activity inside the Online Banking System are recorded for later analysis, auditing, and debugging. The Logging and Monitoring Service performs a relevant position in to capturing and storing unique logs of transactions, user interactions, and system activities.

## Database Design | System Design | Online Banking System
For Online Banking System, the database design will rely upon the particular requirements and features you need to enforce. Below is detailed description for database design of Online Banking System.

### 1. User Table
User table store user data. It includes fields like:

user_id: Unique identifier for every user.
Username: User's username for public display.
Email_address: User's e mail for communication.
Password: Securely hashed user password.
Full_name: User's complete name.
Created_date: Registration date of the user.
### 2. Payment Method Table
Payment method table store information all regarding payment modes. It include fields like:

Payment_method_id: Unique identifier for every payment method id.
User_id: Foreign key linking to the User table.
Payment_type: Type of payment method (credit card, PayPal, etc.).
Card_number: Credit card number or account detail of user.
Expiration_date: Expiration date of the payment method used by user.
Is_default: Flag indicating if this is the user's default payment method.
### 3. Transaction Table
Transactional table store data transaction detail like when he executed payment, trasaction_id, mode of payment etc. It include field like:

Transaction_id: Unique identifier for each transaction.
User_id: Foreign key linking to the User table.
Payment_method_id: Foreign key linking to the Payment Method table.
Amount:  It store the amount of the transaction is executed by user.
Currency: The currency used in the transaction.
Status: The status of the transaction (pending, finished, failed, and many others.).
Timestamp: Date and time of the transaction.

### 4. Invoice Table
Invoice table consist of all the invoice details. It includes fields like:

Invoice_id:  It is Unique identifier means it uniquely identifies every invoice.
User_id: Foreign key linking to the User table.
Transaction_id: Foreign key linking to the Transaction table.
Invoice_number: It is unique number associated with every bill.
Due_date: Due date for the invoice.
Amount_due: The general amount due at the invoice.
Status: The status of the bill (unpaid, paid, late, and many others.).
### 5. Subscription Table
Subscription table consist of information of subscription detail of user. It include field like:

Subscription_id: Unique identifier for each subscription.
User_id: Foreign key linking to the User table.
Plan_name: Name of the subscription plan.
Amount: The price of the subscription.
Billing_cycle: The billing cycle of the subscription (month-to-month, every year, and so forth.).
Start_date: Start date of the subscription.
End_date: End date of the subscription.
### 6. Refund Table
Refund table include detail of refund transactions. It include fields like:

refund_id:  It is unique identifier for every refund.
Transaction_id: Foreign key linking to the Transaction table.
User_id: Foreign key linking to the User table.
Refund_amount: It provide data of how much amount is refunded.
Reason: Reason for the refund.
Status: The status of the refund (processed, pending, denied, and many others.)..
## Microservices | System Design | Online Banking System
Microservices structure is an approach to software development wherein a large utility is decomposed into small, independently deployable services. Each microservice is accountable for a selected business functionality and communicates with different microservices through nicely-described APIs. In a payment device, microservices may additionally consist of:

Payment Processing Microservice: Handles the core of processing payments, interacting with external payment gateways, and coping with transaction workflows.
User Authentication Microservice: Manages user authentication and authorization, making sure steady get access to the Online Banking System. It may combine with identity carriers or maintain consumer credentials securely.
Account Management Microservice: Manages consumer bills, profiles, and settings. This microservice handles obligations such as user registration, profile updates, and account verification.
Notification Microservice: Sends notifications to users about transaction confirmations, account activity, or protection alerts. It guarantees that timely communication is taking place with user.
## APIs Used in System Design of Online Banking System
APIs are interfaces that allow one-of-a-kind software program components to communicate with every different components. In a Online Banking System it also permits various APIs facilitate seamless integration between microservices, external services, and the user interface. Some additives of API are as comply with:

Payment Gateway API: This API allows communicate a number of the payment processing microservice and external payment gateways. This API is make sure payment is processed to right user.
User Authentication API: It allows user authentication microservice to interact with different additives. It verifies user credentials at the time when person login in his device and also validate that only authorize person have access to system.
Notification API: It Facilitates communication among the notification microservice and its exceptional components. This API ensures that clients receive notifications when they perform any transactions.
External Services Integration APIs: It allows integration with external servicee which consist of banks, credit card networks, and identity verification services. These APIs permit the Online Banking System to have interaction with external entities securely.
Internal Communication APIs: It Facilitates conversation between distinct microservices within the price tool. These APIs make certain that unique element can interact and percentage their records internally.
## API Code Implementation | System Design | Online Banking System
User Registration API (POST):
**Endpoint: /api/user/register**
**Description: It allows users to create their accounts securely.**
**Request:**

```json
  "username": "example_user",
  "email": "user@example.com",
  "password": "securepassword123"
}
```
**Response:**

```json
  "status": "success",
  "message": "User registration successful"
}
```
Payment Processing API (POST):
**Endpoint: /api/payment/process**
**Description: It help in Initiate payment processing using various kind of methods.**
**Request:**

```json
  "user_id": "12345",
  "amount": 50.00,
  "payment_method": "credit_card",
  "card_number": "**** **** **** 1234",
  "expiration_date": "MM/YYYY"
}
```
**Response:**

```json
  "status": "success",
  "message": "Payment processed successfully"
}
```
Transaction History API (GET):
**Endpoint: /api/transaction/history?user_id=12345**
**Description: It help in Retrieveing transaction history of user.**
**Request:**

GET /api/transaction/history?user_id=12345
Host: your-payment-system-api.com
Accept: application/json
**Response:**

{  "transactions": [
    { "transaction_id": "abc123",
      "amount": 30.00,
      "status": "finished",
     "timestamp": "2023-11-29T12:30:45Z"}, ]
}
Transaction Processing API (PUT):
**Endpoint: /api/transaction/update**
**Description: Updates transaction status (e.g., pending to finished).**
**Requests:**

```json
"transaction_id": "abc123"
 "new_status": "finished"
}
```
**Response:**

```json
  "status": "success",
  "message": "Transaction status updated"
}
```
## Scalability | System Design | Online Banking System
Scalability is important for handling multiple users and transaction volumes. Scalability include:

### Horizontal Scaling
Horizontal scaling includes including more servers or times to distribute the workload efficiently. In Online Banking System, this indicates increasing the number of servers to address a higher range of concurrent clients and transactions. By horizontally scaling, the device can preserve responsiveness throughout height intervals with out experiencing standard overall performance bottlenecks.

### Load Balancing
Implementing load balancing mechanisms is essential for various incoming requests gently during more than one servers. This guarantees that no single server is overload with traffic, optimizing useful resource usage and preventing a single point of failure. Load balancing is a crucial strategy for boosting tool reliability and responsiveness.

### Containerization
Containerization technologies, together with Docker, contribute to scalability with the useful resource of encapsulating utility components into packing containers. Containers offer consistency throughout exclusive environments, simplifying deployment and permitting efficient scaling. With containerization, the Online Banking Systemincome agility and the ability to scale specific additives independently.

### Microservices Architecture
Microservices make a contribution appreciably to scalability by way of allowing individual components to scale independently. Each microservice manages a specific commercial enterprise capability, and as demand increase for that specific characteristic, the corresponding microservice can be scaled independently without affecting the entire system. This modularity complements flexibility and responsiveness.

### Database Sharding
Database sharding involves horizontally partitioning information across a couple of database servers. This technique is in particular applicable for managing large datasets in Online Banking System. By dispensing the data across more than one servers, the system can effectively control and retrieve statistics, contributing to stepped forward usual performance and scalability.

## Conclusion
In conclusion, a well-designed Online Banking System can fulfill financial aspects of the organization. By using modular architecture, maintaining efficient database design, and providing clear communication through APIs can lead to foundation for successful digital payment ecosystem. It must be concluded here that you can System Design Online Banking System by considering all the discussed points in the article.
