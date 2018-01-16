package oopdesign.callcenter

import scala.collection.mutable.ArrayBuffer


// singleton class




object CallCenter extends App {

  println("Booting up the call center")

  // 3 lists for 3 handler categories

  // ARRAY can not be expanded - so if size is not known use ARRAY BUFFER


  // Exception Types with different declarations

  // WITH FOLLOWING DECLARATION

  // 1. var queues: ArrayBuffer[ArrayBuffer[Employee]] = _ // set value null
  // 2. var queues = ArrayBuffer[ArrayBuffer[Employee]]() // creates an empty array of respective type

  // 1. queues(0) would be null pointer exception
  // 2. queues(0) would be Array IndexOutOfBounds exception

  // In short - you cant access with index if there is no element - even in left hand side assignment

  // NOTE -- https://stackoverflow.com/questions/37921478/setting-values-in-arraybuffer-by-index-in-scala

  /*
  Your ArrayBuffer is empty, so you cannot set an element at index i to a
  new String - index i is not a valid index if the ArrayBuffer is empty.
  First make sure the elements exist in the ArrayBuffer by adding them
   */


  var queues = ArrayBuffer[ArrayBuffer[Employee]]() // default value would be null
  val address = new Address()

  implicit class ArrayUtils(arr: Array[Employee]) {
    def toArrayBuffer =  {
      var a: ArrayBuffer[Employee] = ArrayBuffer.empty[Employee]
      arr.foreach(e => a = a :+ e)
      a
    }
  }

  val respondents = (0 to 2).toArray.map(i => new Respondent(i.toString + "_respondent", address).asInstanceOf[Employee]).toArrayBuffer
  val managers = (0 to 2).toArray.map(i => new Manager(i.toString + "_manager", address).asInstanceOf[Employee]).toArrayBuffer
  val directors = (0 to 2).toArray.map(i => new Director(i.toString + "_director", address).asInstanceOf[Employee]).toArrayBuffer

  println("Printing array " + queues)


  // Following will cause exceptions explained above

//  queues(0) = respondents
//  queues(1) = managers
//  queues(2) = directors

  queues = queues :+ respondents
  queues = queues :+ managers
  queues = queues :+ directors

  println("Printing all employees")
  //respondents.foreach(println)

  queues.foreach(q => q.foreach(e => println(s" ${e.name} => ${e.gerRank}")))

  println("Printing the respondents ")
  queues(0).foreach(println) // access using index is OK here now since we no there is data


  //def getCallHandler(call: Call): Employee = queues()

  println(Rank.toInt(RankDirector))

  def disPatchCall(call: Call): Unit = {

  }
}
