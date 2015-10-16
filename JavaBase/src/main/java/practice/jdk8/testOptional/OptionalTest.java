package practice.jdk8.testOptional;

import java.util.Optional;

public class OptionalTest {

  public static void main(String[] args) {
    //Optional< String > fullName = Optional.ofNullable( null);
    Optional< String > fullName = Optional.ofNullable("aaa");
    System.out.println( "Full Name is set? "+ fullName.isPresent() );       
    System.out.println( "Full Name: "+ fullName.orElseGet( () -> "[none]") );
    System.out.println( fullName.map( s -> "Hey "+ s + "!").orElse( "Hey Stranger!") );

  }

}
