package ch11.exam02;

public class Key {
	public int number;
	
	public Key(int number){
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key){
			Key target = (Key) obj;
			if(number == target.number){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return number;
	}
	
}
