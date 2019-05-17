package by.it.academy.taxis.entity.businessclass;

import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.myinterface.ITaxiFare;

public class BusinessClass extends Taxis implements ITaxiFare {
	private double wifiPrice = 3.1;
	private double champagnePrice = 5;

	public BusinessClass(Integer id, String car, String carModel, double cost, double fuelConsumption,
			double acceleration, double maxSpeed, double priceForOneMinute) {
		super(id, car, carModel, cost, fuelConsumption, acceleration, maxSpeed, priceForOneMinute);
		super.setClassCar("Business Class");
	}

	@Override
	public double taxiFare(Integer time) {

		return (time * getPriceForOneMinute()) + wifiPrice + champagnePrice;
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

	public double getChampagnePrice() {
		return champagnePrice;
	}

	public void setChampagnePrice(double champagnePrice) {
		this.champagnePrice = champagnePrice;
	}

}
