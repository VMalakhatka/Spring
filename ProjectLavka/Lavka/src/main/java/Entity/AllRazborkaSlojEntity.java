package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ALL_RAZBORKA_SLOJ", schema = "dbo", catalog = "Paint_Ua")
public class AllRazborkaSlojEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Key")
    private int key;
    @Basic
    @Column(name = "ARTIC_REB")
    private String articReb;
    @Basic
    @Column(name = "ARTIC_ROD")
    private String articRod;
    @Basic
    @Column(name = "KOL_R")
    private Double kolR;
    @Basic
    @Column(name = "DOL_CEN_UA")
    private Double dolCenUa;
    @Basic
    @Column(name = "DOL_CEN_RUB")
    private Double dolCenRub;
    @Basic
    @Column(name = "PR_TRANSPORT")
    private Integer prTransport;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getArticReb() {
        return articReb;
    }

    public void setArticReb(String articReb) {
        this.articReb = articReb;
    }

    public String getArticRod() {
        return articRod;
    }

    public void setArticRod(String articRod) {
        this.articRod = articRod;
    }

    public Double getKolR() {
        return kolR;
    }

    public void setKolR(Double kolR) {
        this.kolR = kolR;
    }

    public Double getDolCenUa() {
        return dolCenUa;
    }

    public void setDolCenUa(Double dolCenUa) {
        this.dolCenUa = dolCenUa;
    }

    public Double getDolCenRub() {
        return dolCenRub;
    }

    public void setDolCenRub(Double dolCenRub) {
        this.dolCenRub = dolCenRub;
    }

    public Integer getPrTransport() {
        return prTransport;
    }

    public void setPrTransport(Integer prTransport) {
        this.prTransport = prTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllRazborkaSlojEntity that = (AllRazborkaSlojEntity) o;
        return key == that.key && Objects.equals(articReb, that.articReb) && Objects.equals(articRod, that.articRod) && Objects.equals(kolR, that.kolR) && Objects.equals(dolCenUa, that.dolCenUa) && Objects.equals(dolCenRub, that.dolCenRub) && Objects.equals(prTransport, that.prTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, articReb, articRod, kolR, dolCenUa, dolCenRub, prTransport);
    }
}
