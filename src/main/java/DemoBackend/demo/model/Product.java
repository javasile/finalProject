package DemoBackend.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Length(max = 36)
    @Column(name = "product_name", length = 36)
    private String name;

//    @Length(max = 255)
//    @Column(name = "product_description")
    private String description;

//    @Column(name = "product_price")
//    @PositiveOrZero(message = "Value must be positive or 0!")
    private double price;

//    @Length(max = 255)
//    @Column(name = "product_category")
    private String category;

//    @Column(name = "product_qty")
    private int quantity;


}
