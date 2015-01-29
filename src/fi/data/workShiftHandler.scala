package fi.data

object workShiftHandler {
  
  var employees:scala.collection.mutable.Map[Int, Employee] = scala.collection.mutable.Map()
  
  def handleWorkShift(ws : WorkShift) {    
    
    if (employees.contains(ws.pId)) {
      var employee = employees.get(ws.pId).get
      employee.addWorkShift(ws)      
    } else {
      var employee = new Employee(ws.p, ws.pId)
      employee.addWorkShift(ws)      
      employees(ws.pId) = employee
    }
  }
  
  def list = employees
}