package jbossews.model;

public class Store {

	public Store() {
		super();
	}

	/**
	 * @return the storeId
	 */
	public int getStoreId() {
		return StoreId;
	}
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(int storeId) {
		this.StoreId = storeId;
	}

	/**
	 * @return the gpsPoint
	 */
	public String getGpsPoint() {
		return GpsPoint;
	}

	/**
	 * @param gpsPoint the gpsPoint to set
	 */
	public void setGpsPoint(String gpsPoint) {
		this.GpsPoint = gpsPoint;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.Name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.Address = address;
	}

	private int StoreId;
	private String Name;
	private String Address;
	private String GpsPoint;


}
