package mymockitos;

public class Product123 {
	 @SuppressWarnings("unused")
	private int id;
	    private String name;
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@SuppressWarnings("unused")
		private double price;

	    // Constructor, Getters and Setters
	    public Product123(int id, String name, double price) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	    }

}
