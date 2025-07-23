package com.eduardo.library.models;

import com.eduardo.library.enums.RoleUser;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMG_USER_ROLE")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "USER_STATUS")
    private RoleUser statusUser;

    @Column(nullable = false, name = "INSERT_DATETIME")
    private LocalDateTime insertDateTime;

    @Column(nullable = false, name = "UPDATE_DATETIME")
    private LocalDateTime updateDateTime;

}
