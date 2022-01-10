package com.inspire12.practice.lab.extern.jsonplaceholder;

public class User {
    private Company company;
    private String website;
    private String phone;
    private Address address;
    private String email;
    private String username;
    private String name;
    private int id;

    private static class Company {
        private String bs;
        private String catchPhrase;
        private String name;
    }

    private static class Address {
        private Geo geo;
        private String zipcode;
        private String city;
        private String suite;
        private String street;
    }

    private static class Geo {
        private String lng;
        private String lat;
    }
}
