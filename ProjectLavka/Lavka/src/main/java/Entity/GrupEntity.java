package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grup", schema = "dbo", catalog = "Paint_Ua")
public class GrupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idgr")
    private int idgr;
    @Basic
    @Column(name = "idgrper")
    private Integer idgrper;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "sort_order")
    private Integer sortOrder;
    @Basic
    @Column(name = "image_name")
    private String imageName;
    @Basic
    @Column(name = "seo_keyword")
    private String seoKeyword;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "meta_title")
    private String metaTitle;
    @Basic
    @Column(name = "meta_desc")
    private String metaDesc;
    @Basic
    @Column(name = "meta_h1")
    private String metaH1;
    @Basic
    @Column(name = "layout")
    private String layout;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "NGROUP_TVR")
    private String ngroupTvr;
    @Basic
    @Column(name = "NGROUP_TV2")
    private String ngroupTv2;
    @Basic
    @Column(name = "NGROUP_TV3")
    private String ngroupTv3;
    @Basic
    @Column(name = "NGROUP_TV4")
    private String ngroupTv4;
    @Basic
    @Column(name = "NGROUP_TV5")
    private String ngroupTv5;
    @Basic
    @Column(name = "NGROUP_TV6")
    private String ngroupTv6;

    public int getIdgr() {
        return idgr;
    }

    public void setIdgr(int idgr) {
        this.idgr = idgr;
    }

    public Integer getIdgrper() {
        return idgrper;
    }

    public void setIdgrper(Integer idgrper) {
        this.idgrper = idgrper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDesc() {
        return metaDesc;
    }

    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    public String getMetaH1() {
        return metaH1;
    }

    public void setMetaH1(String metaH1) {
        this.metaH1 = metaH1;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNgroupTvr() {
        return ngroupTvr;
    }

    public void setNgroupTvr(String ngroupTvr) {
        this.ngroupTvr = ngroupTvr;
    }

    public String getNgroupTv2() {
        return ngroupTv2;
    }

    public void setNgroupTv2(String ngroupTv2) {
        this.ngroupTv2 = ngroupTv2;
    }

    public String getNgroupTv3() {
        return ngroupTv3;
    }

    public void setNgroupTv3(String ngroupTv3) {
        this.ngroupTv3 = ngroupTv3;
    }

    public String getNgroupTv4() {
        return ngroupTv4;
    }

    public void setNgroupTv4(String ngroupTv4) {
        this.ngroupTv4 = ngroupTv4;
    }

    public String getNgroupTv5() {
        return ngroupTv5;
    }

    public void setNgroupTv5(String ngroupTv5) {
        this.ngroupTv5 = ngroupTv5;
    }

    public String getNgroupTv6() {
        return ngroupTv6;
    }

    public void setNgroupTv6(String ngroupTv6) {
        this.ngroupTv6 = ngroupTv6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupEntity that = (GrupEntity) o;
        return idgr == that.idgr && Objects.equals(idgrper, that.idgrper) && Objects.equals(name, that.name) && Objects.equals(sortOrder, that.sortOrder) && Objects.equals(imageName, that.imageName) && Objects.equals(seoKeyword, that.seoKeyword) && Objects.equals(description, that.description) && Objects.equals(metaTitle, that.metaTitle) && Objects.equals(metaDesc, that.metaDesc) && Objects.equals(metaH1, that.metaH1) && Objects.equals(layout, that.layout) && Objects.equals(status, that.status) && Objects.equals(ngroupTvr, that.ngroupTvr) && Objects.equals(ngroupTv2, that.ngroupTv2) && Objects.equals(ngroupTv3, that.ngroupTv3) && Objects.equals(ngroupTv4, that.ngroupTv4) && Objects.equals(ngroupTv5, that.ngroupTv5) && Objects.equals(ngroupTv6, that.ngroupTv6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idgr, idgrper, name, sortOrder, imageName, seoKeyword, description, metaTitle, metaDesc, metaH1, layout, status, ngroupTvr, ngroupTv2, ngroupTv3, ngroupTv4, ngroupTv5, ngroupTv6);
    }
}
