package leetcode.hard.treesandgraphs

import scala.collection.mutable.ArrayBuffer


// https://leetcode.com/problems/course-schedule-ii/description/

object Set210CourseScheduleII extends App {

  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {

    // matrix(i)(j) is and u,v
    // where u -> v means
    // v is dependent course
    // u is prerequisite/ dependency
    // indegree(v) == 1
    // example
    // x -> z
    // y -> z
    // matrix(x)(z) == 1 and matrix(y)(z) == 1 and indegree(z) == 2
    // Note that it doesn't mean matrix(z)(x) == 1 or matrix(z)(y) == 1 since its directed graph
    // and actuallt matrix(i)(j) == 1 and matrix(j)(i) would be a cycle and hence answer false

    // no edge initially, we will build the edges and pre => main relation

    // BUILD EDGE MATRIX
    val matrix: Array[Array[Int]] = Array.tabulate(numCourses, numCourses)((_, _) => 0)
    val inDegree: Array[Int] = Array.fill(numCourses)(0)
    val result: Array[Int] = new Array(numCourses)

    for (i <- 0 to prerequisites.length -1) {
      val dependent = prerequisites(i)(0) // main or primary course
      val dependency = prerequisites(i)(1) // pre requisite a.k.a dependecy

      //if (prerequisites(dependent)(dependency) ==)
      inDegree(dependent) += 1
      matrix(dependency)(dependent) = 1
    }

    // Traverse with BFS

    val queue: scala.collection.mutable.Queue[Int] = scala.collection.mutable.Queue.empty[Int]

    for (i <- 0 to inDegree.length-1) {
      if (inDegree(i) == 0)
        queue.enqueue(i) // this node is a pre-requisite or dependency
    }

    // DO BFS TO travese
    var count = 0
    while (queue.nonEmpty) {
      //println("Hey There")
      val course: Int = queue.dequeue() // cant do dequeue on a Immutable queue
      result(count) = course
      //result.append(course)

      // mark this course done
      //println(s"Course Finished: $course")
      count += 1
      for (i <- 0 to numCourses-1) {
        if (matrix(course)(i) == 1) {
          inDegree(i) -= 1
          if (inDegree(i) == 0)
            queue.enqueue(i)
        }
      }
    }
    val allDone = count == numCourses
    println(s"Can all be done with $numCourses courses: $allDone and courses: ${result.mkString(",")}")

    if (allDone)
      result
    else
      Array.empty[Int] // cycle case -- cant be done

  }

/*
  findOrder(2,
    Array(
      Array(1, 0)
    ))

  findOrder(2,
    Array(
      Array(1, 0),
      Array(0, 1)
    ))

  findOrder(7,
    Array(
      Array(0, 2),
      Array(0, 1),
      Array(1, 2),
      Array(2, 3),
      Array(2, 6),
      Array(4, 1),
      Array(5, 1)
    ))*/

  findOrder(7,
    Array(
      Array(2, 0),
      Array(1, 0),
      Array(2, 1),
      Array(3, 2),
      Array(6, 2),
      Array(1, 4),
      Array(1, 5)
    ))

}
