package trianglepackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTestBVA {
	private double epsilon = 0.0001;
	
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
