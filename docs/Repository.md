# Repositories (DAO - Data Accessing Objects) Layer

## What are we Using?
- If we have plan to use any relational databases like **Oracle, MySql** then we would have gone for the hibernate. Most interestingly Spring provides the extended version of hibernate too which is called as **Spring Data JPA**. Along with that Spring provides the similar implementations for **MongoDB** as well, which is known as **Spring Starter Data Mongo**. We will be using the same in this whole course.

### Note:
 > There is concept called Repository in spring data jpa hence the name is repository layer. 
 > We will learn different type of methods from which we can get the data.
 > * Using the methods
 > * Using **@Query** annotation
 > * Using MongoTemplate

## Steps to follow when Repository Layer
1) Adding Support for mongo
> * Adding the mongo dependency.
2) Providing the connection details
>* We will make use of properties files and we will provide the host, port and database name there.
3) Writing Dedicated Interface and annotating that with **@MongoRepository**
4) will write some methods to communicate with database.
