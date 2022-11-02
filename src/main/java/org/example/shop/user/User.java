package org.example.shop.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(bucket, user.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bucket);
    }
}
