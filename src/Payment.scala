import java.nio.file.{Paths, Files}
import fi.parser.csvLineParser
import fi.data.WorkShift
import fi.data.workShiftHandler

object payment {
  
    
  def main(args: Array[String]) {
    val file = "./HourList201403.csv";
    assert(Files.exists(Paths.get(file)), "File not found!")
    csvLineParser.parse(file, workShiftHandler.handleWorkShift)
    println(workShiftHandler.list)
  }
}