/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scala.jersey.test.model

/**
 *    TODO: Still trying to get `@BeanBinding` to work (for Jackson serialization)
 *    In the meantime, simply used normal getters.
 *    
 *    Also attemted to register module `DefaultScalaModule` as seen in 
 *    https://github.com/FasterXML/jackson-module-scala but doesn't seem to work
 */
case class TestModel(var firstName: String, var lastName: String) {
  
  def getFirstName():String = firstName
  def getLastName(): String = lastName
  override def toString: String = return format("%s, %s, %d", firstName, lastName)
}
