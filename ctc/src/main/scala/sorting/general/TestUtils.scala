package sorting.general

import sorting.utils.SortingUtils

object TestUtils extends App {
  val result = SortingUtils.mergeSortedArrays(Array(1, 5, 12, 24), Array(2, 15, 18, 27))
  result.foreach(x => print(x + " "))
}
