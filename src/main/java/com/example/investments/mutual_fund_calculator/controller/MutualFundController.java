package com.example.investments.mutual_fund_calculator.controller;

import java.util.List;

import com.example.investments.mutual_fund_calculator.model.MutualFund;
import com.example.investments.mutual_fund_calculator.service.MutualFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutualFundController {

    @Autowired
    private MutualFundService mutualFundService;

    @GetMapping("/api/mutualfunds")
    public List<MutualFund> getAllMutualFunds() {
        return mutualFundService.getAllMutualFunds();
    }

    @GetMapping("/api/future-value")
    public double calculateFutureValue(
            @RequestParam String ticker,
            @RequestParam double principal,
            @RequestParam double time) {
        return mutualFundService.calculateFutureValue(ticker, principal, time);
    }
}
