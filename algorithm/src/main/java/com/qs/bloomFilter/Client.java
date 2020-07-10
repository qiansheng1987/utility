package com.qs.bloomFilter;

import com.google.common.annotations.Beta;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class Client {

	private static BloomFilter<CharSequence> bloomFilter;

	static {
		bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 100000000, 0.000001);
		for (int i = 0; i <10000 ; i++) {
			bloomFilter.put("" + i);
		}
	}

	public static void main(String[] args) {

		System.out.println(bloomFilter.mightContain("" + 3));
		System.out.println(bloomFilter.mightContain("" + 10000001));
		System.out.println(bloomFilter.mightContain("" + 10000011));
	}
}
