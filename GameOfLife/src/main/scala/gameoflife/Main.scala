package gameoflife

import scala.io.StdIn
import gameoflife.Grid

object Main {


  def main(args: Array[String]): Unit = {

    println("Please enter the number of alive cells")
    val aliveCells = StdIn.readInt()
    val aliveCellCoordinates = Array.ofDim[Int](aliveCells,2)

    for(i<-0 until aliveCellCoordinates.length)
      {
        val aliveCellCoordinatesString=StdIn.readLine().split(" ")
        aliveCellCoordinates(i)(0)=aliveCellCoordinatesString(0).toInt
        aliveCellCoordinates(i)(1)=aliveCellCoordinatesString(1).toInt
      }

    val transposedCoordinates = aliveCellCoordinates.transpose
    val columns = transposedCoordinates(0).max
    val rows = transposedCoordinates(1).max

    val grid = new Grid(rows,columns)
    grid.fillGrid(aliveCellCoordinates)
    println("[Info] : Grid is shown with padding of two cells on all directions")
    println("Current State :")
    println(grid.formatGrid())
    var newCoordinates= grid.transitionOnGrid()
    println("Transitioned State: ")
    println(grid.formatGrid())
    newCoordinates.foreach(println)

  }

}