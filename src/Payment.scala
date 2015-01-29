import java.nio.file.{Paths, Files}
import fi.parser.csvLineParser

object payment {
    
  def main(args: Array[String]) {
    val file = "./HourList201403.csv";
    assert(Files.exists(Paths.get(file)), "File not found!")
    csvLineParser.parse(file)
  }
}