package language


//Note : trait do not allow constructors and hence do not have class parameters

// Won't compile
//trait Animal(name: String)

trait Animal {
  var name: String
  def getName: String
  def getNameUppercase: String // need concrete implementation
}

class Cat extends Animal {
  var name = "hello" // override is not necessary
  val getName = "Cat" // def to val is OK in function concrete implementation
  def getNameUppercase = name.toUpperCase
}

// wont allow to create same name class in scope
// Won't compile
//abstract class Animal(name: String)

abstract class Animal1


abstract class Animal2(name: String) {
  def getName = name
  def printName // abstract and extending class will need to implement it
  def getNameLength: Int

  //var foo  // wont compile - requires type
  var foo: Int // OK

}

// either be abstract or implement printName
//class Dog(name: String) extends Animal2(name: String)


class Dog(name: String) extends Animal2(name: String) {
  override def printName: Unit = println(super.getName)
  override def getName: String = ??? // rename to be implemented
  def getNameLength = name.size // override is not

  //val foo: Int = 10 // this is val so wont compile until we override foo as var

  //override var foo =  10 keyword override is optional
  var foo =  10
}

object OopsConcepts1 extends App {
  println("check is this code compiles")
}
