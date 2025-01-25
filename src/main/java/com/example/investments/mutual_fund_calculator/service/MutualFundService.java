package com.example.investments.mutual_fund_calculator.service;

import com.example.investments.mutual_fund_calculator.model.MutualFund;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutualFundService {

    public List<MutualFund> getAllMutualFunds() {
        return List.of(
                new MutualFund("VFIAX", "Vanguard 500 Index Fund", 1.02),
                new MutualFund("FXAIX", "Fidelity 500 Index Fund", 1.01),
                new MutualFund("SWPPX", "Schwab S&P 500 Index Fund", 1.03),
                new MutualFund("VIGAX", "Vanguard Growth Index Fund", 1.09),
                new MutualFund("VTSAX", "Vanguard Total Stock Market Index Fund", 1.04),
                new MutualFund("BND", "Vanguard Total Bond Market Index Fund", 0.35),
                new MutualFund("VEMAX", "Vanguard Emerging Markets Stock Index Fund", 1.20),
                new MutualFund("VFIIF", "Vanguard 500 Index Fund Institutional Plus", 1.02),
                new MutualFund("VGHAX", "Vanguard Growth & Income Fund", 0.85),
                new MutualFund("VYM", "Vanguard High Dividend Yield ETF", 0.90),
                new MutualFund("SCHD", "Schwab U.S. Dividend Equity ETF", 0.91),
                new MutualFund("VIG", "Vanguard Dividend Appreciation ETF", 0.87),
                new MutualFund("SPY", "SPDR S&P 500 ETF Trust", 1.03),
                new MutualFund("IVV", "iShares Core S&P 500 ETF", 1.03),
                new MutualFund("VOO", "Vanguard S&P 500 ETF", 1.02),
                new MutualFund("IXUS", "iShares Core MSCI Total International Stock ETF", 1.14),
                new MutualFund("VTI", "Vanguard Total Stock Market ETF", 1.03),
                new MutualFund("VFH", "Vanguard Financials ETF", 1.10),
                new MutualFund("VHT", "Vanguard Health Care ETF", 0.92),
                new MutualFund("VIGI", "Vanguard International Dividend Appreciation ETF", 0.95)
        );
    }

    public double calculateFutureValue(String ticker, double principal, double time) {
        // Hardcoded rates for simplicity
        double riskFreeRate = 0.03; // 3% risk-free rate
        double marketReturnRate = 0.08; // 8% market return rate

        // Find the mutual fund by ticker
        MutualFund mutualFund = getAllMutualFunds().stream()
                .filter(fund -> fund.getTicker().equalsIgnoreCase(ticker))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid ticker: " + ticker));

        // Calculate the rate
        double beta = mutualFund.getBeta();
        double rate = riskFreeRate + beta * (marketReturnRate - riskFreeRate);

        // Calculate future value
        return principal * Math.exp(rate * time);
    }
}
