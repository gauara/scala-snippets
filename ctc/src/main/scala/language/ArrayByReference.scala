package language

// STATUS - WORKING

// array elements will change - array is passed by reference here
// we pass test and content of test are changed in the function
// and is reflected outside of the function
object ArrayByReference extends App {

  def arrayReference(arr: Array[Int]): Array[Int] = {
    for (i <- 0 until(arr.length)) {
      arr(i) = arr(i) * 2
    }
    arr
  }

  val test = Array(1, 2, 3, 4, 5, 6)
  val result = arrayReference(test)
  result.foreach(println)
  println("***************")
  test.foreach(println)
}
