package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ALL_CENA", schema = "dbo", catalog = "Paint_Ua")
public class AllCenaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARTIC")
    private String artic;
    @Basic
    @Column(name = "ARTIC_BAZA")
    private String articBaza;
    @Basic
    @Column(name = "PR_BAZA")
    private Integer prBaza;
    @Basic
    @Column(name = "CENA_UA")
    private Double cenaUa;
    @Basic
    @Column(name = "CENA_RUB")
    private Double cenaRub;

    public String getArtic() {
        return artic;
    }

    public void setArtic(String artic) {
        this.artic = artic;
    }

    public String getArticBaza() {
        return articBaza;
    }

    public void setArticBaza(String articBaza) {
        this.articBaza = articBaza;
    }

    public Integer getPrBaza() {
        return prBaza;
    }

    public void setPrBaza(Integer prBaza) {
        this.prBaza = prBaza;
    }

    public Double getCenaUa() {
        return cenaUa;
    }

    public void setCenaUa(Double cenaUa) {
        this.cenaUa = cenaUa;
    }

    public Double getCenaRub() {
        return cenaRub;
    }

    public void setCenaRub(Double cenaRub) {
        this.cenaRub = cenaRub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllCenaEntity that = (AllCenaEntity) o;
        return Objects.equals(artic, that.artic) && Objects.equals(articBaza, that.articBaza) && Objects.equals(prBaza, that.prBaza) && Objects.equals(cenaUa, that.cenaUa) && Objects.equals(cenaRub, that.cenaRub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artic, articBaza, prBaza, cenaUa, cenaRub);
    }
}
