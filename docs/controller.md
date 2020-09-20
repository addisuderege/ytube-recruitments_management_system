# Controllers

## Steps to follow when creating the controller layer
1) Adding **@RestController**
2) Providing the class level Mapping like **@RequestMapping**
3) Providing the support for different actions.
- **C**reate the data (Save the data) => **@PostMapping**
- **R**ead the data (Retrieving the data) => **@GetMapping**
- **U**pdate the data (Adding or removing stuff from existing data) => **@PutMapping**
- **D**elete the record => **@Delete Mapping**
4) Providing the Correct return type with correct Status code.
- Using **ResponseEntity** as the return type.
- Making use of correct **HTTP Status Code**. You can access the list of codes [here.](https://httpstatuses.com/)
5) Documenting the APIs. 
