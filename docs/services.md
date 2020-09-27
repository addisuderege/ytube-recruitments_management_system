# Service Layer

## Why Service Layer.

- Seperation of concern
- Delegating business logic to another layer
- Its kind adding one more layer of restriction to the hacker who wants to hack into your database.

## Steps to follow when creating the service layer
1) Creating the interface. So that we can have multiple implmentations of same set of acions if needed.
2) Adding **@Service** on you implementation Class.
3) Writing the business logic depending the actions you want to carry out.
4) We do same sort of action in all the services so its better to have some generic method defination. Create Generic Service and extend your basic service.
