### Spring Boot REST Api Java Exercise

You have to develop a rest web service for an IUD (AKA CRUD) example application.

Our applications are built with Spring Boot, it would be a bonus if you make the exercise with this also.

Other optional and desirable features:
(Choose those which you feel comfortable with)

- [x] Java 11
- [x] HTTP verbs
- [x] Entity validation
- [x] Global exception handling
- [x] Custom HTTP error codes
- [x] Unit testing (UserController integration tests)
- [ ] Asynchronous Programming
- [x] Dependency Management (maven, gradle)
- [x] Connect it to a database (in memory _(h2 has been chosen)_ or localdb like mongoDB, elasticsearch)

#### Suggestions

Feel free to use any third library you like:

_I have used OpenApi 3.0 to define the API and autogenerate the spring boot initial structure_

Small files and semantic folder structure will be appreciated. Keeping the Single Responsibility of classes will make
you look extraordinary.

We like annotations if you are developing Java. We love dependency injection in any case.

We know is a very ~~stupid~~ simple app (it's an exercise), but work thinking it's the beginning of a larger project.
Some elements have no sense for the IUD requirement(separation in different namespaces/packages, etc) but it would be
great if anyone want to add the IUD for another entity.

We are very (VERY) strict with naming and
conventions ([the "other" hard problem](https://martinfowler.com/bliki/TwoHardThings.html)). There is no Good
Convention, just choose one and keep it coherent.

Publishing the work on GitHub will be a plus.

#### API

- Data format: **JSON**

#### User Model

``` Java
class User {
  Integer id; // database entity
  String name;
  Date birthdate;
}
```

#### Endpoints

Use url, verb, params and return param what do you consider appropriate.

- GET ALL :
  Get all users from database

- GET :
  Specify and user id to get an user

- CREATE :
  Create a new user

- UPDATE :
  Update an existing user

- REMOVE :
  Remove an existing user