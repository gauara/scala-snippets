package datastructures

import scala.collection.mutable.ArrayBuffer

class Stack(
             var top: Int = -1,
             var stack: ArrayBuffer[Int] = ArrayBuffer.empty[Int]
           ) {
  def push(data: Int) = {
    this.stack.append(data)
    top = top + 1
  }

  def printStack()= {
    println("printing stack")
    if(this.top == -1) {
      println("Empty Stack")
    } else {
      for (i <- top to 0 by -1) {
        println(this.stack(i))
      }
    }
  }

  def clearStack() = this.top += -1 // need to reset the array buffer itself, just track stack top

  def pop(): Int = {
    if (this.top - 1 >= -1) {
      val data = this.stack(top)
      this.top -= 1
      data
    } else {
      -100000 // this is ugly
    }
  }

  def isEmpty() = this.stack == -1
}

object Stack extends App {

  val stack = new Stack()
  stack.push(1)
  stack.push(2)
  stack.push(5)
  stack.push(6)

  stack.printStack()

  stack.pop()
  stack.pop()

  stack.printStack()

  stack.pop()
  stack.pop()
  stack.pop()
  stack.pop()
  stack.pop()

  stack.printStack()
}