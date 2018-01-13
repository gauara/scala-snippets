package sorting.geeksforgeeks

object SortDates extends App {
/*
  case class Date(dd: Int, mm: Int, yyyy: Int) {
    def checkYear(d2: Date): Option[Date] = if (this.yyyy <= d2.yyyy) Some(this) else None
    def checkMonth(d2: Date): Option[Date] = if (this.mm <= d2.mm) Some(this) else None
    def checkDate(d2: Date): Option[Date] = if (this.dd <= d2.dd) Some(this) else None
  }


//  def checkYear(d1: Date, d2: Date): Option[Date] = if (d1.yyyy < d2.yyyy) Some(d1) else None
//  def checkMonth(d1: Date, d2: Date): Option[Date] = if (d1.mm < d2.mm) Some(d1) else None
//  def checkDate(d1: Date, d2: Date): Option[Date] = if (d1.dd < d2.dd) Some(d1) else None



  def datesComparator(date1: Date, date2: Date): Boolean = {
    //checkYear(date1, date2).map(checkMonth(_, date2)).map(checkDate(_, date2))

    //val result = date1.checkYear(date2).flatMap(_.checkMonth(date2).flatMap(_.checkDate(date2)))

    //date1.checkMonth()

    println(s"d1: $date1 d2: $date2 result: ${result.isDefined}")
    result.isDefined
  }

  def sortDates(arr: Array[Date]): Array[Date]=  {
    // NOTE -- sorting is not mutating the array and hence store result in result

    val sorted = arr.sortWith(datesComparator(_, _))

    sorted.foreach(d => println(s"Date: ${d.dd} Month: ${d.mm} Year: ${d.yyyy}"))
    sorted
  }

  val dates = Array(
    Date(20, 1, 2014),
    Date(25, 3, 2010),
    Date(3, 12, 2000),
    Date(18, 11, 2001),
    Date(19, 4, 2015),
    Date(9, 7, 2005)
  )

  sortDates(dates)
*/
}
