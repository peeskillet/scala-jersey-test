/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scala.jersey.test

import org.glassfish.hk2.api._
import org.glassfish.hk2.utilities._
import org.glassfish.hk2.utilities.binding._
import org.glassfish.jersey.server.ResourceConfig

import javax.inject._
import javax.ws.rs.ApplicationPath

import scala.jersey.test.service._

@ApplicationPath("/api")
class JerseyConfig extends ResourceConfig {
  
  /**
   *    All subpackages will be scanned for `@Provider` and `@Path`
   *    annotated classes, to register with the application
   */
  packages("scala.jersey.test")
  
  /**
   *    Not sure about this. It raises a warning that the
   *    contract type is not supported. But if I leave out
   *    the argument, the `register` method won't compile as
   *    the varargs parameter leads to ambiguity with Scala
   */
  register(new AppBinder(), classOf[AbstractBinder])
  
  class AppBinder extends AbstractBinder {
    override def configure() {
      println("====== Configuring Binder ======")
      /*
       *    Bind `TestModelServiceImpl` to `TestModelService` contract
       *    See injection in `scala.jersey.test.resource.TestResource`
       */
      bind(classOf[TestModelServiceImpl]).to(classOf[TestModelService]).in(classOf[Singleton])
    }
  }
}
