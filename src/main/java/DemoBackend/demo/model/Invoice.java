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
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number_tracking")
    private String numberTracking;

    @Column(name = "address")
    private  String address;

    @Column(name = "inv_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    @OneToMany()
    @JoinTable(
            name = "inv_product",
            joinColumns = @JoinColumn(name = "inv_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> product;

}
