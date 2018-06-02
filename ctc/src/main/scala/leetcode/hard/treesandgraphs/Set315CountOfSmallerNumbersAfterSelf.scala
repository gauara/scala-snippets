package leetcode.hard.treesandgraphs

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

object Set315CountOfSmallerNumbersAfterSelf extends App {

  case class ValIdxPair(v: Int, idx: Int)

  def merge(arr1: Array[ValIdxPair], arr2: Array[ValIdxPair], countsWithSmaller: Array[Int]): Array[ValIdxPair] = {
    var i = 0
    var j = 0
    var k = 0

    val arr3 = new Array[ValIdxPair](arr1.length + arr2.length)
    while (i < arr1.length && j < arr2.length) {
     if (arr1(i).v <= arr2(j).v) {
       arr3(k) = arr1(i)
       //println(s"Length: ${countsWithSmaller.length} idx: ${arr1(i).idx}")
       countsWithSmaller(arr1(i).idx) += j
       k += 1
       i += 1
     } else {
       arr3(k) = arr2(j)
       k += 1
       j += 1
     }
    }

    while (i < arr1.length) {
      arr3(k) = arr1(i)
      //countsWithSmaller(arr1(i).idx) = arr1(i).idx + j-1
      countsWithSmaller(arr1(i).idx) += arr2.length
      k += 1
      i += 1
    }

    while (j < arr2.length) {
      arr3(k) = arr2(j)
      k += 1
      j += 1
    }
    arr3
  }


  def mergeSort(nums: Array[ValIdxPair], low: Int, high: Int, countsWithSmaller: Array[Int]): Array[ValIdxPair] = {
    if (low >= high) {
      return Array(nums(low))
    }
    val mid = (low + high)/2
    val larray = mergeSort(nums, low, mid, countsWithSmaller)
    val rarray = mergeSort(nums, mid+1, high, countsWithSmaller)
    merge(larray, rarray, countsWithSmaller: Array[Int])
  }


  def countSmaller(nums: Array[Int]): List[Int] = {

    if(nums.length < 1)
      return List.empty[Int]

    if(nums.length == 1)
      return List(0)

    val arr = nums.zipWithIndex.map(x => ValIdxPair(x._1, x._2))
    val countsWithSmaller =Array.fill[Int](nums.length)(0)

    val res = mergeSort(arr, 0, arr.length-1, countsWithSmaller)

    println(s"Sorted: ${res.mkString(",")}")
    println(s"Result: ${countsWithSmaller.mkString(",")}")
    countsWithSmaller.toList
  }

  countSmaller(Array(5,2,6,1))

}
