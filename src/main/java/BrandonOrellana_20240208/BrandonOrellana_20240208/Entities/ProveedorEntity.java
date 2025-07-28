package BrandonOrellana_20240208.BrandonOrellana_20240208.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TBPROVIDER")
@Getter @Setter @ToString @EqualsAndHashCode
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provider")
    @SequenceGenerator(name = "seq_provider",sequenceName = "seq_provider", allocationSize = 1)
    @Column(name = "PROVIDERID")
    private Long providerID;

    @Column(name = "PROVIDERNAME")
    private String providerName;

    @Column(name = "PROVIDERPHONE")
    private String providerPhone;

    @Column(name = "PROVIDERADDRESS")
    private String providerAddress;

    @Column(name = "PROVIDEREMAIL")
    private String providerEmail;

    @Column(name = "PROVIDERCODE")
    private String providerCode;

    @Column(name = "PROVIDERSTATUS")
    private Integer providerStatus;

    @Column(name = "PROVIDERCOMMENTS")
    private String providerComments;

}
