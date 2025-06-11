package com.example.lab3_bai2;

public class FootballLegend {
    private String name;
    private String birthDate;
    private int profileImageResId;
    private int countryFlagResId;

    public FootballLegend(String name, String birthDate, int profileImageResId, int countryFlagResId) {
        this.name = name;
        this.birthDate = birthDate;
        this.profileImageResId = profileImageResId;
        this.countryFlagResId = countryFlagResId;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getProfileImageResId() {
        return profileImageResId;
    }

    public int getCountryFlagResId() {
        return countryFlagResId;
    }
}