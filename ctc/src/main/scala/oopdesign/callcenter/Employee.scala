package oopdesign.callcenter

class Address

abstract class Employee(
  val name: String,
  val address: Address
                       )
{

  // WONT compile - abstract member may not have private modifier
  // private var rank: Rank
  // use protected instead

  protected val rank: Rank // abstract - need to be overridden

  // assign default values
  private var currentCall: Call = _

  // if not initialized  will need to be overridden in derived class
  private var free: Boolean = _

  // concrete implementation
  def available: Boolean = free

  // receive the call
  // if free, receive call and set the incoming call to the current call

  def receive(call: Call): Unit = {
    currentCall = call
    free = false
  }

  def gerRank = rank

}

class Respondent(name: String, address: Address) extends Employee(name: String, address: Address) {
  override val rank: Rank = RankRespondent
}

class Manager(name: String, address: Address) extends Employee(name: String, address: Address) {
  override val rank: Rank = RankManager
}

class Director(name: String, address: Address) extends Employee(name: String, address: Address) {
  override val rank: Rank = RankDirector
}