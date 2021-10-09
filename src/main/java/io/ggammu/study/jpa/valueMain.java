package io.ggammu.study.jpa;

public class valueMain {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;

        System.out.println("a == b : " + (a == b));

        Address address1 = Address.builder().city("city1").build();
        Address address2 = Address.builder().city("city2").build();

        System.out.println("address1 == address2 : " + (address1 == address2));
    }
}
