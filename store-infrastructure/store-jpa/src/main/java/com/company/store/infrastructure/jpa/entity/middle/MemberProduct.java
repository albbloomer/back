package com.company.store.infrastructure.jpa.entity.middle;

import com.company.store.infrastructure.jpa.entity.member.MemberJpaEntity;
import com.company.store.infrastructure.jpa.entity.product.ProductJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "member_product")
public class MemberProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberJpaEntity member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductJpaEntity product;
}

