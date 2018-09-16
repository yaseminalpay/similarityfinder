Similarity Finder API 

Similarity finder API finds similar words and frequency of a given keyword in a notebook entry.

![Build Status](https://travis-ci.com/yaseminalpay/similarityfinder.svg?branch=master)


## Definition of Done
- An endpoint is implemented for getting similarities
- Unit tests are implemented
- Documentation is added
- Logging is added

## Building the app
To build the app, please issue the following command. This will also run the tests:

 `./gradlew build`
 
To only run the tests, please issue the following command:

 `./gradlew test`


## Installing the app
To run the app, please issue the following commands:
1. `docker build -f Dockerfile -t similarity-finder .`
1. `docker run -p 8080:8080 similarity-finder`

## Swagger
http://localhost:8080/swagger-ui.html#/

## Contributing
Fork/create branch from master and open a pull request
