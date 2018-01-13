package language

// STATUS - WORKING

// NOTE - In scala if you can not pass primitive VAR arguments in functions
// If you want to pass arguments to function/method in pass by reference style it can be
// done only for non primitive objects like cases classes etc, its not possible for
// primitive data types like Int, Strings etc ( Boxing / Unboxing concept )

// Basically you can not use VAR keyword for method arguments


object ReferenceTest extends App {

  def passByReference(x: Int) = {
    println(x.hashCode())
  }

  val x = 5
  println(x.hashCode())
  passByReference(x)


  def passByReferenceList(x: Seq[Int]) = {
    x :+ 5
    println(x)
  }


  var s = Seq(1)
  s = s :+ 2
  println("s : " + s)
  passByReferenceList(s)
  println(s)


  class Test(var param : Int, var s: Seq[Int] = Seq.empty[Int])
  def passByReferenceObject(x: Test) = {
    x.param = x.param + 2
    x.s = x.s :+ 1
  }

  val obj = new Test(5)

  println(obj.param)
  println(obj.s)
  passByReferenceObject(obj)
  println(obj.param)
  obj.s = obj.s :+ 2
  println(obj.s)
}


