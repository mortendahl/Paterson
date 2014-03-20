package paterson.builder;

import static org.junit.Assert.*;

import org.junit.Test;

public class NutritionFactsTest {

	@Test
	public void testEmpty() {
		NutritionFacts water = new NutritionFacts.Builder(500, 8).build();
		assertEquals(0, water.totalCalories());
	}
	
	@Test
	public void testCocaCola() {
		NutritionFacts cocaCola = new NutritionFacts.Builder(500, 8).carbohydrate(10).fat(0).sodium(35).build();
		assertEquals(1600000, cocaCola.totalCalories());
	}

}
