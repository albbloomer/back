package com.company.store.infrastructure.jpa.entity.product;

import com.company.store.infrastructure.jpa.entity.middle.MemberProduct;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductJpaEntity {

    @Id
    @Column(name = "product_id")
    private Long id;

    @OneToMany(mappedBy = "product")
    private final List<MemberProduct> memberProducts = new ArrayList<>();
}
