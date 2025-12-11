package spring.boot.system.tickets.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.system.tickets.enums.StatusTicket;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    @Size(min = 5, max = 100)
    private String title;

    @Column
    @NotBlank
    @Size(min = 10, message = "minimo de 10 caracteres para abertura do ticket")
    private String description;

    @Column
    @Enumerated(value = EnumType.STRING)
    private StatusTicket statusTicket = StatusTicket.ABERTO;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant = null;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private User responsible;

    @Column
    private LocalDateTime createdIn;

    @PrePersist
    public void onCreate() {
        this.createdIn = LocalDateTime.now();
    }

    @Column
    private LocalDateTime updatedIn;

}
