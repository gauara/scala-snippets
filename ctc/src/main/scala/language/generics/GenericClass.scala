package language.generics


class LinkedList[A] {
  private class Node[A](item: A) {
    var next: Node[A] = _
    override def toString: String = item.toString
  }

  private var head: Node[A] = _

  def add(item: A) = {
    val node: Node[A] = new Node[A](item)
    node.next = head // on adding first node - null is set to it
    head = node
  }

  def printNodes = {
    var n = head
    while(n != null) {
      println(n) // the to string is overridden
      n = n.next
    }
  }

  // this is not a suited place but just for demonstration purposes
  // LinkedList is Invariant Type - so would not accept subclass in following method
  def exhibitInvariantCase(list: Seq[A]): Unit = {
    list.foreach(println)
  }

}

// example to create generic classes
object GenericClass extends App {

  val x = new LinkedList[Int]()
  x.add(1)
  x.add(2)
  x.add(3)
  x.add(4)

  x.printNodes

  val y = new LinkedList[String]()
  y.add("hello")
  y.add("motto")
  y.add("foobar")

  y.printNodes


  sealed trait Animal
  class Dog extends Animal {
    override def toString: String = "Dog"
  }

  class SuperDog extends Dog { override def toString: String = "Super Dog"}
  class FunnyDog extends Dog { override def toString: String = "Funny Dog"}

  val dogs = new LinkedList[Dog]
  dogs.add(new Dog)
  dogs.add(new SuperDog)
  dogs.add(new FunnyDog)

  dogs.printNodes


  // If there is a method that takes parent type then you can not pass subclass

  val s: Seq[Dog] = Seq(new Dog, new SuperDog, new FunnyDog)
  dogs.exhibitInvariantCase(s)


  // Important - This can take subclasses
  // -- InVariant --
  // -- Covariance --
  // -- Contravariant --


  def printDogTypes(dogs: LinkedList[Dog]) = {
    dogs.printNodes
  }

  val d = new LinkedList[Dog]()
  val d1 = new LinkedList[SuperDog]

  printDogTypes(d)

  // WONT COMPILE - since d1 is a subtype of Dog and method takes only Dog
  // FIx would be defined LinkedList as +A , since class linkedlist is an invariant type

  // error: - printDogTypes(d1)


}
