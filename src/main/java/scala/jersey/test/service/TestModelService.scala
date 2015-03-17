/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scala.jersey.test.service

import scala.jersey.test.model._

abstract class TestModelService {
  def getModel(): TestModel
}
