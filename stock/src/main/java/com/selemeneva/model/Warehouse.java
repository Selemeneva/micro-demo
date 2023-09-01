package com.selemeneva.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.*;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse", schema = "stock")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String warehouseAddress;
    @OneToMany(mappedBy = "warehouse")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Set<ProductItem> stockLevel;
}

