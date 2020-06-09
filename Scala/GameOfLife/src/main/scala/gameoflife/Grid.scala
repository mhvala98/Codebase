package gameoflife

import scala.collection.mutable

class Grid(in_rows :Int, in_columns:Int) {

  private val grid = Array.fill[Char](in_rows+5,in_columns+5)('-')

  // This function will fill the grid according to provided coordinates in the array.
  // Alive cells are indicated with 'X' and dead cell are indicated with '-'.
  def fillGrid(list: List[(Int,Int)]): Unit =
  {
    for(tuple<-list) {
        grid(tuple._2+2)(tuple._1+2)='X'
      }
  }

  // This function will return the formatted string of grid to be printed.
  def formatGrid(): String = {
    var formattedGrid = List[String]()
    for (i <- 0 until grid.length) {
      formattedGrid = formattedGrid :+ grid(grid.length - i - 1).mkString(" ")
    }
    formattedGrid.mkString("\n")
  }

  private def clearRecentlyDiedCells(removedCellCoordinates: List[(Int,Int)]) = {
    for(cell<-removedCellCoordinates){
      grid(cell._1)(cell._2)='-'
    }

  }
  // This count the alive neighbors for the provided cell
  def countTheAliveNeighbors(xCoordinate:Int, yCoordinate:Int,cellCoordinates:List[(Int,Int)]): Int =
  {
    val neighborsArray = Array((-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)).map(x=>(x._1+xCoordinate,x._2+yCoordinate))
    val aliveNeighborCount =
      for(neighbor<-neighborsArray if cellCoordinates.contains(neighbor))
        yield neighbor
    aliveNeighborCount.length
  }

  // This function will do the one transition according to the rules of game of life from the current state.
  def transitionOnGrid(initialCellCoordinates:List[(Int,Int)]): List[(Int,Int)]= {
    val cellCoordinates =
      for(rows <- List.range (1,grid.length-1); columns <- List.range(1,grid(0).length-1))
        yield (rows,columns)
    val newCellCoordinates = mutable.ListBuffer[(Int,Int)]()
    val removedCellCoordinates = mutable.ListBuffer[(Int,Int)]()
      for(cell<-cellCoordinates) {
          val aliveNeighborCount = countTheAliveNeighbors(cell._1,cell._2,initialCellCoordinates.map(x=>(x._2+2,x._1+2)))
          if((aliveNeighborCount==2 || aliveNeighborCount==3) && grid(cell._1)(cell._2)=='X')
            newCellCoordinates.append((cell._1-2,cell._2-2))
          if((aliveNeighborCount==3) && grid(cell._1)(cell._2)=='-')
            newCellCoordinates.append((cell._1-2,cell._2-2))
          if((aliveNeighborCount<2 || aliveNeighborCount>3) && grid(cell._1)(cell._2)=='X')
            removedCellCoordinates.append((cell._1,cell._2))
      }
    removedCellCoordinates.toList.foreach(print)
    clearRecentlyDiedCells(removedCellCoordinates.toList)
    newCellCoordinates.toList.map(x=>(x._2,x._1))
  }

}
