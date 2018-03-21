package ctc.recursionanddp

object CTC02_RobotInAGridCountPaths extends App {

  // can move only right and down

  def robotInGridMaxPath(matrix: Array[Array[Int]], paths: Array[Array[Int]], r: Int, c: Int, rows: Int, cols: Int): Int = {
    if (r < 0 || r > rows-1 || c < 0 || c > cols-1)
      return 0

    if(paths(r)(c) > 0) return paths(r)(c)

    if(r == rows-1 && c == cols-1) return 1

    paths(r)(c) = robotInGridMaxPath(matrix, paths, r, c+1, rows, cols) + robotInGridMaxPath(matrix, paths, r+1, c, rows, cols)

    //if (r == 0 && c == 0)
      println(s"Max Path from r: $r and c: $c to [${rows-1},${cols-1}] is : ${paths(r)(c)}")
    paths(r)(c)
  }

  val matrix = Array(
    Array(0, 0, 0),
    Array(0, 0, 0),
    Array(0, 0, 0)
  )

  robotInGridMaxPath(matrix, matrix, 0, 0, matrix.length, matrix(0).length)

}
