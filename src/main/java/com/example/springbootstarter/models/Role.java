package com.example.springbootstarter.models;

import com.example.springbootstarter.enums.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "userUUID")
    @GenericGenerator(name="userUUID", strategy="org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private ERole name;

    @Column(name="description")
    private String description;

    public Role(ERole name, String description) {
        this.name = name;
        this.description = description;
    }
}