package language.designpatterns

//Exhibiting Diamond Problem

// We know what will be used and hence less ambiguity

trait A {
  def hello() = println("hello from A")
}

trait B extends A {
  override def hello() = println("hello from B")
}

trait C extends A {
  override def hello() = println("hello from C")
}

trait D extends B with C { // uses hello from C

}

trait D1 extends C with B { // uses hello from B -

}



object Diamond extends D {
  def print() = println(hello())
}

object Diamond1 extends D1 {
  def print() = println(hello())
}


object TraitsLinearization extends App {
  Diamond.print()
  Diamond1.print()
}