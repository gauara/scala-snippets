package oopdesign.callcenter



sealed trait Rank

// Case class requires parameters and hence not allowed here
object RankRespondent extends Rank
object RankManager extends Rank
object RankDirector extends Rank

object Rank {

  def toInt(t: Rank): Int = t match {
    case RankRespondent => 1
    case RankManager => 2
    case RankDirector => 3
  }
}


