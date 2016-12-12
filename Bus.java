public class Bus {
	private int capacity;
	private int id;
	private String type;

	/**
	 * sets the capacity and plate number of each bus
	 * 
	 * @param capacity
	 * @param id
	 */
	public Bus(int capacity, int id, String type) {
		this.capacity = capacity;
		this.id = id;
		this.type = type;
	}

	/**
	 * @param capacity
	 *            to set the capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param id
	 *            to set the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param type
	 *            to set the type of the bus
	 */
	public void setType(String type) {
		this.type = type;
	}

//	/**
//	 * the type of the bus could be automatically determined by the bus'
//	 * capacity
//	 */
//	public void setTypeByCapacity() {
//		if (this.capacity <= 15) {
//			this.type = "Mini bus";
//		}
//		if (this.capacity > 15 && this.capacity >= 30) {
//			this.type = "Luxury bus";
//		} else {
//			this.type = "Party bus";
//		}
//	}

	/**
	 * @return the type of the bus
	 */
	public String getType() {
		return type;
	}

	/**
	 *
	 * @return a string with the bus number
	 */
	public String toString() {
		return "Bus " + id;
	}
	
	
	/**
	 *
	 * @return a string with information about a bus
	 */
	public String getBusInfo() {
		return "Plate number: " + id + "\nCapacity: " + capacity + "\nType: " + type;
	}
}
