package entidades;

import javax.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({ @NamedQuery(name = "Offices.findAll", query = "SELECT e FROM Offices e"),
@NamedQuery(name = "Offices.findEscritoriosObjetivosVendas", query = "SELECT e.target, e.sales FROM Offices e")})
@Table(name = "offices")
public class Offices {
    private Collection<Offices> escritorios;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "office")
    private int office; //primary key

    
    
    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String region;

    @Column(precision = 9, scale = 2)
    private double target;

    @Column(precision = 9, scale = 2)
    private double sales;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mgr", referencedColumnName = "empl_num")
    private Salesreps mgr; //foreign key

    public Offices() {
    }

    public Offices(int office, String city, String region, Salesreps mgr, double target, double sales) {
        this.office = office;
        this.city = city;
        this.region = region;
        this.mgr = mgr;
        this.target = target;
        this.sales = sales;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Salesreps getMgr() {
        return mgr;
    }

    public void setMgr(Salesreps mgr) {
        this.mgr = mgr;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offices offices = (Offices) o;
        return office == offices.office;
    }

    @Override
    public int hashCode() {
        return Objects.hash(office);
    }
    
    public Collection<Offices> getEscritorios() {
        return escritorios;
    }

    public void setProjetos(Collection<Offices> escritorios) {
        this.escritorios = escritorios;
    }

}