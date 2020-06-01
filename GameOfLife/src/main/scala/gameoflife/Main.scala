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
    val rows = transposedCoordinates(0).max
    val columns = transposedCoordinates(1).max

    val grid = new Grid(rows,columns)
    grid.fillGrid(aliveCellCoordinates)
    grid.displayGrid()

    println("******************")
    val newCoordinates= grid.transitionOnGrid()
    grid.displayGrid()
    newCoordinates.foreach(println)

  }

}