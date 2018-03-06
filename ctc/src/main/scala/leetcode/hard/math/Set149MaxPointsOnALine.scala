package leetcode.hard.math


// STATUS - LEETCODE ALLOWS DUP POINTS ??

case class Point(var _x: Int, var _y: Int)


object Set149MaxPointsOnALine extends App {

  def maxPoints(points: Array[Point]): Int = {
    // SlopePairs(
    //  y2-y1,
    //  x2 -x1
    // )

    if (points.length <= 2) {
      println(s"Result : ${points.length}")
      return points.length
    }

    case class Line(
                   slope: Double,
                   intercept: Double,
                   infiniteSlope: Boolean = false
                   )

    object Line {
      def apply(p1: Point, p2: Point): Line = {
        if (p1._x != p2._x) {
          val slope = (p2._y - p1._y).toDouble/(p2._x - p1._x).toDouble
          val intercept = (p2._y - slope*p2._x)
          Line(
            slope = slope,
            intercept = intercept
          )
        } else {
          Line(
            slope = 1d,
            intercept = p1._x,
            infiniteSlope = true
          )
        }
      }
    }

    case class SlopePairs(yDiff: Double, xDiff: Double)
    //var pointToLine: Map[Point, Line] = Map.empty
    var lineToPoints: Map[Line, Set[Point]] = Map.empty

    var lines: List[Line] = List.empty[Line]

    var lineCounts: Map[Line, Int] = Map.empty

    for (i <- 0 to points.length-1) {
      for (j <- i+1 to points.length-1) {
        val l = Line.apply(
          points(i),
          points(j)
        )
        lines = lines :+ l

        var lPoints = lineToPoints.getOrElse(l, Set.empty)
        lPoints = lPoints ++ Set(points(i), points(j))
        lineToPoints = lineToPoints + (l -> lPoints)
      }
    }


    val result = lineToPoints.map(l => l._2.size).max

    println(s"Lines:")
    lineToPoints.foreach(println)
    println(s" Result: $result")
    result
  }

  maxPoints(Array(Point(1, 2), Point(2, 3)))
  maxPoints(Array(Point(1, 2), Point(1, 2)))
  maxPoints(Array(Point(1, 2), Point(1, 3), Point(4, 5)))
  maxPoints(Array(Point(0, 0), Point(-1, -1), Point(2, 2)))


  val array = Array(
    (560, 248),
    (0, 16),
    (30, 250),
    (950, 187),
    (630, 277),
    (950, 187),
    (-212, -268),
    (-287, -222),
    (53, 37),
    (-280, -100),
    (-1, -14),
    (-5, 4),
    (-35, -387),
    (-95, 11),
    (-70, -13),
    (-700, -274),
    (-95, 11),
    (-2, -33),
    (3, 62),
    (-4, -47),
    (106, 98),
    (-7, -65),
    (-8, -71),
    (-8, -147),
    (5, 5),
    (-5, -90),
    (-420, -158),
    (-420, -158),
    (-350, -129),
    (-475, -53),
    (-4, -47),
    (-380, -37),
    (0, -24),
    (35, 299),
    (-8, -71),
    (-2, -6),
    (8, 25),
    (6, 13),
    (-106, -146),
    (53, 37),
    (-7, -128),
    (-5, -1),
    (-318, -390),
    (-15, -191),
    (-665, -85),
    (318, 342),
    (7, 138),
    (-570, -69),
    (-9, -4),
    (0, -9),
    (1, -7),
    (-51, 23),
    (4, 1),
    (-7, 5),
    (-280, -100),
    (700, 306),
    (0, -23),
    (-7, -4),
    (-246, -184),
    (350, 161),
    (-424, -512),
    (35, 299),
    (0, -24),
    (-140, -42),
    (-760, -101),
    (-9, -9),
    (140, 74),
    (-285, -21),
    (-350, -129),
    (-6, 9),
    (-630, -245),
    (700, 306),
    (1, -17),
    (0, 16),
    (-70, -13),
    (1, 24),
    (-328, -260),
    (-34, 26),
    (7, -5),
    (-371, -451),
    (-570, -69),
    (0, 27),
    (-7, -65),
    (-9, -166),
    (-475, -53),
    (-68, 20),
    (210, 103),
    (700, 306),
    (7, -6),
    (-3, -52),
    (-106, -146),
    (560, 248),
    (10, 6),
    (6, 119),
    (0, 2),
    (-41, 6),
    (7, 19),
    (30, 250)
  )

  def tupleToPoint(ar: Array[(Int, Int)]): Array[Point] = {
    ar.map { t =>
      Point(t._1, t._2)
    }
  }

  maxPoints(tupleToPoint(array))

}
