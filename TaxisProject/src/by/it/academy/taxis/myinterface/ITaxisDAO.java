package by.it.academy.taxis.myinterface;

import java.util.Map;

import by.it.academy.taxis.entity.Taxis;

public interface ITaxisDAO {

	Map<Integer, Taxis> getAllCars();

	Taxis getCar(int id);

	int removeCar(int id);

	int addCar(Taxis taxis);

	int updateCar(Taxis taxis);

}
