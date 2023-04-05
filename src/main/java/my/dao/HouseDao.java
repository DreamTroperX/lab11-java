package my.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import my.entities.House;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class HouseDao {
    @PersistenceContext
    private EntityManager em;
    public List<House>findAll(){
        return em.createNamedQuery("House.findAll", House.class).getResultList();
    }
    public List<House> findByNumberOfRooms(int numberOfRooms){
        TypedQuery<House> query = em.createNamedQuery("House.findByRooms", House.class);
        query.setParameter("numberOfRooms", numberOfRooms );
        List<House> results = query.getResultList();
        return results;
    }
    public List<House> findByNumberOfRoomsAndFloors(int numberOfRooms, int fromFloor, int toFloor){
        TypedQuery<House> query = em.createNamedQuery("House.findByRoomsAndFloorRange", House.class);
        query.setParameter("numberOfRooms", numberOfRooms );
        query.setParameter("fromFloor", fromFloor);
        query.setParameter("toFloor", toFloor);
        List<House> results = query.getResultList();
        return results;
    }
    public List<House> findByAreaAndSortByAreaAndFloor(double area){
        TypedQuery<House> query = em.createNamedQuery("House.findByAreaAndSortByAreaAndFloor", House.class);
        query.setParameter("area", area );
        List<House> results = query.getResultList();
        return results;
    }
    public List<House> sortByArea(){
        return em.createNamedQuery("House.sortByArea",House.class).getResultList();
    }
    public List<Integer> sortByFloor(){
        return em.createNamedQuery("House.sortByFloor").getResultList();
    }
    public Map<Integer, List<House>> apartmentListOfFloor() {
        TypedQuery<House> query = em.createNamedQuery("House.apartmentListOfFloor", House.class);
        List<House> houses = query.getResultList();
        Map<Integer, List<House>> floorToHouses = houses.stream()
                .collect(Collectors.groupingBy(House::getFloor));

        return floorToHouses;
    }
}
