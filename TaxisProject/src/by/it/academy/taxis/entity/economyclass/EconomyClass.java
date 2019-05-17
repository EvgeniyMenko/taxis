package by.it.academy.taxis.entity.economyclass;

import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.myinterface.ITaxiFare;

public class EconomyClass extends Taxis implements ITaxiFare {

	public EconomyClass(Integer id, String car, String carModel, double cost, double fuelConsumption,
			double acceleration, double maxSpeed, double priceForOneMinute) {
		super(id, car, carModel, cost, fuelConsumption, acceleration, maxSpeed, priceForOneMinute);
		super.setClassCar("Economy Class");
	}

	@Override
	public double taxiFare(Integer time) {

		return time * getPriceForOneMinute();
	}

	public String toString() {
		return " Car=" + getCar() + ", Fuel Consumption=" + getFuelConsumption() + ", COST=" + getCost()
				+ ", Acceleration=" + getAcceleration() + ", Maximum Speed=" + getMaxSpeed() + ".\n";
	}

}
