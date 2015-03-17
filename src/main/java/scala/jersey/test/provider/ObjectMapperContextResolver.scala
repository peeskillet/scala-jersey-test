/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scala.jersey.test.provider

import javax.ws.rs.ext._
import com.fasterxml.jackson.databind._
import com.fasterxml.jackson.module.scala._
import com.fasterxml.jackson.module.paranamer._
import com.fasterxml.jackson.module.scala.experimental._

/**
 *    Still trying to figure out the `DefaultScalaModule`. Supposedly
 *    this should allow for support of serializing `case` classes, but
 *    it doesn't work. It doesn't serialize the fields. I still
 *    need to implement getters. Need to look into it
 */
@Provider
class ObjectMapperContextResolver extends ContextResolver[ObjectMapper]{

  val mapper: ObjectMapper = new ObjectMapper with ScalaObjectMapper
  mapper.configure(SerializationFeature.INDENT_OUTPUT, true)
  mapper.registerModule(new ParanamerModule)
  mapper.registerModule(new DefaultScalaModule)
  
  override def getContext(cls: Class[_]): ObjectMapper = mapper
}
