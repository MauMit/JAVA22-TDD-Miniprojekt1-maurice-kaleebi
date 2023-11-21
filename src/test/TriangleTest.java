package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.Triangle;
import main.Triangle.TYPE;

public class TriangleTest {

	Triangle triangle;

	@BeforeEach
	void initTriangle() {
		triangle = new Triangle();
	}

	@Test
	@DisplayName("Test scalene triangle where no sides are the same")
	void testScalene() {
		triangle.setCurrent_type(3, 4, 5);
		assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test isosceles triangle where only two sides are the same")
	void testIsosceles() {
		triangle.setCurrent_type(4, 4, 5);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test isosceles triangle a == b")
	void testIsosceles1() {
		triangle.setCurrent_type(3, 3, 4);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test isosceles triangle a == c ")
	void testIsosceles2() {

		triangle.setCurrent_type(3, 4, 3);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test isosceles triangle b == c")
	void testIsosceles3() {
		triangle.setCurrent_type(4, 5, 5);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test equilateral triangle where all sides are the same")
	void testEquilateral() {
		triangle.setCurrent_type(3, 3, 3);
		assertEquals(TYPE.EQUILATERAL, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Is not a triangle")
	void testisNotATriangle() {
		triangle.setCurrent_type(1, 2, 3);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Is not a triangle if a = 0")
	void testisNotATriangle1() {
		triangle.setCurrent_type(0, 2, 3);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Is not a triangle if b = 0")
	void testisNotATriangle2() {
		triangle.setCurrent_type(2, 0, 3);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Is not a triangle if c = 0")
	void testisNotATriangle3() {
		triangle.setCurrent_type(2, 2, 0);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Null values")
	void testNullValues() {
		triangle.setCurrent_type(0, 0, 2);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Null values 1")
	void testNullValues1() {
		triangle.setCurrent_type(-1, -2, -3);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Null values a + b <= c")
	void testNullAplusB() {
		triangle.setCurrent_type(2, 2, 4);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Null values a + c <= b")
	void testNullAplusC() {
		triangle.setCurrent_type(2, 4, 2);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Null values b + c <= a")
	void testNullBplusC() {
		triangle.setCurrent_type(4, 2, 2);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input scalene")
	void testInputScalene() {
		String data = "3,4,5";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input isosceles")
	void testInputIsosceles() {
		String data = "4,4,5";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input equilateral")
	void testInputEquilateral() {
		String data = "4,4,4";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertEquals(TYPE.EQUILATERAL, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input null")
	void testInputNull() {
		String data = "0,0,0";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input wrong format")
	void testUserInputFormat() {
		String data = "a,b,c";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertEquals(null, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test invalid user input")
	void testInvalidInput() {
		String[] invalidInput = { "a", "b", "c" };
		Triangle triangle = new Triangle(invalidInput);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input length")
	void testUserInputLength() {
		String data = "3,4,5,6,7";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertEquals(null, triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test triangle which receives array string")
	void testTriangleString() {
		String[] invalidInput = { "0", "2", "2" };
		Triangle triangle = new Triangle(invalidInput);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test triangle which receives invalid input")
	void testTriangleInvalidInput() {
		String[] invalidInput = { "c", "b", "a" };
		Triangle triangle = new Triangle(invalidInput);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test triangle which receives invalid length input")
	void testTriangleInvalidLengthInput() {
		String[] invalidInput = { "1", "2", "2", "4" };
		Triangle triangle = new Triangle(invalidInput);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test triangle which receives invalid length input")
	void testTriangle() {
		Triangle triangle = new Triangle(0, 2, 3);

		assertNull(triangle.getCurrent_type());
	}

}
