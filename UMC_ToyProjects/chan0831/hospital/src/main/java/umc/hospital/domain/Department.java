package umc.hospital.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String phoneNum;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<Doctor> doctorList = new ArrayList<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<Hospital> hospitalList = new ArrayList<>();



}
