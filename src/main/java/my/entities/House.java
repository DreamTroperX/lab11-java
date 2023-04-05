package my.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "house")
@NamedQueries({
        @NamedQuery(name = "House.findAll", query = "select h from House h"),
        @NamedQuery(name = "House.findByRooms", query = "SELECT h FROM House h WHERE h.numberOfRooms = :numberOfRooms"),
        @NamedQuery(name = "House.findByRoomsAndFloorRange", query = "select h from House h where h.numberOfRooms = :numberOfRooms and h.floor between :fromFloor and :toFloor"),
        @NamedQuery(name = "House.findByAreaAndSortByAreaAndFloor", query = "select h from House h where h.area >= :area order by h.area DESC, h.floor"),
        @NamedQuery(name = "House.sortByArea", query = "select h from House h order by h.area"),
        @NamedQuery(name = "House.apartmentListOfFloor", query = "SELECT h FROM House h GROUP BY h.floor ORDER BY h.floor"),
        @NamedQuery(name = "House.sortByFloor", query = "SELECT h FROM House h ORDER BY h.floor ASC, h.num ASC")
})
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "num", nullable = false)
    private Integer num;

    @NotNull
    @Column(name = "area", nullable = false)
    private Double area;

    @NotNull
    @Column(name = "floor", nullable = false)
    private Integer floor;

    @NotNull
    @Column(name = "numberOfRooms", nullable = false)
    private Integer numberOfRooms;

    @Size(max = 50)
    @NotNull
    @Column(name = "street", nullable = false, length = 50)
    private String street;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}