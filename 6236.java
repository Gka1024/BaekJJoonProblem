package bkj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mainbkj3 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int drawcount(int[] arrays, int money) {
		int temp = money;
		int count = 1;
		for (int i = 0; i < arrays.length; i++) {
			if(temp < arrays[i])
			{
				temp = money;
				count++;
			}
			temp -= arrays[i];
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int days = Integer.parseInt(st.nextToken());
		int wthdr = Integer.parseInt(st.nextToken());

		int[] money = new int[days];
		for (int i = 0; i < days; i++) {
			st = new StringTokenizer(br.readLine());
			money[i] = Integer.parseInt(st.nextToken());
		}

		int max = money[0], sum = 0;

		for (int i = 0; i < days; i++) {
			max = Math.max(max, money[i]);
			sum += money[i];
		}

		int mid = 0;

		while (max <= sum) {
			mid = (sum + max) / 2;
			if (drawcount(money, mid) > wthdr) {
				max = mid + 1;
			} else {
				sum = mid - 1;
			}
		}
		System.out.println(mid);
	}
}
