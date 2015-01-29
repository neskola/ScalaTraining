package fi.data
import java.util.Date
import java.text.SimpleDateFormat

class WorkShift(person : String, personId : String, shiftDate : String, shiftStart : String, shiftEnd: String) {
  def p() = person
  def pId() = personId
  def sDate() = {
    val dFormat = new SimpleDateFormat("dd.MM.yyyy")
    dFormat.parse(shiftDate)   
  }
  def sStartHour() = shiftStart.split(":")(0).toInt
  def sStartMinute() = shiftStart.split(":")(1).toInt
  def sEndHour() = shiftEnd.split(":")(0).toInt
  def sEndMinute() = shiftEnd.split(":")(1).toInt
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
    
    if (eHelper >= 18 || eHelper <=6) {
      if (eHelper <=6) 
        eHelper += 24
    }
  }

  
  
  def regularPay = {
    (sTotalTicks * 3.75) / 4 
  }
  
  def eveningPay = {
    
  }
  
  override def toString() = 
    "" + p + " id = " + pId + " Date " + sDate + " shift " + shift + " ticks " + sTotalTicks + " regPay " + regularPay
}