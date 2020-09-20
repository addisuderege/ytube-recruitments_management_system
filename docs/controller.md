# Controllers

## Steps to follow when creating the controller layer
1) Adding **@RestController**
2) Providing the class level Mapping like **@RequestMapping**
3) Providing the support for different actions.
1 **C**reate the data (Save the data) => **@PostMapping**
2 **R**ead the data (Retrieving the data) => **#GetMapping**
3 **U**pdate the data (Adding or removing stuff from existing data) => **@PutMapping**
4 **D**elete the record => @Delete Mapping
4) Providing the Correct return type with correct Status code.
1 Using **ResponseEntity** as the return type.
2 Making use of correct **HTTP Status Code**. You can access the list of codes [here.](https://httpstatuses.com/)
5) Documenting the APIs. 