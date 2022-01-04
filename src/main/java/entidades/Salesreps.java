package entidades;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@NamedQueries({ @NamedQuery(name = "Salesreps.findAll", query = "SELECT e FROM Salesreps e"),
@NamedQuery(name = "Salesreps.findVendedoresAbaixoQuota", query = "SELECT e.name, e.sales FROM Salesreps e WHERE (e.quota > e.sales) and (e.sales < 300000)"),
@NamedQuery(name = "Salesreps.findCotasVendastodosVendededores", query = "SELECT e.name, e.quota, e.sales FROM Salesreps e"),
@NamedQuery(name = "Salesreps.findQtdVendedoresAcimaQuota", query = "SELECT e.name, e.quota FROM Salesreps e WHERE (e.sales > e.quota)"),
@NamedQuery(name = "Salesreps.findNomeEscritorioContratacao", query = "SELECT e.name, e.rep_office, e.hire_date FROM Salesreps e")})
@Table(name = "salesreps")
public class Salesreps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empl_num")
    private int empl_num;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @OneToOne
    @JoinColumn(name = "rep_office", referencedColumnName="office")
    private Offices rep_office;

    @Column(nullable = false)
    private String title;

	@Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date hire_date;

    @JoinColumn(name = "manager", referencedColumnName="empl_num")
    private Salesreps manager;

    @Column(nullable = false)
    private double quota;

    @Column(nullable = false)
    private double sales;
    
    private Collection<String> nomes;

    public Salesreps() {
    }


    public Salesreps(int empl_num, String name, int age, Offices rep_office, String title, Date hire_date, Salesreps manager, double quota, double sales) {
        this.empl_num = empl_num;
        this.name = name;
        this.age = age;
        this.rep_office = rep_office;
        this.title = title;
        this.hire_date = hire_date;
        this.manager = manager;
        this.quota = quota;
        this.sales = sales;
    }

    public int getEmpl_num() {
        return empl_num;
    }

    public void setEmpl_num(int empl_num) {
        this.empl_num = empl_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Offices getRep_office() {
        return rep_office;
    }

    public void setRep_office(Offices rep_office) {
        this.rep_office = rep_office;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Salesreps getManager() {
        return manager;
    }

    public void setManager(Salesreps manager) {
        this.manager = manager;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }
    
    public Collection<String> getNomes() {
        return nomes;
    }


    public void setNomes(Collection<String> nomes) {
        this.nomes = nomes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesreps salesreps = (Salesreps) o;
        return empl_num == salesreps.empl_num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empl_num);
    }

    @Override
    public String toString() {
        return "Salesreps{" +
                "empl_num=" + empl_num +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", rep_office=" + rep_office +
                ", title='" + title + '\'' +
                ", hire_date=" + hire_date +
                ", manager=" + manager +
                ", quota=" + quota +
                ", sales=" + sales +
                '}';
    }
}
