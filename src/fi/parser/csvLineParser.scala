package fi.parser

import scala.io.Source
import fi.data.WorkShift

object csvLineParser {

  val ColPersonName = 0
  val ColPersonId = 1
  val ColShiftDate = 2
  val ColShiftStart = 3
  val ColShiftEnd = 4
  
  def parse(file : String, callback : WorkShift => Unit) {
    val src = Source.fromFile(file)    
    for(line <- src.getLines().drop(1)) {
      val map = line.split(",")
      val ws = new WorkShift(map(ColPersonName), map(ColPersonId),  
          map(ColShiftDate), map(ColShiftStart), map(ColShiftEnd))
      callback(ws)
    }
  }

}