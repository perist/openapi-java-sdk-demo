package com.tigerbrokers.stock.openapi.demo.quote;

import com.tigerbrokers.stock.openapi.client.https.client.TigerHttpClient;
import com.tigerbrokers.stock.openapi.client.https.request.quote.*;
import com.tigerbrokers.stock.openapi.client.https.response.quote.*;
import com.tigerbrokers.stock.openapi.client.struct.enums.KType;
import com.tigerbrokers.stock.openapi.client.struct.enums.Market;
import com.tigerbrokers.stock.openapi.client.struct.enums.RightOption;
import com.tigerbrokers.stock.openapi.client.struct.enums.SecType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tigerbrokers.stock.openapi.demo.DemoConstants.*;

/**
 * Description:
 * Created by lijiawen on 2018/12/20.
 */
public class QuoteV2Demo {

  private static TigerHttpClient client = new TigerHttpClient(serverUrl, tigerId, yourPrivateKey);

  @Test
  public void market_state() {
    QuoteMarketResponse response = client.execute(QuoteMarketRequest.newRequest(Market.US));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getMarketItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void all_symbols() {
    QuoteSymbolRequest request = QuoteSymbolRequest.newRequest(Market.US);
    QuoteSymbolResponse response = client.execute(request);
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getSymbols().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void all_symbol_names() {
    QuoteSymbolNameResponse response = client.execute(QuoteSymbolNameRequest.newRequest(Market.US));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getSymbolNameItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void kline() {
    List<String> symbols = new ArrayList<>();
    symbols.add("AAPL");
    QuoteKlineResponse response =
        client.execute(QuoteKlineRequest.newRequest(symbols, KType.day, "2018-10-01", "2018-12-25")
            .withLimit(1000)
            .withRight(RightOption.br));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getKlineItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void quote_real_time() {
    List<String> symbols = new ArrayList<>();
    symbols.add("AAPL");
    QuoteRealTimeQuoteResponse response = client.execute(QuoteRealTimeQuoteRequest.newRequest(symbols));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getRealTimeQuoteItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void trade_tick() {
    List<String> symbols = new ArrayList<>();
    symbols.add("AAPL");
    QuoteTradeTickResponse response = client.execute(QuoteTradeTickRequest.newRequest(symbols));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getTradeTickItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void time_line() {
    List<String> symbols = new ArrayList<>();
    symbols.add("AAPL");
    QuoteTimelineResponse response =
        client.execute(QuoteTimelineRequest.newRequest(symbols, 1544129760000L));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getTimelineItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void quote_contract() {
    List<String> symbols = new ArrayList<>();
    symbols.add("AAPL");
    QuoteContractResponse response = client.execute(QuoteContractRequest.newRequest(symbols, SecType.WAR));
    if (response.isSuccess()) {
      System.out.println(response.getContractItems());
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void quote_shortable_stocks() {
    List<String> symbols = new ArrayList<>();
    symbols.add("AAPL");
    QuoteShortableStockResponse response = client.execute(QuoteShortableStockRequest.newRequest(symbols));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getShortableStockItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }

  @Test
  public void quote_stock_trade() {
    List<String> symbols = new ArrayList<>();
    symbols.add("00700");
    symbols.add("00810");
    QuoteStockTradeResponse response = client.execute(QuoteStockTradeRequest.newRequest(symbols));
    if (response.isSuccess()) {
      System.out.println(Arrays.toString(response.getStockTradeItems().toArray()));
    } else {
      System.out.println("response error:" + response.getMessage());
    }
  }
}
