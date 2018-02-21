package ctc.moderate

object MinimumDifference extends App {

  // 1 3 15 11 2
  // 23 127 235 19 8

  // 1 2 3 11 15
  // 8 19 23 127 235
  def minDifference(array1: Array[Int], array2: Array[Int]): Int = {
    val arr1 = array1.sorted
    val arr2 = array2.sorted

    var i = 0
    var j = 0
    var p1 = 0
    var p2 = 0
    var diff = Int.MaxValue
    while (i < arr1.length-1 && j < arr2.length-1) {
      if(arr1(p1) >= arr2(p2)) {
        val localDiff = arr1(p1) - arr2(p2)
        if (localDiff < diff)
          diff = localDiff
        p2 += 1
        j += 1
      } else {
        val localDiff = arr2(p2) - arr1(p1)
        if (localDiff < diff)
          diff = localDiff
        p1 += 1
        i += 1
      }
    }

    println(s"Minimum diff is : $diff")
    diff
  }

  minDifference(Array(1, 3, 15, 11, 2), Array(23, 127, 235, 19 ,8))

}
