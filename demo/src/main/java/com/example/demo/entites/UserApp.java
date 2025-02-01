package com.example.demo.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Data
@Entity
public class UserApp {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String firstName;
        private String lastName;

        @Column(unique = true)
        private String email;

        private String password;


        @OneToMany(fetch = FetchType.EAGER)
        private List<Soumission> submissions;

        @OneToMany(fetch = FetchType.EAGER)
        private List<Evaluation> evaluations;

        @OneToMany(fetch = FetchType.EAGER)
        private List<AffecterRole> roles = new ArrayList<>();


        public UserApp() {}

        public UserApp(Long id, String firstName, String lastName, String email, String password) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                this.password = password;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void setSubmissions(List<Soumission> submissions) {
                this.submissions = submissions;
        }

        public void setEvaluations(List<Evaluation> evaluations) {
                this.evaluations = evaluations;
        }

        public void setRoles(List<AffecterRole> roles) {
                this.roles = roles;
        }

        public Long getId() {
                return id;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public String getEmail() {
                return email;
        }

        public String getPassword() {
                return password;
        }

        public List<Soumission> getSubmissions() {
                return submissions;
        }

        public List<Evaluation> getEvaluations() {
                return evaluations;
        }

        public List<AffecterRole> getRoles() {
                return roles;
        }
}
