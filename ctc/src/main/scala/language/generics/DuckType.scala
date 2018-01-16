package language.generics

object DuckType extends App {

  // WON't COMPILE

/*

  def callSpeak[A](obj: A): Unit = {
    obj.speak()
  }

*/

  // duck type - this ensure that calling class (A) must have a speak method
  def callSpeak[A <: { def speak(): Unit }] (obj: A): Unit = {
    obj.speak()
  }

  trait Animal
  class Dog extends Animal {def speak(): Unit = {println("Wufwuf")}}
  class Cat extends Animal {def speak(): Unit = {println("Meow")}}
  class Duck extends Animal {def speak(): Unit = {println("Quack")}}

  callSpeak(new Dog)
  callSpeak(new Cat)
  callSpeak(new Duck)



  // ANOTHER EXAMPLE DUCK TYPE

  def speak[A <: Animal](obj: A): Unit = {
    println(obj.getClass.toString)
  }


  speak(new Dog) // works
  speak(new Cat) // works

  class Human

  // WONT COMPILE - Human is not a subtype of Animal

  // error: speak(new Human)

}
