package com.academy.apiacademy.Models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Tuition {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTuition;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "fk_tuition_student") )
    private Student student;

    @OneToMany(mappedBy = "tuition", cascade = CascadeType.ALL)
    private List<TuitionDetail> tuitionDetails;
    
}
