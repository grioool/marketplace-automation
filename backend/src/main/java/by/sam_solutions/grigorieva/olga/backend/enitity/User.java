package by.sam_solutions.grigorieva.olga.backend.enitity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "`user`")
@Data
public class User extends PrimaryKey {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "wb_key")
    private String wildBerriesKeys;

    @Column(name = "ozon_key")
    private String ozonKey;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_subscribed")
    private Boolean isSubscribed;

}