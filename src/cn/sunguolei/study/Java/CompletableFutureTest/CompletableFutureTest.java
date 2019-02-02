package src.cn.sunguolei.study.Java.CompletableFutureTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author GuoLei Sun
 * Date: 2018/10/17 2:24 PM
 */
public class CompletableFutureTest {
    private String name;


    CompletableFutureTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//
//            } catch (Exception e) {
//                futurePrice.completeExceptionally(e);
//            }
//        }).start();
//        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> findPrices(String product) {

        List<CompletableFutureTest> shops = Arrays.asList(
                new CompletableFutureTest("BestPrice"),
                new CompletableFutureTest("LetsSaveBig"),
                new CompletableFutureTest("MyFavoriteShop"),
                new CompletableFutureTest("MyFavoriteShop1"),
                new CompletableFutureTest("MyFavoriteShop2"),
                new CompletableFutureTest("MyFavoriteShop3"),
                new CompletableFutureTest("MyFavoriteShop4"),
                new CompletableFutureTest("MyFavoriteShop5"),
                new CompletableFutureTest("MyFavoriteShop6"),
                new CompletableFutureTest("MyFavoriteShop7"),
                new CompletableFutureTest("MyFavoriteShop8"),
                new CompletableFutureTest("MyFavoriteShop9"),
                new CompletableFutureTest("BuyItAll"),
                new CompletableFutureTest("BuyItAll1"));

        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        ).collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
//        return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CompletableFutureTest cfTest = new CompletableFutureTest("test");
//        System.out.println(cfTest.getPrice("hello"));
        Future<Double> futurePrice = cfTest.getPriceAsync("my favourite product");
        try {
            System.out.println(futurePrice.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long start = System.nanoTime();
        System.out.println(cfTest.findPrices("myPhone27S"));
        long duration = (System.nanoTime() -start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
