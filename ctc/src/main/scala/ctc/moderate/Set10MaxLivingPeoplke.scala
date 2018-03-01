package ctc.moderate

object Set10MaxLivingPeople extends App {

  def maxLivingPeopleYear(pairs: Seq[(Int, Int)], startYear: Int, endYear: Int): Int = {

    // we will decrease -1 next to death year so, to avoid array bound there is 1 extra slot
    // endYear - startYear + 2 = 100 - 1 + 2 = 101 = 1 extra location

    val population: Array[Int] = new Array(endYear - startYear + 2)

    pairs.foreach { p =>
      population(p._1 - startYear) += 1
      population(p._2 - startYear) -= 1
    }

    // NOTE -- after this all dead people have been already deducted
    // each slot presents alive people in that year in array
    // to get alive people in Nth year, add all alive people in previous year and add Nth year population

    var maxAliveYear = startYear
    var currentAlivePeople = 0
    var maxAlivePeople = 0

    for(i <- 0 to population.length - 1) {
      currentAlivePeople += population(i)
      if (currentAlivePeople > maxAlivePeople ) {
        maxAliveYear = i
        maxAlivePeople = currentAlivePeople
      }
    }

    println(s"Max Alive people: $maxAlivePeople, Max alive year : $maxAliveYear")

    maxAliveYear
  }

  maxLivingPeopleYear(
    Seq(
      (12, 15),
      (20, 90),
      (10, 98),
      (1, 72),
      (10, 98),
      (23, 82),
      (13, 98),
      (90, 98),
      (83, 99),
      (75, 94)
    ),
    1,
    100
  )


}
