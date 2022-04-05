package DemoBackend.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data                 //  @Getter & @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(16)")
    @NotNull
//    GeneratedValue(strategy = generatorT )
    private Integer id;

//    @Length(max = 36)
    @Column(name = "product_name", length = 36)
    @NotNull
    @NotBlank
    private String name;

//    @Length(max = 256)
    @Column(name = "product_description")
    private String description;

    @Column(name = "product_price")
    @PositiveOrZero(message = "Value must be positive or 0!")
    private double price;

    @Column(name = "product_category")
    private String category;

    @Column(name = "product_qty")
    private int quantity;

}
