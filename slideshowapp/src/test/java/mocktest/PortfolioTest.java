/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocktest;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Phillip
 */
public class PortfolioTest {

    public PortfolioTest() {
    }

    /**
     * Test of main method, of class PortfolioTester.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        Portfolio portfolio = new Portfolio();
        
        StockService stockService = (Stock stock) -> {
            return 50.00;
        };
        stockService = mock(StockService.class);
        List<Stock> stocks = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 50);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        //add stocks to the portfolio
        portfolio.setStocks(stocks);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(100.0);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

    }

}
