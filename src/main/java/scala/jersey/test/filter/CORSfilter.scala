/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scala.jersey.test.filter

import javax.ws.rs.ext._
import javax.ws.rs.container._

@Provider
class CORSfilter extends ContainerResponseFilter {

  override def filter(request: ContainerRequestContext, response: ContainerResponseContext): Unit = {
    response.getHeaders.putSingle("Access-Control-Allow-Origin", "*")
    response.getHeaders.putSingle("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
    response.getHeaders.putSingle("Access-Control-Allow-Credentials", "true")
    response.getHeaders.putSingle("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
  }
}
