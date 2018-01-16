package language




class BaseClass

trait MyTrait
trait A extends BaseClass

// THIS MIX-IN IS ALLOWED since Derived class extends Base class
class DerivedClass extends BaseClass with MyTrait with A



// WON'T Compile - This MIX-IN is not allowed since NonDerived does not extend BaseClass
//class NonDerivedClass extends MyTrait with A // not extending BaseClass
// Error - its not a subclass BaseClass


object TraitsTipsTricks extends App {
  println("Checking trait stuff in scala")
}
