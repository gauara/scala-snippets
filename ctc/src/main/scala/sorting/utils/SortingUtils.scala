package sorting.utils

object SortingUtils {

  // THE IDEA is to fix the location of a pivot element such that
  // all elements before it are smaller and after are higher
  // recursively call to sort the array
  def findPivot[T <% Ordered[T]](arr: Array[T], low: Int, high: Int): Int = {
    val pivot = arr(high)
    var i = low
    var j = low

    while(j < high) {
      if (arr(j) < pivot) {
        val temp = arr(j)
        arr(j) = arr(i)
        arr(i) = temp

        j = j + 1
        i = i + 1
      } else {
        j = j + 1
      }
    }
    arr(high) = arr(i)
    arr(i) = pivot

    //println(s"pivot element is $pivot and pivot index is $i")
    i // pivot index
  }

  def mergeSortedArrays(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val resultArray = new Array[Int](arr1.length + arr2.length)
    var i: Int = 0
    var j: Int = 0
    var k: Int = 0

    while (i < arr1.length && j < arr2.length) {
      if (arr1(i) <= arr2(j)) {
        resultArray(k) = arr1(i)
        i += 1
        k += 1
      } else {
        resultArray(k) = arr2(j)
        j += 1
        k += 1
      }
    }

    var (index, remainingArray) = if (i > j) (j, arr2) else (i, arr1)

    for (q <- k to(resultArray.length - 1)) {
      resultArray(q) = remainingArray(index)
      index += 1
    }
    resultArray
  }
}
















