package main.java.com.Assesment.backend.appConfig.Model;

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

    public CustomerDetails() {
    }

    public CustomerDetails(String name, String email, Date dob, Occupation occupation) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.occupation = occupation;
        // Implement logic to set customer group based on rules in the service layer.
    }

    // Getters and Setters

    // You can generate these using your IDE or manually write them.

    // Enums for Occupation and CustomerGroup

    public enum Occupation {
        DEVELOPER,
        CHEF,
        PLUMBER,
        CARPENTER,
        OTHER
    }

    public enum CustomerGroup {
        HIKEON,
        CHEF,
        DEVELOPER,
        NA
    }
    
}
