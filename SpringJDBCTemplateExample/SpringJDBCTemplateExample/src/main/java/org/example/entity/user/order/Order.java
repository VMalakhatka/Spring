package org.example.entity.user.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany (cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<GoodsItem> items = new ArrayList<>();

    public void addItem(GoodsItem item){
        this.items.add(item);
        item.getOrders().add(this);
    }
    public void removeItem(GoodsItem book){
        this.items.remove(book);
        book.getOrders().remove(this);
    }
}
