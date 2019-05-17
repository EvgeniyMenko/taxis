package by.it.academy.taxis.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import by.it.academy.taxis.camporator.CarComparator;
import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.exception.IncorrectNumberException;

public class Utils {
	static Utils utils;

	private Utils() {
	}

	public static Utils getInstance() {
		if (utils == null) {
			synchronized (Utils.class) {

				utils = new Utils();
			}
		}
		return utils;
	}

//This method calculates the sum of all machines.
	public double sumCostTaxis(Map<Integer, Taxis> taxis) {
		double sum = 0;
		for (Map.Entry<Integer, Taxis> entry : taxis.entrySet()) {
			sum += entry.getValue().getCost();
		}
		return sum;
	}

//This method finds cars in the range of speed and acceleration.
	public List<Taxis> FindCarRangeSpeedSettings(Map<Integer, Taxis> taxis, int minspeed, int minacceleration,
			int maxspeed, int maxacceleration) throws IncorrectNumberException {
		if (maxspeed > 0 && maxacceleration > 0 && minspeed > -1 && minacceleration > -1) {
			int counter = 0;
			List<Taxis> result = new ArrayList<Taxis>();
			for (Map.Entry<Integer, Taxis> entry : taxis.entrySet()) {
				if ((entry.getValue().getMaxSpeed() >= minspeed
						&& entry.getValue().getAcceleration() >= minacceleration)
						&& (entry.getValue().getMaxSpeed() <= maxspeed
								&& entry.getValue().getAcceleration() <= maxacceleration)) {
					result.add(entry.getValue());
					counter++;
				}
			}
			if (counter == 0) {

				return null;
			} else {
				return result;
			}
		} else {
			throw new IncorrectNumberException("Acceleration and speed cannot be negative or zero.");
		}
	}

//taxis sorting by fuel consumption.
	public List<Taxis> sortCar(Map<Integer, Taxis> taxis) {

		List<Taxis> list = new LinkedList<Taxis>(taxis.values());

		Collections.sort(list, new CarComparator());

		return list;
	}
}
