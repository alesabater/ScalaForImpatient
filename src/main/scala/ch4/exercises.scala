package ch4

import java.io.File
import java.util.Scanner

import scala.collection.SortedMap

/**
 * Created by alesabater on 1/1/2016.
 */
object exercises {

  def printMap[T,B](m:Map[T,B]):Unit = {
    println((for((k,v)<-m) yield s"$k <- $v").mkString(", "))
  }

  def printMap[T,B](m:scala.collection.Map[T,B]):Unit = {
    println((for((k,v)<-m) yield s"$k <- $v").mkString(", "))
  }

  def countWordsInFileMutable(f:String): scala.collection.mutable.Map[String,Int] = {
    val in = new Scanner(new File(f))
    val m:scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map[String, Int]()
    while(in.hasNext){
      val s = in.next()
      m(s) = m.getOrElse(s,0) + 1
    }
    m
  }

  def countWordsInFileInmutable(f:String): Map[String,Int] = {
    val in = new Scanner(new File(f))
    var m:Map[String, Int] = Map[String, Int]()
    while(in.hasNext){
      val s = in.next()
      m = m + (s -> (m.getOrElse(s,0) + 1))
    }
    m
  }

  def linkedHashM() = {
    val linkepMap = scala.collection.mutable.LinkedHashMap("Monday" -> java.util.Calendar.MONDAY,
      "Tuesday" -> java.util.Calendar.TUESDAY,
      "Wednesday" -> java.util.Calendar.WEDNESDAY,
      "Thursday" -> java.util.Calendar.THURSDAY,
      "Friday" -> java.util.Calendar.FRIDAY,
      "Saturday" -> java.util.Calendar.SATURDAY,
      "Sunday" -> java.util.Calendar.SUNDAY
    )
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props = propertiesAsScalaMap(System.getProperties())
    val maxkey = props.keySet.map(_.length).max
    for( (k,v) <- props ) printf("%-" + 50 + "s | %s\n", k, v)
  }

  def main(args: Array[String]): Unit = {

    println("1st Exercise")
    val gizmos: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val gizmos2 = for((key,value) <- gizmos) yield (key,value*0.9)
    printMap(gizmos)
    printMap(gizmos2)
    val gizmos3 = countWordsInFileMutable("C:\\Users\\alesabater\\IdeaProjects\\ScalaForTheImpatient\\src\\main\\scala\\ch4\\File.txt")
    printMap(gizmos3)
    println(gizmos3.values.toArray.sortWith(_>_).mkString(", "))
    val gizmos4 = countWordsInFileInmutable("C:\\Users\\alesabater\\IdeaProjects\\ScalaForTheImpatient\\src\\main\\scala\\ch4\\File.txt")
    printMap(gizmos4)
    println(gizmos4.values.toArray.sortWith(_>_).mkString(", "))
    linkedHashM()
    print((gizmos.zip(gizmos2)).mkString(", "))



  }
}

