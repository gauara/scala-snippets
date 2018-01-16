package oopdesign.callcenter



class Call(rank: Rank) {
  private var handler: Employee = _
  def setHandler(handler:Employee) = { this.handler = handler }

}
