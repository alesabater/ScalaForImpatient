package ch5

import java.awt.image.BandCombineOp

import scala.beans.BeanProperty

/**
 * Created by e-aosr on 04/01/2016.
 */
object Exercises {

  class Counter(private var value:Int) {
    def increment() = if(value<Int.MaxValue) value += 1
    def current = value
  }

  class Person(tmpAge:Int) {
    var age:Int = if(tmpAge>=0) tmpAge else 0
  }

  class BankAccount(private var balance: Double = 0) {
    def deposit(amt: Double) = balance += amt
    def withdraw(amt: Double) = balance -= amt
    def currentBalance = balance
  }

  class Time {
    private var hrs: Int = _
    private var min: Int = _
    private var segs: Int = _


    def this(hrs:Int, min:Int){
      this()
      this.hrs = if(hrs<=23 && hrs>=0) hrs else throw new IllegalArgumentException("The hour must be between 0 and 23")
      this.min = min
      this.segs = this.hrs*60 + this.min
    }

    def before(b: Time): Boolean = {
      if(this.segs>b.segs) false
      else true
    }
  }

  class Student(@BeanProperty var name:String, @BeanProperty var id:Long){

  }

  def main(args: Array[String]) {
    val counter = new Counter(Int.MaxValue-1)
    counter.increment()
    println(counter.current)
    counter.increment()
    println(counter.current)
    val account = new BankAccount(10)
    account.deposit(125.32)
    println(account.currentBalance)
    val student = new Student("ale",19)
    student.setId(10)
    println(student.getId)
    val p = new Person(2)
    val p1 = new Person(-5)
    println(p.age)
    println(p1.age)
  }

}
