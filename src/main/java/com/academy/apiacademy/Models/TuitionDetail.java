package com.academy.apiacademy.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class TuitionDetail {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTuitionDetail;

    @ManyToOne
    @JoinColumn(name = "id_tuition", nullable = false, foreignKey = @ForeignKey(name = "fk_tuition_detail_tuition"))
    private Tuition tuition;

    @ManyToOne
    @JoinColumn(name = "id_session", nullable = false, foreignKey = @ForeignKey(name = "fk_tuition_detail_session"))
    private Session session;

    @Column(nullable = false)
    private String classroom;
}
