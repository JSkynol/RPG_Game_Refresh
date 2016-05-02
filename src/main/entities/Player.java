package main.entities;

import java.awt.Image;

import main.S;
import main.items.Inventory;
import main.items.Item;

public class Player extends Entity implements Inventory {
	private Item[] pInv;

	public Player() {
		super("Player", S.GameLayers.get(S.PlayerLayer).getGraphics());
	}

	public Player(Image img) {
		super("Player", img, S.GameLayers.get(S.PlayerLayer).getGraphics());
	}

	public void showInventory() {
		//TODO get gui and loop for inventory slots and items
	}

	@Override
	public Item[] getInventory() {
		return pInv;
	}

	@Override
	public void setItems(Item[] i) {
		for (int a = 0; a < i.length; a++) {
			pInv[pInv.length+1]=i[a];
		}

	}

	@Override
	public void addItem(Item i) {
		pInv[pInv.length+1]=i;

	}

	@Override
	public void addItem(Item i, int ammount) {
		pInv[pInv.length+1]=i;

	}

	@Override
	public void addItems(Item[] i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItem(int ID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItem(int ID, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItemByName(String ItemName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItemByName(String ItemName, int ammount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxSize(int size) {
		// TODO Auto-generated method stub

	}

}
