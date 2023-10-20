# REST API TESTING

This is a project to demostrate the various ways of testing a REST API.

## Types of Testing
1. Unit Testing
2. Integration Testing
3. Manual Testing
4. Automated testing

### Unit Testing
We write tests using a mocking framework like Mockito. This is useful to a quick sanity test since it is fast and we don't require any additional external dependencies like a DB connection.

### Integration Testing
Here, we use a test container to simulate a Database and we write tests using this as a datasource. Although it is significantly slow and costlier than unit testing, it is important to test our API endpoint by this way since it comes close to real world scenario.

### Manual Testing
Usually done by a dedicated Quality Assurance (QA) team. They hit the endpoint from a HTTP client like a browser or Postman.

### Automated Testing
We nowadays have specialized automation frameworks which can test various scenarios effortlessly with minimal intervention like RestAssured or Selenium. Having an Automated testing suite greatly improves the productivity of the whole team.

## Epilogue
I would like to thank my friend Vishwaja who motivated me to write a blog about Rest API testing and my company ThoughtWorks which encourages such activities besides work ;)