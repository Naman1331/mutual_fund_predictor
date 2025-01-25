package com.example.investments.mutual_fund_calculator.model;

public class MutualFund {
    private String ticker;
    private String name;
    private double beta;

    // Constructor
    public MutualFund(String ticker, String name, double beta) {
        this.ticker = ticker;
        this.name = name;
        this.beta = beta;
    }

    // Getters and Setters
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }
}
