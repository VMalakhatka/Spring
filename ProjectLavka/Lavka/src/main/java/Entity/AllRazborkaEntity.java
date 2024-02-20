package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ALL_RAZBORKA", schema = "dbo", catalog = "Paint_Ua")
public class AllRazborkaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Key")
    private int key;
    @Basic
    @Column(name = "ARTIC")
    private Long artic;
    @Basic
    @Column(name = "ARTIC_R")
    private Long articR;
    @Basic
    @Column(name = "KOL_R")
    private Double kolR;
    @Basic
    @Column(name = "LEVEL")
    private Integer level;
    @Basic
    @Column(name = "ART")
    private String art;
    @Basic
    @Column(name = "ART_R")
    private String artR;
    @Basic
    @Column(name = "COD_VALT_UA")
    private Integer codValtUa;
    @Basic
    @Column(name = "CENA_UA")
    private Double cenaUa;
    @Basic
    @Column(name = "TRANSPORT_UA")
    private Double transportUa;
    @Basic
    @Column(name = "COD_VALT_RUS")
    private Integer codValtRus;
    @Basic
    @Column(name = "CENA_RUS")
    private Double cenaRus;
    @Basic
    @Column(name = "TRANSPORT_RUS")
    private Double transportRus;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Long getArtic() {
        return artic;
    }

    public void setArtic(Long artic) {
        this.artic = artic;
    }

    public Long getArticR() {
        return articR;
    }

    public void setArticR(Long articR) {
        this.articR = articR;
    }

    public Double getKolR() {
        return kolR;
    }

    public void setKolR(Double kolR) {
        this.kolR = kolR;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getArtR() {
        return artR;
    }

    public void setArtR(String artR) {
        this.artR = artR;
    }

    public Integer getCodValtUa() {
        return codValtUa;
    }

    public void setCodValtUa(Integer codValtUa) {
        this.codValtUa = codValtUa;
    }

    public Double getCenaUa() {
        return cenaUa;
    }

    public void setCenaUa(Double cenaUa) {
        this.cenaUa = cenaUa;
    }

    public Double getTransportUa() {
        return transportUa;
    }

    public void setTransportUa(Double transportUa) {
        this.transportUa = transportUa;
    }

    public Integer getCodValtRus() {
        return codValtRus;
    }

    public void setCodValtRus(Integer codValtRus) {
        this.codValtRus = codValtRus;
    }

    public Double getCenaRus() {
        return cenaRus;
    }

    public void setCenaRus(Double cenaRus) {
        this.cenaRus = cenaRus;
    }

    public Double getTransportRus() {
        return transportRus;
    }

    public void setTransportRus(Double transportRus) {
        this.transportRus = transportRus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllRazborkaEntity that = (AllRazborkaEntity) o;
        return key == that.key && Objects.equals(artic, that.artic) && Objects.equals(articR, that.articR) && Objects.equals(kolR, that.kolR) && Objects.equals(level, that.level) && Objects.equals(art, that.art) && Objects.equals(artR, that.artR) && Objects.equals(codValtUa, that.codValtUa) && Objects.equals(cenaUa, that.cenaUa) && Objects.equals(transportUa, that.transportUa) && Objects.equals(codValtRus, that.codValtRus) && Objects.equals(cenaRus, that.cenaRus) && Objects.equals(transportRus, that.transportRus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, artic, articR, kolR, level, art, artR, codValtUa, cenaUa, transportUa, codValtRus, cenaRus, transportRus);
    }
}
