package org.medellinjug.demos.beanvalidation;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ValidationTest {



    @Test
    public void fullWrongValidation() {
        /*All properties have wrong values*/
        Player player = new Player();
        player.setName(null);
        player.setEmail("invalid mail");
        player.setContractDate(LocalDate.of(2018, 1, 23));
        player.setHobiess(null);
        player.setPassport("12345");

        this.validation( player, NationalPlayer.class );

    }

    @Test
    public void emailValidation() {
        /*Email value is not a valid address*/
        Player player = new Player();

        player.setName("Hillmer Chona");
        player.setEmail("invalid mail@gmail.com");
        player.setContractDate(LocalDate.of(2016, 1, 23));
        player.setHobiess(List.of("Baseball","Hiking"));
        player.setPassport("123456789012345");

        this.validation( player, NationalPlayer.class );


    }

    @Test
    public void groupValidation() {
        /*Passport number is not a valid, its size must be 15*/
        Player player = new Player();
        player.setName("Hillmer Chona");
        player.setEmail("my-mail@gmail.com");
        player.setContractDate(LocalDate.of(2016, 1, 23));
        player.setHobiess(List.of("Baseball","Hiking"));
        player.setPassport("1234567890");

        this.validation( player, NationalPlayer.class );

    }

    @Test
    public void fullOkValidation() {
        /*All properties have good values*/
        Player player = new Player();
        player.setName("Hillmer Chona");
        player.setEmail("my-mail@gmail.com");
        player.setContractDate(LocalDate.of(2016, 1, 23));
        player.setHobiess(List.of("Baseball","Hiking"));
        player.setPassport("123456789012345");

        this.validation( player, NationalPlayer.class );

    }

    private void validation(Player player, Class cl) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Player>> violationsGeneral = validator.validate( player );

        for ( ConstraintViolation<Player> constraintViolation : violationsGeneral ) {
            System.out.println( "=======" );
            System.out.println( "Message: " + constraintViolation.getMessage() );
            System.out.println( "Property path: " + constraintViolation.getPropertyPath() );
            System.out.println( "Annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation().annotationType() );
        }

        Set<ConstraintViolation<Player>> violationsByClass = validator.validate(player, cl);

        for (ConstraintViolation<Player> constraintViolation : violationsByClass) {
            System.out.println("=======");
            System.out.println("Message: " + constraintViolation.getMessage());
            System.out.println("Property path: " + constraintViolation.getPropertyPath());
            System.out.println("Annotation: " + constraintViolation.getConstraintDescriptor().getAnnotation().annotationType());
        }
    }
}
