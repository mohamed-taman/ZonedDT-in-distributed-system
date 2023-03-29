## Handling Timezone with Java in Distributed Systems

**FizzBus** is a transportation-like service developed as a spring boot-based project with _RESTful-based_ APIs for the client.

_FizzBus_ service uses controllers connecting to business logic residing in services.
Those services connect to the database through repositories to show how to correctly implement **Zoned Date/Time** in distributed systems—considering different users' timezones with _daylight-saving_ time (**DST**) when saving, updating, and searching data.

Simple Application showing the zoned date-time-based conversion concept could be located here under this gist [International Meeting Application](https://gist.github.com/mohamed-taman/1cd8e8483c033eeaac536d91e15dcd81).

### Running FizzBus Service

- Download and install the JDK 20 from [here](https://www.oracle.com/java/technologies/downloads/#java20).
- Check the Java version:

  ```bash
  [mtaman]:~ java -version
  openjdk version "20" 2023-03-21
  OpenJDK Runtime Environment (build 20+36-2344)
  OpenJDK 64-Bit Server VM (build 20+36-2344, mixed mode, sharing)
  ```

Now you are ready to clone the project a run it locally either within your favorite IDE (I am using an IntelliJ IDEA) or from the command line as the following:

1. Clone the project from this repository.
2. Go to the project root and run the following maven command (make sure that your environment is set to Java 18):
   ```bash
   [mtaman]:~ mvn spring-boot:run
   ```
3. Open it in your IDE, set project Java language to 20, and run the main app class `com.sxi.lab.fizzbus.FizzBusApplication`.
4. Finally, you can access its swagger documentation from this URL [http://localhost:8090/api/v1/fizz-bus/doc/index.html](http://localhost:8090/api/v1/fizz-bus/doc/index.html). Which will be used for testing the application.

<!--
### Related Articles

I have written 2 Java Magazine articles explaining this project and the general problems considering zoned Date-Time implementations.

1. **Part 1** - Handling Timezone with Java in Distributed Systems. _Correctly implementing Zoned Date/Time in distributed System with Java_.
2. **Part 2** - Handling Timezone with Java in Distributed Systems. _Implementing Zoned Date/Time in distributed FizzBus Service_.
-->