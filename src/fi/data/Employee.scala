package fi.data

class Employee(person : String, personId : Int) {
  var workShifts:scala.collection.mutable.MutableList[WorkShift] = scala.collection.mutable.MutableList()
  def p = person
  def pId = personId
  def addWorkShift(ws : WorkShift) = workShifts+=ws      
  
  override def toString() = 
    "" + p + " id = " + pId + " total workshifts " + workShifts.length + 
    "\n" + workShifts
    
}