package gameoflife

class Grid(in_rows :Int, in_columns:Int) {

  // Columns of the grids
  private val rows = in_rows+3
  //
  private val columns= in_columns+3
  private var grid = Array.fill[Char](in_rows+5,in_columns+5)('-')

  // This function will fill the grid according to provided coordinates in the array.
  // Alive cells are indicated with 'X' and dead cell are indicated with '-'.
  def fillGrid(array: Array[Array[Int]]): Unit =
  {
    for(i<-0 until array.length) {
        grid(array(i)(1)+2)(array(i)(0)+2)='X'
      }
  }

  // This function will return the formatted string of grid to be printed.
  def formatGrid(): String = {
    var formattedGrid = List[String]()
    for (i <- 0 until grid.length) {
      formattedGrid = formattedGrid :+ grid(grid.length - i - 1).mkString(" ")
    }
    return formattedGrid.mkString("\n")
  }

  // This count the alive neighbors for the provided cell
  def countTheAliveNeighbors(xCoordinate:Int, yCoordinate:Int): Int =
  {
    var count=0
    val rowConstants= Array(-1,-1,-1,0,0,1,1,1)
    val columnConstants= Array(-1,0,1,-1,1,-1,0,1)
    for(i<- 0 until 8) {
      if(grid(xCoordinate+rowConstants(i))(yCoordinate+columnConstants(i))=='X') {
        count += 1
      }
    }
    return count
  }

  // This function will do the one transition according to the rules of game of life from the current state.
  def transitionOnGrid(): List[(Int,Int)]= {
    var newAliveCellCoordinates : List[(Int,Int)] = List()
    var cnt=0
    val newGrid = Array.fill[Char](in_columns+5,in_rows+5)('-');
    for(i<-1 until grid.length-1) {
      for (j<-1 until grid(i).length-1) {
        var aliveNeighbors=countTheAliveNeighbors(i,j)
        if((aliveNeighbors<2 || aliveNeighbors>3) && grid(i)(j)=='X'){
          newGrid(i)(j)='-'
        }
        if((aliveNeighbors==2 || aliveNeighbors==3) && grid(i)(j)=='X'){
          newAliveCellCoordinates = newAliveCellCoordinates :+ (j-2,i-2)
          newGrid(i)(j)='X'
        }
        if(aliveNeighbors==3 && grid(i)(j)=='-')
        {
          newGrid(i)(j)='X'
          newAliveCellCoordinates = newAliveCellCoordinates :+ (j-2,i-2)
        }
      }
    }
    grid= newGrid
    return newAliveCellCoordinates
  }

}
