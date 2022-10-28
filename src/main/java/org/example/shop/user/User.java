package org.example.shop.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @ToString.Exclude
    @Embedded
    private Bucket bucket;
}
