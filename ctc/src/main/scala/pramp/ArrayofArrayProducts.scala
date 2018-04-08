package pramp

object ArrayofArrayProducts extends App {
  def arrayOfArrayProducts(arr: Array[Int]): Array[Int] = {

    if (arr.length <= 1)
      return arr

    val output: Array[Int] = new Array(arr.length)

    //    val left = new Array(arr.length)
    //    val right = new Array(arr.length)

    // right array
    output(arr.length-1) = 1

    for (i <- arr.length-2 to 0 by -1) {
      output(i) = output(i+1)*arr(i+1)
    }

    // ouput = [ 20 , 2, 1]

    // arr ==> which I want to use as my leftProduct
    // How to preserve the elements in original array


    // [8, 2, 4, 5, 6, 6, 8, ]
    // [23, 34, 35, 46, 56, 56]

    // i th => leftProductSoFar


    // arr = [4 2]

    // output  = [2 , 1]
    //

    //     pre = 4
    // arr = [1 2]

    // next = 2
    // arr(1) = 1 * 4
    // arr(1) = 4


    // arr = [ 1, 4] // left array
    // output  = [2 , 1]

    // [2,  4 * 1]

    // output = [2, 4]

    var pre = arr(0)
    arr(0) = 1 // I loose element at 0, which needs to be preserved
    var next = 0
    for (i <- 1 to arr.length-1) {
      next = arr(i)
      arr(i) = arr(i-1)*pre
      pre = next

      output(i) = arr(i)*output(i)
    }

    println(s"Answer is ${output.mkString(",")}")
    output
  }

  arrayOfArrayProducts(Array(8, 10, 2))
  arrayOfArrayProducts(Array(2, 7, 3, 4))
  arrayOfArrayProducts(Array(4, 2))

}
