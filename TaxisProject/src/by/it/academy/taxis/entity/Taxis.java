package by.it.academy.taxis.entity;

import java.util.HashMap;
import java.util.Map;

import by.it.academy.taxis.myinterface.ITaxiFare;

public abstract class Taxis implements ITaxiFare {
	private Integer id;
	private double cost;
	private String car;
	private String carModel;
	private double fuelConsumption;
	private double acceleration;
	private double maxSpeed;
	private double priceForOneMinute;
	private String classCar;

	private Map<Integer, Taxis> taxis = new HashMap<Integer, Taxis>();

	public Taxis(Integer id, String car, String carModel, double cost, double fuelConsumption, double acceleration,
			double maxSpeed, double priceForOneMinute) {
		this.id = id;

		this.carModel = carModel;
		this.car = car;
		this.cost = cost;
		this.fuelConsumption = fuelConsumption;
		this.acceleration = acceleration;
		this.maxSpeed = maxSpeed;
		this.priceForOneMinute = priceForOneMinute;
	}

	public String getClassCar() {
		return classCar;
	}

	public void setClassCar(String classCar) {
		this.classCar = classCar;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public String getCar() {
		return car;
	}

	public String getCarModel() {
		return carModel;
	}

	public double getCost() {
		return cost;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public double getPriceForOneMinute() {
		return priceForOneMinute;
	}

	public void setPriceForOneMinute(double priceForOneMinute) {
		this.priceForOneMinute = priceForOneMinute;
	}

	public Map<Integer, Taxis> getTaxis() {
		return taxis;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setTaxis(Map<Integer, Taxis> taxis) {
		this.taxis = taxis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Taxis" + "\n" + taxis;
	}

	public int compareTo(Taxis taxis) {
		Integer a = ((int) fuelConsumption);
		return a.compareTo((int) taxis.fuelConsumption);
	}

}
