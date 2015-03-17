/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scala.jersey.test.resource

import javax.ws.rs._
import javax.ws.rs.core._
import javax.inject._

import scala.jersey.test.service._
import scala.jersey.test.model._

@Path("/test")
class TestResource() {
  
  @Inject
  var service: TestModelService = null
  
  @GET
  def getTest(): Response = {
    Response.ok("Hello Test").build
  }
  
  @GET
  @Path("/model")
  @Produces(Array("application/json"))
  def getTestModel(): Response = {
    Response.ok(service.getModel).build
  }
}
