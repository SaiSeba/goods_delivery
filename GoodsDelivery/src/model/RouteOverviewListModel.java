package model;

public class RouteOverviewListModel {
	int id;
	String regno;
	String date;
	String route;
	String goods;
	int totalWeight;
	int status;
	int scheduleid;

	public RouteOverviewListModel(String regno, String date, String route, String goods, int totalWeight, int status,
			int scheduleid) {
		this.regno = regno;
		this.date = date;
		this.route = route;
		this.goods = goods;
		this.totalWeight = totalWeight;
		this.status = status;
		this.scheduleid = scheduleid;
	}

	public int getId() {
		return this.id;
	}

	public String getregno() {
		return this.regno;
	}

	public String getdate() {
		return this.date;
	}
	public String getroute() {
		return this.route;
	}
	public String getgoods() {
		return this.goods;
	}
	public int  gettotalWeight() {
		return this.totalWeight;
	}
	public int getstatus() {
		return this.status;
	}
	public int getscheduleid() {
		return this.scheduleid;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setregno(String regno) {
		this.regno=regno;
	}
	public void setdate(String date) {
		this.date=date;
	}
	public void setroute(String route) {
		this.route=route;
	}
	public void setgoods(String goods) {
		this.goods=goods;
	}
	public void settotalWeight(int totalWeight) {
		this.totalWeight=totalWeight;
	}
	public void setstatus(int status) {
		this.status=status;
	}
	public void setscheduleid(int scheduleid) {
		this.scheduleid=scheduleid;
	}
}
