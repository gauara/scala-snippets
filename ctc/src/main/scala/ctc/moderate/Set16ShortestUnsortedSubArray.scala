package ctc.moderate

object Set16ShortestUnsortedSubArray extends App {

  // return the start/end index of shortest unsorted array that
  // will make whole array sorted
  def subSort(arr: Array[Int]): (Int, Int) = {
    var i = 1
    var minValue = Int.MaxValue
    var maxValue = Int.MinValue

    // CORNER CASE - if array is already sorted - you cant initialize with
    // 0 and arr.length -- since you would return wrong default answer

    var minIndex = -1 // just placeholders in case if array is already sorted
    var maxIndex = -1

    while (i < arr.length) {
      if (arr(i) < arr(i-1)) { // a violation happened
        if (arr(i) < minValue) {
          minValue = arr(i)
        }
        if (arr(i-1) > maxValue) {
          maxValue = arr(i-1)
        }
      }
      i += 1
    }

    // start from beginning and find minValues actual position
    // start from end and find max Values actual position

    var loop = true
    i = 0
    while(i < arr.length && loop) {
      if (minValue < arr(i)) {
        minIndex = i
        loop = false
      }
      i += 1
    }

    loop = true
    i = arr.length-1

    while(i >= 0 && loop) {
      if (maxValue > arr(i)) {
        maxIndex = i
        loop = false
      }
      i -= 1
    }

    // if array is already sorted, then return (-1, -1)

    if (minIndex == -1 && maxIndex == -1) {
      return (-1, -1)
    }

    println(s"Minimum array indexes to be sorted: ${(minIndex, maxIndex)}")
    println(s"This is sub array from : ${(arr(minIndex), arr(maxIndex))}")
    (minIndex, maxIndex)


  }

  subSort(Array(2, 6, 4, 8, 10, 9, 15))
  subSort(Array(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19))
  subSort(Array(1, 2, 4, 7))
}
