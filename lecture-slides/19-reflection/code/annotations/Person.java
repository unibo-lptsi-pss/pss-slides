public class Person {
	
	private String name;
	private int id;
	
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@ToString( // produrrà: getName : <this.name> ,
			associationSymbol = ":",
			separator = ","
	) public String getName() { 
		return name;
	}

	@ToString( // produrrà: id -> <this.id> |
			showMethodName = false,
			customName = "id"
	) public int getId() {
		return id;
	}
}
