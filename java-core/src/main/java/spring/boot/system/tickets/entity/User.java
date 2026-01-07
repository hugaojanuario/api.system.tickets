package spring.boot.system.tickets.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.boot.system.tickets.enums.Paper;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Paper paper;

    @Column(nullable = false)
    private LocalDateTime localDateTime;

    @PrePersist
    public void onCreate() {
        this.localDateTime = LocalDateTime.now();
    }

}
