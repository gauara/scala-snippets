package sorting.geeksforgeeks

import scala.collection.mutable

//NOTE -- SCALA PriorityQueue is not of fixed size
// ITS A mutable data structure

object MergeKSortedArrays extends App {

   def mergeKSortedArrays(arrays: Array[Array[Int]]): Array[Int] = {
     // this assumes all arrays are of length K

     val k = arrays.length
     val n = arrays(0).length

     for(i <- 0 to arrays.length-1) {
       if (arrays(i).length != n) {
         println("Arrays must be of equal length")
         return Array(-1)
       }
     }

     case class Item(
                      array: Array[Int],
                      arrayElement: Int,
                      index: Int
                    ) {
       override def toString: String = this.arrayElement.toString
     }

     val finalArray = new Array[Int](k*n)
     var finalArrayNextIndex = 0
     var minHeap = mutable.PriorityQueue.empty(Ordering.by[Item, Int](_.arrayElement).reverse)

     // add first K elements to build the Heap
     for (i <- 0 to k-1) {
       val d = Item(
         array = arrays(i),
         arrayElement = arrays(i)(0),
         index = 0
       )
       minHeap.+=(d)
     }

     println("minheap after first insert: " + minHeap)

     // now just extract the min and keep iterating until current and eventually all
     // arrays get exhausted

     while (finalArrayNextIndex <= n*k - 1) {
       println(minHeap)
       val d = minHeap.dequeue()

       println(s"Removed Item : ${d.arrayElement} and idnex : ${d.index}")

       // lets copy this item to the final array
       finalArray(finalArrayNextIndex) = d.arrayElement
       finalArrayNextIndex += 1

       val nextItem = if (d.index + 1 <= d.array.length-1) {
         Item(
           array = d.array,
           arrayElement = d.array(d.index+1),
           index = d.index + 1  // not reached end so push the next item from this array
         )
       } else {
         Item(
           array = d.array,
           arrayElement = Int.MaxValue,
           index = Int.MaxValue // if reached array end - just push some max Int
         )
       }

       // append the next Item
       minHeap.+=(nextItem)
     }
     println("The final sorted array is : ")
     finalArray.foreach(println)
     finalArray
   }

  val kSortedArrays = Array(
    Array(1, 3, 5, 7),
    Array(2, 4, 6, 8),
    Array(0, 9, 10, 11)
  )

  mergeKSortedArrays(kSortedArrays)
}
