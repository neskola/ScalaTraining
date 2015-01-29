package fi.data
import java.util.Date
import java.text.SimpleDateFormat

class WorkShift(person : String, personId : String, shiftDate : String, shiftStart : String, shiftEnd: String) {
  def p = person
  def pId = personId
  def sDate = {
    val dFormat = new SimpleDateFormat("dd.MM.yyyy")
    dFormat.parse(shiftDate)   
  }
  def sStartHour = shiftStart.split(":")(0).toInt
  def sStartMinute = shiftStart.split(":")(1).toInt
  def sEndHour = shiftEnd.split(":")(0).toInt
  def sEndMinute = shiftEnd.split(":")(1).toInt
  def shift = {
    sStartHour + ":" + sStartMinute + " - " + sEndHour + ":" + sEndMinute
  }
  def sTotalTicks = {
    var sHelper = sStartHour
    var eHelper = sEndHour
    
    if (sStartHour < 5)
      sHelper += 24
    if (sEndHour <= 6) {
      eHelper += 24
    }
          
    (((eHelper - sHelper) * 60) + (sEndMinute - sStartMinute)) / 15
  }
  def sEveningTicks = {
    var sHelper = sStartHour
    var eHelper = sEndHour
    
    if (sEndHour <= 6 && sStartHour < 6) 
      (((sEndHour - sStartHour) * 60) + (sEndMinute - sStartMinute)) / 15          
    else if (sEndHour >= 18 && sStartHour <= 18) 
      (((sEndHour - 18) * 60) + sEndMinute) / 15 
    else if (sEndHour >= 18 && sStartHour > 18) 
      (((sEndHour - sStartHour) * 60) + (sEndMinute - sStartMinute)) / 15
    else if (sEndHour <= 6 && sStartHour >= 18) 
      ((((sEndHour + 24)- sStartHour) * 60) + (sEndMinute - sStartMinute)) / 15
    else if (sEndHour <= 6 && sStartHour >= 6 && sStartHour < 18) 
      ((((sEndHour + 24)- 18) * 60) + (sEndMinute - sStartMinute)) / 15
    else if (sStartHour < 6) 
      (((6 - sStartHour) * 60) - sStartMinute) / 15
    else 
      0
  }
  
  def regularPay = {
    (sTotalTicks * 3.75) / 4 
  }
  
  def eveningPay = {
    (sEveningTicks * 1.15) / 4
  }
  
  override def toString() = 
    "" + p + " id = " + pId + " Date " + sDate + " shift " + shift + " ticks " + sTotalTicks + " eveningTicks " + sEveningTicks + 
    "\nRegularPay " + regularPay + " eveningPay " + eveningPay 
}