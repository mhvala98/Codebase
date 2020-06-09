package gameoflife

import scala.io.StdIn
import gameoflife.Grid

object Main {


  def main(args: Array[String]): Unit = {

    println("Please enter the number of alive cells")
    val aliveCells = StdIn.readInt()

    val aliveCellCoordinates=
      for(i<-0 until aliveCells)
      yield {
        val inputCoordinates=StdIn.readLine().split(" ").map(str=>str.toInt)
        (inputCoordinates(0),inputCoordinates(1))
      }

    println("Input Done")
    val columns = aliveCellCoordinates.maxBy(_._1)._1
    val rows = aliveCellCoordinates.maxBy(_._2)._2

    val grid = new Grid(rows,columns)
    grid.fillGrid(aliveCellCoordinates.toList)
    println("[Info] : Grid is shown with padding of two cells on all directions")
    println("Current State :")
    println(grid.formatGrid())
    var newCoordinates= grid.transitionOnGrid(aliveCellCoordinates.toList)
    println("Transitioned State: ")
    grid.fillGrid(newCoordinates)
    println(grid.formatGrid())
    newCoordinates.foreach(print)

  }

}