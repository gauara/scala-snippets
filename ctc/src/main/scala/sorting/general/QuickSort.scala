package sorting.general

import sorting.utils.SortingUtils

object QuickSort extends App {

  // STATUS - WORKING

  // THE IDEA is to fix the location of a pivot element such that
  // all elements before it are smaller and after are higher
  // recursively call to sort the array

  def quickSort[T <% Ordered[T]](arr: Array[T], low: Int, high: Int): Unit = {

    if (low < high) {
      val i = SortingUtils.findPivot(arr, low, high)
      quickSort(arr, low, i - 1)
      quickSort(arr, i + 1, high)
    }
  }

  def sortAndPrint(arr: Array[Int]): Unit = {
    val length = arr.length - 1
    quickSort(arr, 0, length)
    println("Sorted Array ")
    arr.foreach(x => print(x + " "))
    println()
  }

  sortAndPrint(Array(24, 17, 7, 8, 15, 3))
  sortAndPrint(Array(10, 8, 9, 7, 8, 15, 3))
  sortAndPrint(Array(24, 17, 23, 7979, 151, 0))
  sortAndPrint(Array(1, 2, 3, 4, 5, 6))
}
