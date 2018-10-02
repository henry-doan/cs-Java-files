package assignment01;

import static org.junit.Assert.*;

import org.junit.Test;

public class NamedObjectTest {

	@Test
	public void passingNullInTheConstructor() {
		NamedObject nullTest = new NamedObject("n", null);
		if (nullTest.getObject() == null) {
			fail("object is null");
		}
		
	}

}
