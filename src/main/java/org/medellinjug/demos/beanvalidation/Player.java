package org.medellinjug.demos.beanvalidation;

import javax.validation.constraints.*;


import java.time.LocalDate;
import java.util.List;

public class Player {

    @NotNull
    @Size(min=10, max=20)
    @Pattern(regexp = "[a-z A-Z]*")
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Past
    private LocalDate contractDate;

    @NotEmpty
    @Size.List({@Size(min=10, groups = InternationalPlayer.class),
            @Size(min=15, max=15, groups = NationalPlayer.class)
    })
    private String passport;

    @NotEmpty
    private List<String> hobiess;

    public List<String> getHobiess() {
        return hobiess;
    }

    public void setHobiess(List<String> hobiess) {
        this.hobiess = hobiess;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +

                '}';
    }
}
