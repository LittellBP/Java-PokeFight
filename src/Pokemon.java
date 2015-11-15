public class Pokemon {
	private String name;
	private int hp;
	private int atk;
	private int def;
	private int spatk;
	private int spdef;
	private int spd;

	public Pokemon(String name, int hp, int atk, int def, int spatk, int spdef,
			int spd) {
		setName(name);
		setHp(hp);
		setAtk(atk);
		setDef(def);
		setSpatk(spatk);
		setSpdef(spdef);
		setSpd(spd);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpatk() {
		return spatk;
	}

	public void setSpatk(int spatk) {
		this.spatk = spatk;
	}

	public int getSpdef() {
		return spdef;
	}

	public void setSpdef(int spdef) {
		this.spdef = spdef;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public String toString() {
		return "Name: " + this.name + "\nHP: " + this.hp + "\nAttack: "
				+ this.atk + "\nDefense: " + this.def + "\nSpecial Attack: "
				+ this.spatk + "\nSpecial Defense: " + this.spdef
				+ "\nSpeed: " + this.spd;
	}

}
