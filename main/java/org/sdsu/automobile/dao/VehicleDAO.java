package org.sdsu.automobile.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sdsu.automobile.model.Vehicle;

public class VehicleDAO {

	private static final Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();
	
	static {
		iniVechile();
    }
	
	private static void iniVechile(){
		
		Vehicle v1 = new Vehicle (789,2019,"Tyota","Camry");
		vehicleMap.put(v1.getId(), v1);
		
	}
	
	public static Vehicle getVehicle(Integer id) {
		return vehicleMap.get(id);
	}
	
	public static Vehicle addVehicle(Vehicle vehicle) {
		vehicleMap.put(vehicle.getId(), vehicle);
		return vehicle;
	}
	
	public static Vehicle updateVehicle(Vehicle vehicle) {
		vehicleMap.put(vehicle.getId(), vehicle);
		return vehicle;
	}
	
	public static void deleteVehicle(Integer id) {
		vehicleMap.remove(id);
	}
	
	public static List<Vehicle> getVehicles() {
		Collection<Vehicle> vehicles = vehicleMap.values();
		List<Vehicle> list = new ArrayList<Vehicle>();
		list.addAll(vehicles);
		return list;
	}
	
}
