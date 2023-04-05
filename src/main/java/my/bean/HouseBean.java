package my.bean;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import my.dao.HouseDao;
import my.entities.House;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class HouseBean implements Serializable {
    private int numberOfRooms;
    private int fromFloor;
    private int toFloor;
    private double area;
    private List<Integer> list = new ArrayList<>();
    @EJB
    private HouseDao houseDao;
    public List<House> getHouses(){
        return houseDao.findAll();
    }
    public List<House> findByNumberOfRooms(){
        return houseDao.findByNumberOfRooms(numberOfRooms);
    }
    public List<House> findByNumberOfRoomsAndFloors(){
        return houseDao.findByNumberOfRoomsAndFloors(numberOfRooms,fromFloor,toFloor);
    }
    public List<House> findByAreaAndSortByAreaAndFloor(){
        return houseDao.findByAreaAndSortByAreaAndFloor(area);
    }
    public List<House> sortByArea(){
        return houseDao.sortByArea();
    }
    public List<Integer>  sortByFloor(){
        list = houseDao.sortByFloor();
        return list;
    }
    public Map<Integer, List<House>> apartmentListOfFloor(){
        return houseDao.apartmentListOfFloor();
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(int fromFloor) {
        this.fromFloor = fromFloor;
    }

    public int getToFloor() {
        return toFloor;
    }

    public void setToFloor(int toFloor) {
        this.toFloor = toFloor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
