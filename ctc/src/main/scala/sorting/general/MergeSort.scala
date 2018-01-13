package sorting.general

object MergeSort extends App {


  def mergeAndSortArrays(lArray: Array[Int], rArray: Array[Int]): Array[Int] = {
    (lArray ++ rArray).sorted
  }

  def mergeSort(arr: Array[Int], low: Int, high: Int): Array[Int] = {
    if (low <= high) {

      if (low == high) return Array(arr(low))

      val mid = (low + high) / 2
      val l = mergeSort(arr, low, mid)
      val r = mergeSort(arr, mid + 1, high)
      mergeAndSortArrays(l, r)
    } else {
      arr
    }
  }


  def mergeSortAndPrint(arr: Array[Int]): Unit = {
    val length = arr.length - 1
    val result = mergeSort(arr, 0, length)
    println("Sorted Array ")
    result.foreach(x => print(x + " "))
    println()
  }

  mergeSortAndPrint(Array(24, 17, 7, 8, 15, 3))
  mergeSortAndPrint(Array(10, 8, 9, 7, 8, 15, 3))
  mergeSortAndPrint(Array(24, 17, 23, 7979, 151, 0))
  mergeSortAndPrint(Array(1, 2, 3, 4, 5, 6))


}
