package main.java.com.Assesment.backend.appConfig.Model;
@Entity
@Table(name = "CustomerDetails")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private Date dob;

    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Column(name = "customer_group")
    private CustomerGroup customerGroup;

    // Constructors, getters, and setters

    // Enums for Occupation and CustomerGroup
}