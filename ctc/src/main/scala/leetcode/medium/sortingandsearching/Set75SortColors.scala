package leetcode.medium.sortingandsearching

object Set75SortColors extends App {




  def sortColors(nums: Array[Int]): Unit = {

    var low = 0
    var mid = 0
    var hi = nums.length-1

    var temp: Int = 0
    while (mid <= hi) {
      nums(mid) match {
        case 0  =>
          temp = nums(low)
          nums(low) = nums(mid)
          nums(mid) = temp
          low += 1
          mid += 1
        case 1  =>
          mid += 1
        case 2  =>
          temp = nums(hi)
          nums(hi) = nums(mid)
          nums(mid) = temp
          //mid += 1
          hi -= 1
        case _ =>
      }
    }

    println(s"Sorted Array: ${nums.mkString(",")}")
  }

  sortColors(Array(2,0,2,1,1,0))
  sortColors(Array(2, 0 ,1))
  sortColors(Array(0 ,2, 1))
  sortColors(Array(0 ,2))

}
