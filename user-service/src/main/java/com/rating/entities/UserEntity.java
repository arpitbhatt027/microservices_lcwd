package com.rating.entities;

import com.rating.payload.Ratings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String userId;

    private String name;
    private String email;
    private String contact;

    @Transient
    private List<Ratings> ratings = new ArrayList<>();
}
