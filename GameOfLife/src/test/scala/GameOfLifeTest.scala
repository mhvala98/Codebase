import org.scalatest.FunSuite;
import gameoflife.Grid

class GameOfLifeTest extends FunSuite {

  test("transitionGridBlinkerPatternTest") {

    val cellCoordinates = List((1,0),(1,1),(1,2))
    val testGrid = new Grid(1,2)
    testGrid.fillGrid(cellCoordinates)
    val actualResult= testGrid.transitionOnGrid(cellCoordinates)
    val expectedResult = List((0,1),(1,1),(2,1))
    assert(expectedResult==actualResult)

  }

  test("transitionGridBlockPatternTest") {

    val cellCoordinates = List((1,1),(1,2),(2,1),(2,2))
    val testGrid = new Grid(2,2)
    testGrid.fillGrid(cellCoordinates)
    val actualResult= testGrid.transitionOnGrid(cellCoordinates)
    val expectedResult = List((1,1),(2,1),(1,2),(2,2))
    assert(expectedResult==actualResult)

  }

  test("transitionGridBoatPatternTest") {

    val cellCoordinates = List((0,1),(1,0),(2,1),(0,2),(1,2))
    val testGrid = new Grid(2,2)
    testGrid.fillGrid(cellCoordinates)
    val actualResult= testGrid.transitionOnGrid(cellCoordinates)
    val expectedResult = List((1,0),(0,1),(2,1),(0,2),(1,2))
    assert(expectedResult==actualResult)

  }

  test("transitionGridToadPatternTest") {

    val cellCoordinates = List((1,1),(1,2),(1,3),(2,2),(2,3),(2,4))
    val testGrid = new Grid(4,2)
    testGrid.fillGrid(cellCoordinates)
    val actualResult= testGrid.transitionOnGrid(cellCoordinates)
    val expectedResult = List((1,1),(2,1),(0,2),(3,3),(1,4),(2,4))
    assert(expectedResult==actualResult)

  }

  test("formatGridTest") {

    val cellCoordinates = List((0, 1), (1, 2))
    val testGrid = new Grid(2, 1)
    testGrid.fillGrid(cellCoordinates)
    val actualResult = testGrid.formatGrid()
    val expectedResult:String = "- - - - - -\n- - - - - -\n- - - X - -\n- - X - - -\n- - - - - -\n- - - - - -\n- - - - - -"
    assert(expectedResult==actualResult)
  }

  test("countTheAliveNeighborsTest"){

    val cellCoordinates = List((1,1),(1,2),(2,1),(2,2))
    val testGrid = new Grid(2,2)
    testGrid.fillGrid(cellCoordinates)
    assert(3==testGrid.countTheAliveNeighbors(3,3,cellCoordinates.map(x=>(x._2+2,x._1+2))))

  }
}
