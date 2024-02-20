package Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "img_prod", schema = "dbo", catalog = "Paint_Ua")
public class ImgProdEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "PLUS_ARTIC")
    private Long plusArtic;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "sort_order")
    private Integer sortOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPlusArtic() {
        return plusArtic;
    }

    public void setPlusArtic(Long plusArtic) {
        this.plusArtic = plusArtic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImgProdEntity that = (ImgProdEntity) o;
        return id == that.id && Objects.equals(plusArtic, that.plusArtic) && Objects.equals(image, that.image) && Objects.equals(sortOrder, that.sortOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plusArtic, image, sortOrder);
    }
}
