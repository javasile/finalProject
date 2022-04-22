package DemoBackend.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "quote")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String quoteNumber;

    @Column(name = "order_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

@OneToMany()
@JoinTable(
        name = "quote_product",
        joinColumns = @JoinColumn(name = "quote_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
)
private Set<Product> product;

    @ManyToOne
    private Client client;
}
