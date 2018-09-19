package leetcode.medium.tressandgraphs

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Set721AccountsMerge extends App {


  def dfs(email: String, visited: mutable.Set[String], graph: mutable.Map[String, Set[String]], list: ListBuffer[String]): Unit = {

    val nodes = graph(email)
    nodes.foreach { e =>
      if (visited.add(e)) {
        list.append(e)
        dfs(e, visited, graph, list)
      }
    }
  }

  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {

    var graph = scala.collection.mutable.Map.empty[String, Set[String]] // node to its neighbours
    var emailToName = scala.collection.mutable.Map.empty[String, String]



    for {
      a <- accounts
    } yield {
      val name = a(0)
      for (i <- 1 to a.length-1) {
        emailToName.put(a(i), name)

        if (!graph.contains(a(i))) graph.put(a(i), Set.empty[String])

        if (i != 1) {
          graph.put(a(i), graph(a(i)) + a(i-1))
          graph.put(a(i-1), graph(a(i-1)) + a(i))
        }
      }
    }

    // DFS
    var res = ListBuffer.empty[List[String]]
    var visited = scala.collection.mutable.Set.empty[String]


    emailToName.keySet.foreach { e =>
      if (!visited.contains(e)) {
        visited.add(e)
        val list = ListBuffer.empty[String]
        list.append(e)
        dfs(e, visited, graph, list)
        res.append((emailToName(e) +: list).toList.sorted)
      }
    }



//    println(s"emailToName - $emailToName")
//    println(s"graph -- $graph")
//    List.empty[List[String]]
    println(s" Result: $res")
    res.toList
  }

  accountsMerge(
    List(
      List("John", "j1", "j2", "j3"),
      List("John", "j2", "j4", "j5"),
      List("Mary", "m1", "m2"),
    )
  )


}
