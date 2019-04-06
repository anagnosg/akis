package gr.akis.handsapp.models;

public class Vathmologia {

	Integer id;
	String basket_team;
	Integer id_race;
	Integer win;
	Integer lose;
	Integer points;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBasket_team() {
		return basket_team;
	}

	public void setBasket_team(String basket_team) {
		this.basket_team = basket_team;
	}

	public Integer getId_race() {
		return id_race;
	}

	public void setId_race(Integer id_race) {
		this.id_race = id_race;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public Integer getLose() {
		return lose;
	}

	public void setLose(Integer lose) {
		this.lose = lose;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

}
