package mocktest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PortfolioTester {

    Portfolio portfolio;
    StockService stockService;

    public static void init() {
        PortfolioTester tester = new PortfolioTester();
        tester.setUp();
    }

    public void setUp() {
        //Create a portfolio object which is to be tested		

        //Create the mock object of stock service
        stockService = mock(StockService.class);

        //set the stockService to the portfolio
        portfolio.setStockService(stockService);
    }
}
