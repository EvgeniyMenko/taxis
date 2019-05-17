package by.it.academy.taxis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.it.academy.taxis.connector.DataSource;
import by.it.academy.taxis.entity.Taxis;
import by.it.academy.taxis.entity.businessclass.BusinessClass;
import by.it.academy.taxis.entity.economyclass.EconomyClass;
import by.it.academy.taxis.entity.middlecalss.MidlleClass;
import by.it.academy.taxis.myinterface.ITaxisDAO;

public class TaxisJDBC implements ITaxisDAO {
	static final String MIDDLEE_CLASS = "Middle Class";
	static final String ECONOMY_CLASS = "Economy Class";
	static final String BUSINESS_CLASS = "Business Class";
	static final String ID = "id";
	static final String CAR = "car";
	static final String CAR_MODEL = "carModel";
	static final String COST = "cost";
	static final String FUEL_CONSUMPTION = "fuelConsumption";
	static final String ACCELERATION = "acceleration";
	static final String MAX_SPEED = "maxSpeed";
	static final String PRICE_FOR_ONE_MINUTE = "priceForOneMinute";
	static final String CLASS_CAR = "classCar";

	private static Logger log = LogManager.getLogger();

	static TaxisJDBC dao;

	private TaxisJDBC() {
	}

	public static TaxisJDBC getInstance() {
		if (dao == null) {
			synchronized (TaxisJDBC.class) {

				dao = new TaxisJDBC();
			}
		}
		return dao;
	}

	@Override
	public Map<Integer, Taxis> getAllCars() {
		Map<Integer, Taxis> result = new HashMap<Integer, Taxis>();
		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("SELECT * FROM taxis.taxis");
			try (ResultSet rs = statemant.executeQuery()) {
				while (rs.next()) {
					if (MIDDLEE_CLASS.equals(rs.getString(CLASS_CAR))) {
						result.put(rs.getInt(ID),
								new MidlleClass(rs.getInt(ID), rs.getString(CAR), rs.getString(CAR_MODEL),
										rs.getDouble(COST), rs.getDouble(FUEL_CONSUMPTION), rs.getDouble(ACCELERATION),
										rs.getDouble(MAX_SPEED), rs.getDouble(PRICE_FOR_ONE_MINUTE)));
					} else if (ECONOMY_CLASS.equals(rs.getString(CLASS_CAR))) {
						result.put(rs.getInt(ID),
								new EconomyClass(rs.getInt(ID), rs.getString(CAR), rs.getString(CAR_MODEL),
										rs.getDouble(COST), rs.getDouble(FUEL_CONSUMPTION), rs.getDouble(ACCELERATION),
										rs.getDouble(MAX_SPEED), rs.getDouble(PRICE_FOR_ONE_MINUTE)));
					} else if (BUSINESS_CLASS.equals(rs.getString(CLASS_CAR))) {
						result.put(rs.getInt(ID),
								new BusinessClass(rs.getInt(ID), rs.getString(CAR), rs.getString(CAR_MODEL),
										rs.getDouble(COST), rs.getDouble(FUEL_CONSUMPTION), rs.getDouble(ACCELERATION),
										rs.getDouble(MAX_SPEED), rs.getDouble(PRICE_FOR_ONE_MINUTE)));

					}
				}
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			log.error("Error JDBC");

		}
		return result;
	}

	@Override
	public Taxis getCar(int id) {
		Taxis taxis = null;
		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement statemant = connection.prepareStatement("SELECT * FROM taxis.taxis where id=?;");
			statemant.setInt(1, id);
			ResultSet rs = statemant.executeQuery();
			while (rs.next()) {
				if (MIDDLEE_CLASS.equals(rs.getString(CLASS_CAR))) {
					taxis = new MidlleClass(rs.getInt(ID), rs.getString(CAR), rs.getString(CAR_MODEL),
							rs.getDouble(COST), rs.getDouble(FUEL_CONSUMPTION), rs.getDouble(ACCELERATION),
							rs.getDouble(MAX_SPEED), rs.getDouble(PRICE_FOR_ONE_MINUTE));
				} else if (ECONOMY_CLASS.equals(rs.getString(CLASS_CAR))) {
					taxis = new EconomyClass(rs.getInt(ID), rs.getString(CAR), rs.getString(CAR_MODEL),
							rs.getDouble(COST), rs.getDouble(FUEL_CONSUMPTION), rs.getDouble(ACCELERATION),
							rs.getDouble(MAX_SPEED), rs.getDouble(PRICE_FOR_ONE_MINUTE));
				} else if (BUSINESS_CLASS.equals(rs.getString(CLASS_CAR))) {
					taxis = new BusinessClass(rs.getInt(ID), rs.getString(CAR), rs.getString(CAR_MODEL),
							rs.getDouble(COST), rs.getDouble(FUEL_CONSUMPTION), rs.getDouble(ACCELERATION),
							rs.getDouble(MAX_SPEED), rs.getDouble(PRICE_FOR_ONE_MINUTE));
				}
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException |

				SQLException e) {
			log.error("Error JDBC");
		}

		return taxis;
	}

	@Override
	public int removeCar(int id) {
		int coint = 0;
		try (Connection connection = DataSource.getConnection()) {
			PreparedStatement pr = connection.prepareStatement("delete from taxis.taxis where id=?");
			pr.setInt(1, id);
			coint = pr.executeUpdate();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			log.error("Error JDBC");
		}
		return coint;
	}

	@Override
	public int addCar(Taxis taxis) {
		int newId = 0;
		int coint = 0;
		try (Connection connection = DataSource.getConnection()) {
			try (PreparedStatement pr = connection.prepareStatement(
					"insert into taxis.taxis(id, car, carModel, cost,fuelConsumption,acceleration,maxSpeed,priceForOneMinute,classCar) values(?,?,?,?,?,?,?,?,?);",
					PreparedStatement.RETURN_GENERATED_KEYS);) {

				pr.setInt(1, newId);
				pr.setString(2, taxis.getCar());
				pr.setString(3, taxis.getCarModel());
				pr.setDouble(4, taxis.getCost());
				pr.setDouble(5, taxis.getFuelConsumption());
				pr.setDouble(6, taxis.getAcceleration());
				pr.setDouble(7, taxis.getMaxSpeed());
				pr.setDouble(8, taxis.getPriceForOneMinute());
				pr.setString(9, taxis.getClassCar());
				coint = pr.executeUpdate();
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			log.error("Error JDBC");
		}
		return coint;
	}

	@Override
	public int updateCar(Taxis taxis) {
		int coint = 0;
		try (Connection connection = DataSource.getConnection()) {
			try (PreparedStatement pr = connection.prepareStatement(
					"update taxis.taxis set car=?, carModel=?, cost =?, fuelConsumption=?, acceleration=?, maxSpeed=?, priceForOneMinute=? where id=?");) {

				pr.setString(1, taxis.getCar());
				pr.setString(2, taxis.getCarModel());
				pr.setDouble(3, taxis.getCost());
				pr.setDouble(4, taxis.getFuelConsumption());
				pr.setDouble(5, taxis.getAcceleration());
				pr.setDouble(6, taxis.getMaxSpeed());
				pr.setDouble(7, taxis.getPriceForOneMinute());
				pr.setInt(8, taxis.getId());
				coint = pr.executeUpdate();

			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			log.error("Error JDBC");
		}
		return coint;
	}

}
