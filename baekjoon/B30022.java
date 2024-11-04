package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B30022 {

    static Product[] products;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nab = br.readLine().split(" ");
        int n = Integer.parseInt(nab[0]);
        int a = Integer.parseInt(nab[1]);
        int b = Integer.parseInt(nab[2]);

        // 1. p - q 배열
        products = new Product[n];
        for (int i = 0; i < n; i++) {
            String[] pq = br.readLine().split(" ");
            long p = Long.parseLong(pq[0]);
            long q = Long.parseLong(pq[1]);
            products[i] = new Product(p, q);
        }

        // 2. abs(A - B)를 기준으로 정렬
        Arrays.sort(products);

        // 3. 차례로 선택하면서 합 구하기
        int i = 0;
        while (a > 0 && b > 0 && i < n) {
            Product product = products[i];
            if (product.sub > 0) { // 상점 2 물건 선택
                b--;
                result += product.q;
            } else if (product.sub < 0) { // 상점 1 물건 선택
                a--;
                result += product.p;
            } else { // product.sub == 0 // 어디든 선택
                a--;
                result += product.p;
            }
            i++;
        }
        // 선택하지 않은 남은 물건 선택
        if (a == 0) {
            for (int j = i; j < n; j++) {
                result += products[j].q;
            }
        } else if (b == 0) {
            for (int j = i; j < n; j++) {
                result += products[j].p;
            }
        }

        System.out.println(result);
    }

    static class Product implements Comparable<Product> {

        long p;
        long q;
        long sub;

        Product(long p, long q) {
            this.p = p;
            this.q = q;
            this.sub = p - q;
        }

        @Override
        public int compareTo(Product o) {
            return (int) (Math.abs(o.sub) - Math.abs(this.sub));
        }
    }

    static void printProducts() {
        Arrays.stream(products).forEach(p -> System.out.println(p.p + " " + p.q));
    }
}
