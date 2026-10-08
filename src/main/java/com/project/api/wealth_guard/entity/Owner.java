package com.project.api.wealth_guard.entity;

import com.project.api.wealth_guard.dto.input.OwnerInput;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "owner")
public non-sealed class Owner implements SearchResult {
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

    public Owner(OwnerInput ownerInput){
        this.firstName = ownerInput.firstName();
        this.middleName = ownerInput.middleName();
        this.lastName = ownerInput.lastName();
        this.mobile = ownerInput.mobile();
        this.email = ownerInput.email();
        this.aadhar = ownerInput.aadhar();
        this.pan = ownerInput.pan();
    }
}
