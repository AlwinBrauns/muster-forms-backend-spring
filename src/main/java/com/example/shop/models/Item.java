package com.example.shop.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "title for item is needed")
    private String title;
    @NotBlank(message = "description for item is needed")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Element> elements;

}
