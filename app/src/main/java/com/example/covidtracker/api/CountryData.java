package com.example.covidtracker.api;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CountryData {
    @SerializedName("updated")
    private String update;
    private String country;
    private String cases;
    private String todayCases;
    private String deaths;
    private String todayDeaths;
    private String todayRecovered;
    private String recovered;
    private String active;
    private String tests;
    private Map<String, String> countryInfo;


    public CountryData(String update, String country, String cases, String todayCases, String deaths, String todayDeaths, String todayRecovered, String recovered, String active, String tests, Map<String, String> countryInfo) {
        this.update = update;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.todayRecovered = todayRecovered;
        this.recovered = recovered;
        this.active = active;
        this.tests = tests;
        this.countryInfo = countryInfo;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public Map<String, String> getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(Map<String, String> countryInfo) {
        this.countryInfo = countryInfo;
    }
}
