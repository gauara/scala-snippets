package com.example


import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

final case class User(
               id: Long,
               name: String
               )

final case class Trade(
                        id: Long,
                        typ: String,
                        user: User,
                        symbol: String,
                        shares: Long,
                        price: Double,
                        timestamp: String
                      )


final case class Trades(trades: Seq[Trade])


object TradeDeskActor {
  final case class ActionPerformed(description: String)
  final case object GetTrades
  final case class AddTrade(t: Trade)
  final case object Erase
  final case class GetUserTrades(userId: Long)

  def props: Props = Props[TradeDeskActor]


  def userFixture(id: Long): User = {
    User(
      id = id,
      name = ""
    )
  }


  def tradeFixture(id: Long) = {
    Trade(
      id = id,
      typ = "buy",
      user = userFixture(id),
      symbol = "SMBL",
      shares = 9,
      price = 1.01,
      timestamp = ""
    )
  }

}


// use concurrent objects here for thread safety

class TradeDeskActor extends Actor with ActorLogging {

  import TradeDeskActor._

  var trades = scala.collection.mutable.Set.empty[Trade]

  trades.+=(
    tradeFixture(1),
    tradeFixture(2),
    tradeFixture(3)
  )

  def receive: Receive = {
    case GetTrades =>
      sender() ! Trades(trades.toSeq)

    case AddTrade(t: Trade) =>
      trades.+=(t)
      sender() ! ActionPerformed(s"Trade with id ${t.id} and name ${t.symbol} added for user ${t.user.name}")

    case Erase =>
      val size = trades.size
      trades.clear()
      sender() ! ActionPerformed(s"Erased ${size} Trades")

    case GetUserTrades(userId) =>
      val t = trades.filter(_.user.id == userId).toSeq.sortBy(_.id)
      sender() ! Trades(t)
  }
}





/*
Sample JSON Trade object
{
   "id": 1,
   "type": "buy",
   "user": {
      "id": 1,
      "name": "David"
   },
   "symbol": "AC",
   "shares": 28,
   "price": 162.17,
   "timestamp": "2014-06-14 13:13:13"
}

 */