package com.project.api.wealth_guard.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 12, nullable = false)
    private String aadhar;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, length = 10, nullable = false)
    private String pan;
    @Column(unique = true, length = 10, nullable = false)
    private String mobile;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Portfolio portfolio;
}
