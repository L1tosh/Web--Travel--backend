package com.example.travel.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "travel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String price;
    private int number_of_people;
    private String city;
    private String country;
    private String photo;
    private int day;
    @Column(columnDefinition = "text")
    private String description;

}
