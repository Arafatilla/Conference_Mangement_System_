
package com.example.demo.entites;

import com.example.demo.Enumeration.*;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AffecterRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private UserApp user;

    @ManyToOne
    @JoinColumn(name = "conference_id", nullable = false)
    private Conference conference;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERole role;


    public AffecterRole() {}

    public AffecterRole(UserApp user, Conference conference, ERole role) {
        this.user = user;
        this.conference = conference;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserApp getUser() {
        return user;
    }

    public void setUser(UserApp user) {
        this.user = user;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
