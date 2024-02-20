package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SCL_NAKL", schema = "dbo", catalog = "Paint_Ua")
public class SclNaklEntity {
    @Basic
    @Column(name = "N_PLAT_POR")
    private double nPlatPor;
    @Basic
    @Column(name = "DOPN_SCHET")
    private String dopnSchet;
    @Basic
    @Column(name = "DATE_P_POR")
    private Timestamp datePPor;
    @Basic
    @Column(name = "SUM_POR")
    private double sumPor;
    @Basic
    @Column(name = "NALOG_POR")
    private String nalogPor;
    @Basic
    @Column(name = "PRCNT_POR")
    private Double prcntPor;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "UNICUM_NUM")
    private double unicumNum;
    @Basic
    @Column(name = "STND_UCHET")
    private boolean stndUchet;
    @Basic
    @Column(name = "L_CP1_PLAT")
    private String lCp1Plat;
    @Basic
    @Column(name = "L_CP2_PLAT")
    private String lCp2Plat;
    @Basic
    @Column(name = "CHERZ_KOGO")
    private String cherzKogo;
    @Basic
    @Column(name = "OSNOVANIE")
    private String osnovanie;
    @Basic
    @Column(name = "NUMSCHETPL")
    private String numschetpl;
    @Basic
    @Column(name = "BUHSCHETPL")
    private String buhschetpl;
    @Basic
    @Column(name = "PRIMECH_NC")
    private String primechNc;
    @Basic
    @Column(name = "OPLATA_SCH")
    private boolean oplataSch;
    @Basic
    @Column(name = "CONTR_POR")
    private String contrPor;
    @Basic
    @Column(name = "NOT_NAL")
    private boolean notNal;
    @Basic
    @Column(name = "VALUTROUBL")
    private boolean valutroubl;
    @Basic
    @Column(name = "COD_VALUT")
    private String codValut;
    @Basic
    @Column(name = "SUM_VALUT")
    private Double sumValut;
    @Basic
    @Column(name = "NALG2_POR")
    private String nalg2Por;
    @Basic
    @Column(name = "PRCN2_POR")
    private Double prcn2Por;
    @Basic
    @Column(name = "VOZVRAT_PR")
    private boolean vozvratPr;
    @Basic
    @Column(name = "CHAST_OPLT")
    private boolean chastOplt;
    @Basic
    @Column(name = "TYPE_DOC")
    private String typeDoc;
    @Basic
    @Column(name = "ORGANIZNKL")
    private String organiznkl;
    @Basic
    @Column(name = "MY_ORGANIZ")
    private String myOrganiz;
    @Basic
    @Column(name = "CONTRLDATE")
    private Timestamp contrldate;
    @Basic
    @Column(name = "PRIMECH_PO")
    private String primechPo;
    @Basic
    @Column(name = "FAMILY")
    private String family;
    @Basic
    @Column(name = "N_ZD_NAKL")
    private String nZdNakl;
    @Basic
    @Column(name = "TOWN_OTPR")
    private String townOtpr;
    @Basic
    @Column(name = "STATION_OTPR")
    private String stationOtpr;
    @Basic
    @Column(name = "NAME_TVR")
    private String nameTvr;
    @Basic
    @Column(name = "SUM_ROZN")
    private Double sumRozn;
    @Basic
    @Column(name = "OTGRDATE")
    private Timestamp otgrdate;
    @Basic
    @Column(name = "OPLTDATE")
    private Timestamp opltdate;
    @Basic
    @Column(name = "SCH_DATE")
    private Timestamp schDate;
    @Basic
    @Column(name = "OTDELDATE")
    private Timestamp otdeldate;
    @Basic
    @Column(name = "VOZVRDATE")
    private Timestamp vozvrdate;
    @Basic
    @Column(name = "SCLADDATE")
    private Timestamp scladdate;
    @Basic
    @Column(name = "OTMETKA")
    private boolean otmetka;
    @Basic
    @Column(name = "VID_DOC")
    private String vidDoc;
    @Basic
    @Column(name = "BRIEFORG")
    private String brieforg;
    @Basic
    @Column(name = "ID_SCLAD")
    private Integer idSclad;
    @Basic
    @Column(name = "CREATEDATE")
    private Timestamp createdate;
    @Basic
    @Column(name = "CORRDATE")
    private Timestamp corrdate;
    @Basic
    @Column(name = "WHO_CORR")
    private String whoCorr;
    @Basic
    @Column(name = "WHO_OTMET")
    private String whoOtmet;
    @Basic
    @Column(name = "IS_NALPROD")
    private Short isNalprod;
    @Basic
    @Column(name = "NDS_TORGN")
    private Short ndsTorgn;

    public double getnPlatPor() {
        return nPlatPor;
    }

    public void setnPlatPor(double nPlatPor) {
        this.nPlatPor = nPlatPor;
    }

    public String getDopnSchet() {
        return dopnSchet;
    }

    public void setDopnSchet(String dopnSchet) {
        this.dopnSchet = dopnSchet;
    }

    public Timestamp getDatePPor() {
        return datePPor;
    }

    public void setDatePPor(Timestamp datePPor) {
        this.datePPor = datePPor;
    }

    public double getSumPor() {
        return sumPor;
    }

    public void setSumPor(double sumPor) {
        this.sumPor = sumPor;
    }

    public String getNalogPor() {
        return nalogPor;
    }

    public void setNalogPor(String nalogPor) {
        this.nalogPor = nalogPor;
    }

    public Double getPrcntPor() {
        return prcntPor;
    }

    public void setPrcntPor(Double prcntPor) {
        this.prcntPor = prcntPor;
    }

    public double getUnicumNum() {
        return unicumNum;
    }

    public void setUnicumNum(double unicumNum) {
        this.unicumNum = unicumNum;
    }

    public boolean isStndUchet() {
        return stndUchet;
    }

    public void setStndUchet(boolean stndUchet) {
        this.stndUchet = stndUchet;
    }

    public String getlCp1Plat() {
        return lCp1Plat;
    }

    public void setlCp1Plat(String lCp1Plat) {
        this.lCp1Plat = lCp1Plat;
    }

    public String getlCp2Plat() {
        return lCp2Plat;
    }

    public void setlCp2Plat(String lCp2Plat) {
        this.lCp2Plat = lCp2Plat;
    }

    public String getCherzKogo() {
        return cherzKogo;
    }

    public void setCherzKogo(String cherzKogo) {
        this.cherzKogo = cherzKogo;
    }

    public String getOsnovanie() {
        return osnovanie;
    }

    public void setOsnovanie(String osnovanie) {
        this.osnovanie = osnovanie;
    }

    public String getNumschetpl() {
        return numschetpl;
    }

    public void setNumschetpl(String numschetpl) {
        this.numschetpl = numschetpl;
    }

    public String getBuhschetpl() {
        return buhschetpl;
    }

    public void setBuhschetpl(String buhschetpl) {
        this.buhschetpl = buhschetpl;
    }

    public String getPrimechNc() {
        return primechNc;
    }

    public void setPrimechNc(String primechNc) {
        this.primechNc = primechNc;
    }

    public boolean isOplataSch() {
        return oplataSch;
    }

    public void setOplataSch(boolean oplataSch) {
        this.oplataSch = oplataSch;
    }

    public String getContrPor() {
        return contrPor;
    }

    public void setContrPor(String contrPor) {
        this.contrPor = contrPor;
    }

    public boolean isNotNal() {
        return notNal;
    }

    public void setNotNal(boolean notNal) {
        this.notNal = notNal;
    }

    public boolean isValutroubl() {
        return valutroubl;
    }

    public void setValutroubl(boolean valutroubl) {
        this.valutroubl = valutroubl;
    }

    public String getCodValut() {
        return codValut;
    }

    public void setCodValut(String codValut) {
        this.codValut = codValut;
    }

    public Double getSumValut() {
        return sumValut;
    }

    public void setSumValut(Double sumValut) {
        this.sumValut = sumValut;
    }

    public String getNalg2Por() {
        return nalg2Por;
    }

    public void setNalg2Por(String nalg2Por) {
        this.nalg2Por = nalg2Por;
    }

    public Double getPrcn2Por() {
        return prcn2Por;
    }

    public void setPrcn2Por(Double prcn2Por) {
        this.prcn2Por = prcn2Por;
    }

    public boolean isVozvratPr() {
        return vozvratPr;
    }

    public void setVozvratPr(boolean vozvratPr) {
        this.vozvratPr = vozvratPr;
    }

    public boolean isChastOplt() {
        return chastOplt;
    }

    public void setChastOplt(boolean chastOplt) {
        this.chastOplt = chastOplt;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getOrganiznkl() {
        return organiznkl;
    }

    public void setOrganiznkl(String organiznkl) {
        this.organiznkl = organiznkl;
    }

    public String getMyOrganiz() {
        return myOrganiz;
    }

    public void setMyOrganiz(String myOrganiz) {
        this.myOrganiz = myOrganiz;
    }

    public Timestamp getContrldate() {
        return contrldate;
    }

    public void setContrldate(Timestamp contrldate) {
        this.contrldate = contrldate;
    }

    public String getPrimechPo() {
        return primechPo;
    }

    public void setPrimechPo(String primechPo) {
        this.primechPo = primechPo;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getnZdNakl() {
        return nZdNakl;
    }

    public void setnZdNakl(String nZdNakl) {
        this.nZdNakl = nZdNakl;
    }

    public String getTownOtpr() {
        return townOtpr;
    }

    public void setTownOtpr(String townOtpr) {
        this.townOtpr = townOtpr;
    }

    public String getStationOtpr() {
        return stationOtpr;
    }

    public void setStationOtpr(String stationOtpr) {
        this.stationOtpr = stationOtpr;
    }

    public String getNameTvr() {
        return nameTvr;
    }

    public void setNameTvr(String nameTvr) {
        this.nameTvr = nameTvr;
    }

    public Double getSumRozn() {
        return sumRozn;
    }

    public void setSumRozn(Double sumRozn) {
        this.sumRozn = sumRozn;
    }

    public Timestamp getOtgrdate() {
        return otgrdate;
    }

    public void setOtgrdate(Timestamp otgrdate) {
        this.otgrdate = otgrdate;
    }

    public Timestamp getOpltdate() {
        return opltdate;
    }

    public void setOpltdate(Timestamp opltdate) {
        this.opltdate = opltdate;
    }

    public Timestamp getSchDate() {
        return schDate;
    }

    public void setSchDate(Timestamp schDate) {
        this.schDate = schDate;
    }

    public Timestamp getOtdeldate() {
        return otdeldate;
    }

    public void setOtdeldate(Timestamp otdeldate) {
        this.otdeldate = otdeldate;
    }

    public Timestamp getVozvrdate() {
        return vozvrdate;
    }

    public void setVozvrdate(Timestamp vozvrdate) {
        this.vozvrdate = vozvrdate;
    }

    public Timestamp getScladdate() {
        return scladdate;
    }

    public void setScladdate(Timestamp scladdate) {
        this.scladdate = scladdate;
    }

    public boolean isOtmetka() {
        return otmetka;
    }

    public void setOtmetka(boolean otmetka) {
        this.otmetka = otmetka;
    }

    public String getVidDoc() {
        return vidDoc;
    }

    public void setVidDoc(String vidDoc) {
        this.vidDoc = vidDoc;
    }

    public String getBrieforg() {
        return brieforg;
    }

    public void setBrieforg(String brieforg) {
        this.brieforg = brieforg;
    }

    public Integer getIdSclad() {
        return idSclad;
    }

    public void setIdSclad(Integer idSclad) {
        this.idSclad = idSclad;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Timestamp getCorrdate() {
        return corrdate;
    }

    public void setCorrdate(Timestamp corrdate) {
        this.corrdate = corrdate;
    }

    public String getWhoCorr() {
        return whoCorr;
    }

    public void setWhoCorr(String whoCorr) {
        this.whoCorr = whoCorr;
    }

    public String getWhoOtmet() {
        return whoOtmet;
    }

    public void setWhoOtmet(String whoOtmet) {
        this.whoOtmet = whoOtmet;
    }

    public Short getIsNalprod() {
        return isNalprod;
    }

    public void setIsNalprod(Short isNalprod) {
        this.isNalprod = isNalprod;
    }

    public Short getNdsTorgn() {
        return ndsTorgn;
    }

    public void setNdsTorgn(Short ndsTorgn) {
        this.ndsTorgn = ndsTorgn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SclNaklEntity that = (SclNaklEntity) o;
        return Double.compare(nPlatPor, that.nPlatPor) == 0 && Double.compare(sumPor, that.sumPor) == 0 && Double.compare(unicumNum, that.unicumNum) == 0 && stndUchet == that.stndUchet && oplataSch == that.oplataSch && notNal == that.notNal && valutroubl == that.valutroubl && vozvratPr == that.vozvratPr && chastOplt == that.chastOplt && otmetka == that.otmetka && Objects.equals(dopnSchet, that.dopnSchet) && Objects.equals(datePPor, that.datePPor) && Objects.equals(nalogPor, that.nalogPor) && Objects.equals(prcntPor, that.prcntPor) && Objects.equals(lCp1Plat, that.lCp1Plat) && Objects.equals(lCp2Plat, that.lCp2Plat) && Objects.equals(cherzKogo, that.cherzKogo) && Objects.equals(osnovanie, that.osnovanie) && Objects.equals(numschetpl, that.numschetpl) && Objects.equals(buhschetpl, that.buhschetpl) && Objects.equals(primechNc, that.primechNc) && Objects.equals(contrPor, that.contrPor) && Objects.equals(codValut, that.codValut) && Objects.equals(sumValut, that.sumValut) && Objects.equals(nalg2Por, that.nalg2Por) && Objects.equals(prcn2Por, that.prcn2Por) && Objects.equals(typeDoc, that.typeDoc) && Objects.equals(organiznkl, that.organiznkl) && Objects.equals(myOrganiz, that.myOrganiz) && Objects.equals(contrldate, that.contrldate) && Objects.equals(primechPo, that.primechPo) && Objects.equals(family, that.family) && Objects.equals(nZdNakl, that.nZdNakl) && Objects.equals(townOtpr, that.townOtpr) && Objects.equals(stationOtpr, that.stationOtpr) && Objects.equals(nameTvr, that.nameTvr) && Objects.equals(sumRozn, that.sumRozn) && Objects.equals(otgrdate, that.otgrdate) && Objects.equals(opltdate, that.opltdate) && Objects.equals(schDate, that.schDate) && Objects.equals(otdeldate, that.otdeldate) && Objects.equals(vozvrdate, that.vozvrdate) && Objects.equals(scladdate, that.scladdate) && Objects.equals(vidDoc, that.vidDoc) && Objects.equals(brieforg, that.brieforg) && Objects.equals(idSclad, that.idSclad) && Objects.equals(createdate, that.createdate) && Objects.equals(corrdate, that.corrdate) && Objects.equals(whoCorr, that.whoCorr) && Objects.equals(whoOtmet, that.whoOtmet) && Objects.equals(isNalprod, that.isNalprod) && Objects.equals(ndsTorgn, that.ndsTorgn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nPlatPor, dopnSchet, datePPor, sumPor, nalogPor, prcntPor, unicumNum, stndUchet, lCp1Plat, lCp2Plat, cherzKogo, osnovanie, numschetpl, buhschetpl, primechNc, oplataSch, contrPor, notNal, valutroubl, codValut, sumValut, nalg2Por, prcn2Por, vozvratPr, chastOplt, typeDoc, organiznkl, myOrganiz, contrldate, primechPo, family, nZdNakl, townOtpr, stationOtpr, nameTvr, sumRozn, otgrdate, opltdate, schDate, otdeldate, vozvrdate, scladdate, otmetka, vidDoc, brieforg, idSclad, createdate, corrdate, whoCorr, whoOtmet, isNalprod, ndsTorgn);
    }
}
