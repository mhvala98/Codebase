package gameoflife

class Grid(in_rows :Int, in_columns:Int) {

  private val rows = in_rows+3
  private val columns= in_columns+3
  private var grid = Array.fill[Char](in_columns+5,in_rows+5)('-')

  def fillGrid(array: Array[Array[Int]]): Unit =
  {
    for(i<-0 until array.length) {
        grid(array(i)(1)+2)(array(i)(0)+2)='X'
      }
  }

  def displayGrid(): Unit =
  {
    for(i<-0 until grid.length) {
        grid(grid.length-i-1).foreach(print)
        println();
      }
  }

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


  def transitionOnGrid(): Vector[Vector[Int]]=
  {
    var newAliveCellCoordinates = Vector[Vector[Int]]()
    var temporaryVector = Vector[Int]()
    val newGrid = Array.fill[Char](in_columns+5,in_rows+5)('-');
    for(i<-1 until grid.length-1) {
      for (j<-1 until grid(i).length-1) {
        var aliveNeighbors=countTheAliveNeighbors(i,j)
        if((aliveNeighbors<2 || aliveNeighbors>3) && grid(i)(j)=='X'){
          newGrid(i)(j)='-'
        }
        if((aliveNeighbors==2 || aliveNeighbors==3) && grid(i)(j)=='X'){
          temporaryVector:+i
          temporaryVector:+j
          newAliveCellCoordinates:+temporaryVector
          temporaryVector.empty
          newGrid(i)(j)='X'

        }
        if(aliveNeighbors==3 && grid(i)(j)=='-')
        {
          newGrid(i)(j)='X'
          temporaryVector:+i
          temporaryVector:+j
          newAliveCellCoordinates:+temporaryVector
          temporaryVector.empty
        }
      }
    }
    grid= newGrid
    newAliveCellCoordinates.
    return newAliveCellCoordinates
  }

}
