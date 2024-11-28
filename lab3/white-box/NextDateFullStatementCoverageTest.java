package wb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NextDateFullStatementCoverageTest {

	private NextDate nextDate;

	@BeforeEach
	void initializeNextDate()
	{
		// Doesn't matter what we initialize it to
		nextDate = new NextDate(0, 0, 0);
	}
	
	@Test
	void testInvalidDate()
	{
		assertEquals("invalid Input Date", nextDate.run(15, 0, 2001));
	}

	@Test
	void testIsThirtyOneDayMonth() {
		assertEquals("3/16/2000", nextDate.run(3, 15, 2000));
		assertEquals("4/1/2000", nextDate.run(3, 31, 2000));
		assertEquals("4/1/2000", nextDate.run(3, 32, 2000));
	}
	
	@Test
	void testIsThirtyDayMonth()
	{
		assertEquals("6/14/2001", nextDate.run(6, 13, 2001));
		assertEquals("7/1/2001", nextDate.run(6, 30, 2001));
		assertEquals("Invalid Input Date", nextDate.run(6, 31, 2001));
	}
	
	@Test
	void testIsDecember()
	{
		assertEquals("12/16/2001", nextDate.run(12, 15, 2001));
		assertEquals("1/1/2002", nextDate.run(12, 31, 2001));
		assertEquals("1/1/2002", nextDate.run(12, 32, 2001));
		assertEquals("Invalid Next Year", nextDate.run(12, 31, 2021));
	}

	@Test
	void testIsFebruary()
	{
		assertEquals("2/16/2001", nextDate.run(2, 15, 2001));
		// 2008 is a leap year, 2009 is not
		assertEquals("2/29/2008", nextDate.run(2, 28, 2008));
		assertEquals("3/1/2009", nextDate.run(2, 28, 2009));
		assertEquals("3/1/2008", nextDate.run(2, 29, 2008));
		assertEquals("Invalid Input Date", nextDate.run(2, 29, 2009));
		assertEquals("Invalid Input Date", nextDate.run(2, 30, 2008));
	}
}
