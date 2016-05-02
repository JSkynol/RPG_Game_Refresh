package main.items;

public class Item {
	private int ItemID;
	private String ItemName;
	private boolean isAnimated;

	public Item() {
	
	}
	public Item(int itemID,String itemName){
		this.setItemID(itemID);
		this.setItemName(itemName);
	}
	public int getItemID() {
		return ItemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public boolean isAnimated() {
		return isAnimated;
	}
	public void setAnimated(boolean isAnimated) {
		this.isAnimated = isAnimated;
	}
	

}
