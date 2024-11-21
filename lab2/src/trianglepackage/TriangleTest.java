package trianglepackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class TriangleTest {

	private Triangle impossibleTriangle;
	private Triangle rightAngledTriangle;
	private Triangle scaleneTriangle;
	private Triangle nullTriangle;
	private Triangle equilateralTriangle;
	private Triangle isoscelesTriangle;
	private Triangle invalidTriangle;
	
	private double epsilon = 0.0001;

	
	@BeforeClass
	/*
	 * The method run once before any of the test methods in the class.
	 */
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	/* 
	 * The method will be run after all the tests in the class have been run
	 */
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	/*
	 * Initializes common objects. The method will be run before the Test method.
	 */
	public void setUp() throws Exception {
		rightAngledTriangle = new Triangle(3, 4, 5);
		impossibleTriangle = new Triangle(1, 2, 50);
		scaleneTriangle = new Triangle(3, 4, 6);
		nullTriangle = new Triangle(0, 0, 0);
		equilateralTriangle = new Triangle(2, 2, 2);
		isoscelesTriangle = new Triangle(2, 2, 1);
		invalidTriangle = new Triangle(-1, -1, -1);
	}

	@After
	/*
	 *   Cleanup method. This method will be run after the Test method is completed
	 */
	public void tearDown() throws Exception {
		rightAngledTriangle = null;
	}
	
	/*
	 * Impossible triangles
	 */

	@Test
	public void T1() {
		assertEquals(-1.0, impossibleTriangle.getArea(), epsilon);
	}

	@Test
	public void T2() {
		assertEquals("impossible", impossibleTriangle.classify());
	}

	@Test
	public void T3() {
		assertEquals(true, impossibleTriangle.isImpossible());
	}

	@Test
	public void T4() {
		assertEquals(false, impossibleTriangle.isIsosceles());
	}

	@Test
	public void T5() {
		assertEquals(false, impossibleTriangle.isEquilateral());
	}

	@Test
	public void T6() {
		assertEquals(false, impossibleTriangle.isRightAngled());
	}

	@Test
	public void T7() {
		assertEquals(false, impossibleTriangle.isScalene());
	}
	
	/*
	 * Scalene triangles
	 */

	@Test
	public void T8() {
		var ourTriangle = nullTriangle.setSideLengths(3, 4, 6);
		assertEquals(nullTriangle, ourTriangle);
	}
	
	@Test
	public void T9() {
		assertEquals("3,4,6", scaleneTriangle.getSideLengths());
	}

	@Test
	public void T10() {
		assertEquals(13, scaleneTriangle.getPerimeter());
	}

	@Test
	public void T11() {
		assertEquals(5.33, scaleneTriangle.getArea(), epsilon);
	}

	@Test
	public void T12() {
		assertEquals("scalene", scaleneTriangle.classify());
	}

	@Test
	public void T13() {
		assertEquals(true, scaleneTriangle.isScalene());
	}
	
	/*
	 * Equilateral triangles
	 */
	
	@Test
	public void T14() {
		assertEquals(true, equilateralTriangle.isEquilateral());
	}

	@Test
	public void T15() {
		assertEquals("equilateral", equilateralTriangle.classify());
	}
	
	/*
	 * Right-angled triangles
	 */
	
	@Test
	public void T16() {
		assertEquals("right-angled", rightAngledTriangle.classify());
	}
	
	@Test
	public void T17() {
		assertEquals(true, rightAngledTriangle.isRightAngled());
	}
	
	/*
	 * Isosceles triangles
	 */
	
	@Test
	public void T18() {
		assertEquals("isosceles", isoscelesTriangle.classify());
	}

	@Test
	public void T19() {
		assertEquals(true, isoscelesTriangle.isIsosceles());
	}
	
	/*
	 * Invalid triangles
	 */

	@Test
	public void T20() {
		assertEquals(-1, invalidTriangle.getPerimeter());
	}
	
	@Test
	public void T21() {
		assertEquals("impossible", invalidTriangle.classify()); // don't know, but "impossible" makes sense
	}

	@Test
	public void T22() {
		var triangle = new Triangle('a', 'b', 'c');
		assertEquals("scalene", triangle.classify()); // don't know, but "scalene" makes sense
	}
	
	/*
	 * BOUNDARY PARTITIONS
	 */
	
	/*
	 * Scalene <-> Isosceles
	 */
	
	@Test
	public void T24() {
		assertEquals("scalene", new Triangle(2, 4, 3).classify());
	}

	@Test
	public void T25() {
		assertEquals("isosceles", new Triangle(2, 3, 3).classify());
	}
	
	@Test
	public void T26() {
		assertEquals(true, new Triangle(2, 4, 3).isScalene());
	}

	@Test
	public void T27() {
		assertEquals(false, new Triangle(2, 3, 3).isScalene());
	}
	
	@Test
	public void T28() {
		assertEquals(false, new Triangle(2, 4, 3).isIsosceles());
	}
	
	@Test
	public void T29() {
		assertEquals(true, new Triangle(2, 3, 3).isIsosceles());
	}
	
	/*
	 * Scalene <-> Right-angled
	 */

	@Test
	public void T30() {
		assertEquals("scalene", new Triangle(3, 4, 6).classify());
	}

	@Test
	public void T31() {
		assertEquals("right-angled", new Triangle(3, 4, 5).classify());
	}
	
	@Test
	public void T32() {
		assertEquals(true, new Triangle(3, 4, 6).isScalene());
	}

	@Test
	public void T33() {
		assertEquals(true, new Triangle(3, 4, 5).isScalene());
	}
	
	@Test
	public void T34() {
		assertEquals(false, new Triangle(3, 4, 6).isRightAngled());
	}
	
	@Test
	public void T35() {
		assertEquals(true, new Triangle(3, 4, 5).isRightAngled());
	}
	
	/*
	 * Scalene <-> Impossible
	 */

	@Test
	public void T36() {
		assertEquals("scalene", new Triangle(2, 3, 4).classify());
	}

	@Test
	public void T37() {
		assertEquals("impossible", new Triangle(2, 3, 5).classify());
	}
	
	@Test
	public void T38() {
		assertEquals(true, new Triangle(2, 3, 4).isScalene());
	}

	@Test
	public void T39() {
		assertEquals(false, new Triangle(2, 3, 5).isScalene());
	}
	
	@Test
	public void T40() {
		assertEquals(false, new Triangle(2, 3, 4).isImpossible());
	}
	
	@Test
	public void T41() {
		assertEquals(true, new Triangle(2, 3, 5).isImpossible());
	}

	@Test
	public void T42() {
		assertEquals(2.905, new Triangle(2, 3, 4).getArea(), epsilon);
	}
	
	@Test
	public void T43() {
		assertEquals(-1.0, new Triangle(2, 3, 5).getArea(), epsilon);
	}

	/*
	 * Equilateral <-> Isosceles
	 */

	@Test
	public void T44() {
		assertEquals("equilateral", new Triangle(2, 2, 2).classify());
	}

	@Test
	public void T45() {
		assertEquals("isosceles", new Triangle(2, 2, 1).classify());
	}
	
	@Test
	public void T46() {
		assertEquals(true, new Triangle(2, 2, 2).isEquilateral());
	}

	@Test
	public void T47() {
		assertEquals(false, new Triangle(2, 2, 1).isEquilateral());
	}
	
	@Test
	public void T48() {
		assertEquals(true, new Triangle(2, 2, 2).isIsosceles()); // previously false
	}
	
	@Test
	public void T49() {
		assertEquals(true, new Triangle(2, 2, 1).isIsosceles());
	}

	/*
	 * Equilateral <-> Impossible
	 */

	@Test
	public void T50() {
		assertEquals("equilateral", new Triangle(1, 1, 1).classify());
	}

	@Test
	public void T51() {
		assertEquals("impossible", new Triangle(1, 1, 2).classify());
	}
	
	@Test
	public void T52() {
		assertEquals(true, new Triangle(1, 1, 1).isEquilateral());
	}

	@Test
	public void T53() {
		assertEquals(false, new Triangle(1, 1, 2).isEquilateral());
	}
	
	@Test
	public void T54() {
		assertEquals(false, new Triangle(1, 1, 1).isImpossible());
	}
	
	@Test
	public void T55() {
		assertEquals(true, new Triangle(1, 1, 2).isImpossible());
	}

	@Test
	public void T56() {
		assertEquals(0.433, new Triangle(1, 1, 1).getArea(), epsilon);
	}

	@Test
	public void T57() {
		assertEquals(-1.0, new Triangle(1, 1, 2).getArea(), epsilon);
	}

	/*
	 * Isosceles <-> Impossible
	 */

	@Test
	public void T58() {
		assertEquals("isosceles", new Triangle(1, 2, 2).classify());
	}

	@Test
	public void T59() {
		assertEquals("impossible", new Triangle(1, 2, 3).classify());
	}
	
	@Test
	public void T60() {
		assertEquals(true, new Triangle(1, 2, 2).isIsosceles());
	}

	@Test
	public void T61() {
		assertEquals(false, new Triangle(1, 2, 3).isIsosceles());
	}
	
	@Test
	public void T62() {
		assertEquals(false, new Triangle(1, 2, 2).isImpossible());
	}
	
	@Test
	public void T63() {
		assertEquals(true, new Triangle(1, 2, 3).isImpossible());
	}

	@Test
	public void T64() {
		assertEquals(0.9682, new Triangle(1, 2, 2).getArea(), epsilon);
	}
	
	@Test
	public void T65() {
		assertEquals(-1.0, new Triangle(1, 2, 3).getArea(), epsilon);
	}

	/*
	 * Isosceles <-> Right-angled
	 */

	@Test
	public void T66() {
		assertEquals("isosceles", new Triangle(3, 4, 4).classify());
	}

	@Test
	public void T67() {
		assertEquals("right-angled", new Triangle(3, 4, 5).classify());
	}
	
	@Test
	public void T68() {
		assertEquals(true, new Triangle(3, 4, 4).isIsosceles());
	}

	@Test
	public void T69() {
		assertEquals(false, new Triangle(3, 4, 5).isIsosceles());
	}
	
	@Test
	public void T70() {
		assertEquals(false, new Triangle(3, 4, 4).isRightAngled());
	}
	
	@Test
	public void T71() {
		assertEquals(true, new Triangle(3, 4, 5).isRightAngled());
	}
}
