Jersey - Scala Example
====

####Examples implemented:

* Basic configuration. Can be seen in the `JerseyConfig`
* Use of `ContainerResponseFilter`. Can be seen in `CORSFilter`. Purpose of this class is the handle CORS
* Use of `ContextResolver`. Configures Jackson's `ObjectMapper`
* Use of HK2 (Jersey's DI implementation). Configuration can be seen in `AppBinder` in the `JerseyConfig`. 
Use of injection can be seen in `scala.jersey.test.resource.TestResource`. Injection of `TestModelService`


####Issues:

* In `scala.jersey.test.JerseyConfig` I used `register(new AppBinder, classOf(AbstractBinder])`
which gives a warning as `AbstractBinder` is not a supported contract class. But if
I get rid of the second argument and try to use `ResourceConfig`'s `register(Object)`, 
I get a compile error, because of the overloaded varargs parameter
* Can't figure out how to get the Jackson Scala module to work for `case` classes. I need
to explicitly define getters.

####Todo:

This is just an example to get things up and running. I will refactor this example to 
be a real app. Still deciding what I want to do.

####Run:

* Make sure you have Maven. 
* Make sure you have cURL (not required... yet :-)
* `mvn package`
* `mvn jetty:run`
* From another command line `curl -v http://localhost:8080/api/test/model`