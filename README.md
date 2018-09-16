Similarity Finder API 

Similarity finder API finds similar words and frequency of a given keyword in a notebook entry.

## Installing the app
To run the app, please issue the following commands:
1. `./gradlew build`
1. `docker build -f Dockerfile -t similarity-finder .`
1. `docker run -p 8080:8080 similarity-finder`

## Swagger
http://localhost:8080/swagger-ui.html#/

## Contributing
Fork/create branch from master and open a pull request