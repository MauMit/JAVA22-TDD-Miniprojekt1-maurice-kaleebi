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
		triangle.setCurrent_type(3, 3, 4);
		assertEquals(TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	
	@Test
	@DisplayName("Test isosceles triangle where only two sides are the same part 2")
	void testIsosceles1() {
		triangle.setCurrent_type(4, 4, 5);
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
	@DisplayName("Null values")
	void testNullValues() {
		triangle.setCurrent_type(0, 0, 0);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Invalid lenght")
	void testInvalidLenght() {
		triangle.setCurrent_type(-1, -2, -3);
		assertNull(triangle.getCurrent_type());
	}

	@Test
	@DisplayName("Test user input")
	void testInput() {
		String data = "3,4,5";
		InputStream in = new ByteArrayInputStream(data.getBytes());
		System.setIn(in);
		triangle.getUserInput();
		assertEquals(TYPE.SCALENE, triangle.getCurrent_type());
	}
	

	@Test
	@DisplayName("Test invalid input")
	void testInvalidInput() {
		String[] invalidInput = { "a", "b", "c" };
		Triangle triangle = new Triangle(invalidInput);
		assertNull(triangle.getCurrent_type());
	}
	

}
