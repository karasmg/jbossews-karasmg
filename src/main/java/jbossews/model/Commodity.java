package jbossews.model;

public class Commodity {

	public Commodity() {
		super();
	}

	/**
	 * @return the CommodityId
	 */
	public int getCommodityId() {
		return CommodityId;
	}
	/**
	 * @param CommodityId the CommodityId to set
	 */
	public void setCommodityId(int CommodityId) {
		this.CommodityId = CommodityId;
	}

	/**
	 * @return the Manufacturer
	 */
	public String getManufacturer() {
		return Manufacturer;
	}

	/**
	 * @param Manufacturer the Manufacturer to set
	 */
	public void setManufacturer(String Manufacturer) {
		this.Manufacturer = Manufacturer;
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
	 * @return the Units
	 */
	public String getUnits() {
		return Units;
	}

	/**
	 * @param Units the Units to set
	 */
	public void setUnits(String Units) {
		this.Units = Units;
	}

	/**
	 * @return the packing
	 */
	public String getPacking() {
		return Packing;
	}

	/**
	 * @param packing the packing to set
	 */
	public void setPacking(String packing) {
		this.Packing = packing;
	}

	/**
	 * @return the barCode
	 */
	public String getBarCode() {
		return BarCode;
	}

	/**
	 * @param barCode the barCode to set
	 */
	public void setBarCode(String barCode) {
		this.BarCode = barCode;
	}

	private int CommodityId;
	private String Name;
	private String Units;
	private String Manufacturer;
	private String Packing;
	private String BarCode;


}
