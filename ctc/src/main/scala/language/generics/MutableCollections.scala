package language.generics

import scala.collection.mutable.ArrayBuffer

/*

SCALA mutable collections - Elements of these collections can be mutated

Array, ArrayBuffer, ListBuffer

Definition - Defined as InVariant Types

class Array[T]
class ArrayBuffer[A]
class ListBuffer[A]


SCALA immutable collections - Elements of these collections can not be mutated

List, Vector, Sequence

Definition - Defined as CoVariant Types

class List[+T]
class Vector[+A]
class Seq[+A]


TIPS -
To define a collection whose elements can be mutated - use [A]
To define a collection whose elements can are immutable- use [+A]

 */

// Example to show - array element mutating at index 0 and Seq throwing error

/*
scala> val ar = Array(1, 2, 3)
ar: Array[Int] = Array(1, 2, 3)

scala> ar(0) = 5

scala> ar
res1: Array[Int] = Array(5, 2, 3)

scala> val s = Seq(1, 2, 3)
s: Seq[Int] = List(1, 2, 3)

scala> s(0)
res2: Int = 1

scala> s(0) = 5
<console>:13: error: value update is not a member of Seq[Int]
s(0) = 5
^

*/



class MutableCollections {
  sealed trait Animal
  class Dog extends Animal
  class Cat extends Animal

  def f(s: ArrayBuffer[Animal]): Unit = {
    s.foreach(println)
  }

  //val s: ArrayBuffer[Dog] = Seq(new Dog)

  // WONT compile
  // Since ArrayBuffer elements are mutable and hence there is risk that elements of s can be mutated and hence compiler error
  // ArrayBuffer is InVariant
  // compiler error:
  // f(s)


}
