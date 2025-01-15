package br.com.jmdev.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AuthorDTO {
    private String name;
    @JsonAlias("birth_year")
    private int birthYear;
    @JsonAlias("death_year")
    private int deathYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }
}
