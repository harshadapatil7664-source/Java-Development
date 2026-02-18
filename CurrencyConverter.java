// CURRENCY CONVERTER

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter base currency!");
            System.out.println("---Enter like following---");
            System.out.println("INR :- Indian Rupee");
            System.out.println("USD :- US Dollar");
            System.out.println("GBP :- British Pound");
            System.out.println("JPY :- Japanese Yen");
            System.out.println("CAD :- Canadian Dollar");
            System.out.println("CNY :- Chinese Yuan");
            System.out.println("SGD :- Singapore Dollar");
            System.out.println("etc..");
            System.out.print("ENTER: ");
            String base = scan.next().trim().toUpperCase();
            System.out.print("Enter target currency: ");
            String target = scan.next().trim().toUpperCase();

            String apiKey = "YOUR_KEY";
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + base;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            String search = "\"" + target + "\":";
            int index = responseBody.indexOf(search);

            if (index != -1) {

                int start = index + search.length();
                int end = responseBody.indexOf(",", start);
                double rate = Double.parseDouble(responseBody.substring(start, end));

                System.out.printf("1 %s = %.4f %s\n", base, rate, target);
                System.out.print("Enter amount: ");
                double amount = scan.nextDouble();
                double result = amount * rate;
                String symbol = getSymbol(target);
                System.out.printf("Converted Amount: %s%.2f\n", symbol, result);
            } else {
                System.out.println("Currency not found.");
            }

        } catch (Exception e) {
            System.out.println("Error while fetching data from API.");
        }
        scan.close();
    }
    public static String getSymbol(String currencyCode) {
        switch (currencyCode) {
            case "INR": return "₹"; 
            case "USD": return "$";
            case "GBP": return "£";
            case "JPY": return "¥";
            case "CAD": return "C$";
            case "CNY": return "¥";
            case "SGD": return "S$";
            default: return "";
        }
    }
}

