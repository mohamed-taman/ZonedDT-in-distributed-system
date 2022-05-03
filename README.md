## Handling Timezone with Java in Distributed Systems
**FizzBus** is a transportation-like service developed as a spring boot-based project with _RESTful-based_ APIs for the client. 

_FizzBus_ service uses controllers connecting to business logic resides in services. 
Those services connect to the database through repositories to show how to implement **Zoned Date/Time** in distributed systems correctly—considering different users' timezones with _daylight-saving_ time (**DST**) when saving, updating, and searching data.

Simple Application showing zoned date-time based conversion concept, could be located here under this gist [International Meeting Application](https://gist.github.com/mohamed-taman/1cd8e8483c033eeaac536d91e15dcd81).