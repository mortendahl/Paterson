package paterson.builder;

/*
 * Item 2 in Effective Java (2nd edition)
 * 
 */

public class NutritionFacts {

	// objects are immutable
	private final int servingSize;
	private final int servings;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	private NutritionFacts(Builder builder) {
		this.servingSize	= builder.servingSize;
		this.servings		= builder.servings;
		this.fat			= builder.fat;
		this.sodium			= builder.sodium;
		this.carbohydrate	= builder.carbohydrate;
	}
	
	public int totalCalories() {
		final int unitSize = 100;
		int totalPerUnitServing = carbohydrate * 4000 + fat * 8000;
		return (servingSize/unitSize) * totalPerUnitServing * servings; 
	}
	
	public static class Builder {
		
		// required parameters
		private final int servingSize;
		private final int servings;
		
		// optional parameters
		private int fat				= 0;
		private int sodium 			= 0;
		private int carbohydrate	= 0;
		
		public Builder(int servingSize, int servings) {
			this.servingSize	= servingSize;
			this.servings		= servings;
		}
		
		public Builder fat(int val) {
			this.fat = val;
			return this;
		}
		
		public Builder sodium(int val) {
			this.sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val) {
			this.carbohydrate = val;
			return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
}
