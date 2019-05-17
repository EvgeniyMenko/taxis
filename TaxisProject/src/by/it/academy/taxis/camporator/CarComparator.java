package by.it.academy.taxis.camporator;

import java.util.Comparator;

import by.it.academy.taxis.entity.Taxis;

public class CarComparator implements Comparator<Taxis> {

	@Override
	public int compare(Taxis p1, Taxis p2) {

		return (int) (p1.getFuelConsumption() - p2.getFuelConsumption());
	}

}
