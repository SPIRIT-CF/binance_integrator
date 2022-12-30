package com.crypto.binance_integrator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@IdClass(PriceId.class)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "prices")
public class Price {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "code_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "code_key"))
    private Code code;

    @Id
    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "val") //, precision = 10, scale = 7
    private BigInteger val;

}
