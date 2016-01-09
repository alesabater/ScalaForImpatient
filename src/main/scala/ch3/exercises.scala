package ch3

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/*
 * Created by alesabater on 12/26/2015.
 */
object exercises {

  def randomArrayWithSize(n: Int): Array[Int] = {
    val emptyArray = new Array[Int](n);
    for (i <- 0 until emptyArray.length) emptyArray(i) = Random.nextInt();
    emptyArray
  }

  def swapAdj(a: Array[Int]) = {
    for (i <- 0 until a.size)
      yield if (i % 2 == 0)
        if (i < a.size-1)
          a(i+1)
        else
          a(i)
      else a(i-1)
  }

  def swapPositiveNegatives(a: Array[Int]): Array[Int] = {
    val positives = a.filter(x => x >= 0)
    val negatives = a.filter(x => x < 0)
    positives ++ negatives
  }

  def avgOfArray(a: Array[Int]): Double = {
    a.sum/a.size
  }

  def reverseElements(a: Array[Int]): Array[Int] = {
    a.reverse
  }

  def eigthExercise(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val idx = for (i <- a.indices if a(i) < 0) yield i
    val idxWithoutLast = idx.reverse.dropRight(1)
    println(idxWithoutLast.mkString(", "))
    for (i <- idxWithoutLast.indices) a(i) = a(idxWithoutLast(i))
    a.trimEnd(a.length - idxWithoutLast.length)
    a
  }



  def main(args: Array[String]) {
    val randomArray = randomArrayWithSize(8)
    def prn(x: TraversableOnce[_]) = println(x.mkString("Array[" + x.getClass.getSimpleName + "] ==> ", " and ", ""))
    println("Initial Array")
    prn(randomArray)
    val positivesNegatives = swapPositiveNegatives(randomArray)
    println("Positives And Negatives")
    prn(positivesNegatives)
    println("Swap elements")
    val swapedArray = swapAdj(randomArray)
    prn(swapedArray)
    val avg = avgOfArray(randomArray.map(x =>  if(x<0) x*(-1) else x ))
    println("Average")
    println(avg)
    val arrayReversed = reverseElements(randomArray)
    println("Average")
    prn(arrayReversed.sortWith(_>_))
    println("8th Exercise")
    val a = ArrayBuffer(1,2,-3,-5,-7,9,10,-1)
    val lastExercise = eigthExercise(a)
    prn(lastExercise)
  }

}
