package ctc.recursionanddp

object CTC02_RobotInAGridPrintAllPaths extends App {
  // can move only right and down

  def robotInGridPrintAllPaths(matrix: Array[Array[Int]], path: Array[Int], r: Int, c: Int, rows: Int, cols: Int, pos: Int): Unit = {
    if (r < 0 || r > rows-1 || c < 0 || c > cols-1)
      return 0

    if(r == rows-1 && c == cols-1) {
      path(pos) = matrix(r)(c)
      println(path.mkString(" "))
      return
    }

    path(pos) = matrix(r)(c)
    robotInGridPrintAllPaths(matrix, path, r, c+1, rows, cols, pos+1)
    robotInGridPrintAllPaths(matrix, path, r+1, c, rows, cols, pos+1)
  }

  val matrix = Array(
    Array(1, 2, 3),
    Array(6, 5, 4),
    Array(7, 8, 9)
  )

  val path = new Array[Int](matrix.length + matrix(0).length - 1) // rows + cols -1 -- there is a common element
  robotInGridPrintAllPaths(matrix, path, 0, 0, matrix.length, matrix(0).length, 0)
}
