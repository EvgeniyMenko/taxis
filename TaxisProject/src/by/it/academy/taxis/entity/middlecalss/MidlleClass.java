package by.it.academy.taxis.entity.middlecalss;

import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.myinterface.ITaxiFare;

public class MidlleClass extends Taxis implements ITaxiFare {
	private double wifiPrice = 2.9;

	public MidlleClass(Integer id, String car, String carModel, double cost, double fuelConsumption,
			double acceleration, double maxSpeed, double priceForOneMinute) {
		super(id, car, carModel, cost, fuelConsumption, acceleration, maxSpeed, priceForOneMinute);
		super.setClassCar("Middle Class");
	}

	@Override
	public double taxiFare(Integer time) {

		return (time * getPriceForOneMinute()) + wifiPrice;
	}

	public String toString() {
		return " Car=" + getCar() + ", Fuel Consumption=" + getFuelConsumption() + ", COST=" + getCost()
				+ ", Acceleration=" + getAcceleration() + ", Maximum Speed=" + getMaxSpeed() + ".\n";
	}

	public double getWifiPrice() {
		return wifiPrice;
	}

	public void setWifiPrice(double wifiPrice) {
		this.wifiPrice = wifiPrice;
	}

}
