package main.items;

public interface Inventory {
	/** Returns all items in inventory */
	Item[] getInventory();

	/** Sets all items in inventory @param ItemArray */
	void setItems(Item[] i);

	/** Adds an item to the inventory */
	void addItem(Item i);

	/** Adds an item to the inventory */
	void addItem(Item i, int ammount);

	/** Adds multiple items to the inventory */
	void addItems(Item[] i);

	/** Removes an item from inventory by its ID */
	void removeItem(int ID);

	/** Removes an item from inventory by its ID */
	void removeItem(int ID, int amount);

	/** Removes an item from Inventory by its Name */
	void removeItemByName(String ItemName);

	/** Removes an item from Inventory by its Name */
	void removeItemByName(String ItemName, int ammount);

	void setMaxSize(int size);
}