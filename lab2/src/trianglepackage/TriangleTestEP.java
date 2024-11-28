package trianglepackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class TriangleTestEP {

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
}
