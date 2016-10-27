package application;

public abstract class Players {
	
	int name; 
	Chip chip; 
	
	Chip getChip()
	{
		return chip; 
	}

}


class Player extends Players{
	
	Player(int name)
	{
		this.name  = name; 
		chip = new Chip(name);
	}

	
}
