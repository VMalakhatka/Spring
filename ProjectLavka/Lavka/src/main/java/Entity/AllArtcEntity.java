package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ALL_ARTC", schema = "dbo", catalog = "Paint_Ua")
public class AllArtcEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_ARTIC")
    private String codArtic;
    @Basic
    @Column(name = "COUNTRY")
    private String country;
    @Basic
    @Column(name = "S25")
    private String s25;
    @Basic
    @Column(name = "S50")
    private String s50;
    @Basic
    @Column(name = "S100")
    private String s100;
    @Basic
    @Column(name = "S200")
    private String s200;
    @Basic
    @Column(name = "S250")
    private String s250;
    @Basic
    @Column(name = "S255")
    private String s255;
    @Basic
    @Column(name = "DATE1")
    private Timestamp date1;
    @Basic
    @Column(name = "DATE2")
    private Timestamp date2;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "PLUS_ARTIC")
    private long plusArtic;
    @Basic
    @Column(name = "FASOVKA_KALM")
    private int fasovkaKalm;
    @Basic
    @Column(name = "PR_CENA")
    private Integer prCena;
    @Basic
    @Column(name = "idgr")
    private Integer idgr;
    @Basic
    @Column(name = "idgr_add")
    private String idgrAdd;
    @Basic
    @Column(name = "idgr_add1")
    private Integer idgrAdd1;
    @Basic
    @Column(name = "sort_order")
    private Integer sortOrder;
    @Basic
    @Column(name = "related_ids")
    private String relatedIds;
    @Basic
    @Column(name = "tr_transf")
    private Double trTransf;

    public String getCodArtic() {
        return codArtic;
    }

    public void setCodArtic(String codArtic) {
        this.codArtic = codArtic;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getS25() {
        return s25;
    }

    public void setS25(String s25) {
        this.s25 = s25;
    }

    public String getS50() {
        return s50;
    }

    public void setS50(String s50) {
        this.s50 = s50;
    }

    public String getS100() {
        return s100;
    }

    public void setS100(String s100) {
        this.s100 = s100;
    }

    public String getS200() {
        return s200;
    }

    public void setS200(String s200) {
        this.s200 = s200;
    }

    public String getS250() {
        return s250;
    }

    public void setS250(String s250) {
        this.s250 = s250;
    }

    public String getS255() {
        return s255;
    }

    public void setS255(String s255) {
        this.s255 = s255;
    }

    public Timestamp getDate1() {
        return date1;
    }

    public void setDate1(Timestamp date1) {
        this.date1 = date1;
    }

    public Timestamp getDate2() {
        return date2;
    }

    public void setDate2(Timestamp date2) {
        this.date2 = date2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPlusArtic() {
        return plusArtic;
    }

    public void setPlusArtic(long plusArtic) {
        this.plusArtic = plusArtic;
    }

    public int getFasovkaKalm() {
        return fasovkaKalm;
    }

    public void setFasovkaKalm(int fasovkaKalm) {
        this.fasovkaKalm = fasovkaKalm;
    }

    public Integer getPrCena() {
        return prCena;
    }

    public void setPrCena(Integer prCena) {
        this.prCena = prCena;
    }

    public Integer getIdgr() {
        return idgr;
    }

    public void setIdgr(Integer idgr) {
        this.idgr = idgr;
    }

    public String getIdgrAdd() {
        return idgrAdd;
    }

    public void setIdgrAdd(String idgrAdd) {
        this.idgrAdd = idgrAdd;
    }

    public Integer getIdgrAdd1() {
        return idgrAdd1;
    }

    public void setIdgrAdd1(Integer idgrAdd1) {
        this.idgrAdd1 = idgrAdd1;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getRelatedIds() {
        return relatedIds;
    }

    public void setRelatedIds(String relatedIds) {
        this.relatedIds = relatedIds;
    }

    public Double getTrTransf() {
        return trTransf;
    }

    public void setTrTransf(Double trTransf) {
        this.trTransf = trTransf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllArtcEntity that = (AllArtcEntity) o;
        return plusArtic == that.plusArtic && fasovkaKalm == that.fasovkaKalm && Objects.equals(codArtic, that.codArtic) && Objects.equals(country, that.country) && Objects.equals(s25, that.s25) && Objects.equals(s50, that.s50) && Objects.equals(s100, that.s100) && Objects.equals(s200, that.s200) && Objects.equals(s250, that.s250) && Objects.equals(s255, that.s255) && Objects.equals(date1, that.date1) && Objects.equals(date2, that.date2) && Objects.equals(description, that.description) && Objects.equals(prCena, that.prCena) && Objects.equals(idgr, that.idgr) && Objects.equals(idgrAdd, that.idgrAdd) && Objects.equals(idgrAdd1, that.idgrAdd1) && Objects.equals(sortOrder, that.sortOrder) && Objects.equals(relatedIds, that.relatedIds) && Objects.equals(trTransf, that.trTransf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codArtic, country, s25, s50, s100, s200, s250, s255, date1, date2, description, plusArtic, fasovkaKalm, prCena, idgr, idgrAdd, idgrAdd1, sortOrder, relatedIds, trTransf);
    }
}
