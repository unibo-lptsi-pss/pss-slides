void main(String[] s) {
	System.out.println(10 + 20); // 30
	System.out.println(010 + 020); // 24
	System.out.println(0xFFFFFFFF); // -1
	System.out.println(0x7FFFFFFF); // 2147483647
	System.out.println(0x80000000); // -2147483648
	System.out.println(0x80000000 - 1); // 2147483647
	System.out.println(2147483647 + 1); // -2147483648
	System.out.println(2147483647L + 1); // 2147483648
	System.out.println((0x0F0F | 0xF0F0) == 0xFFFF); // true
	System.out.println((0x0F0F & 0xF0F0) == 0); // true
	System.out.println((0x0F0F << 4) == 0xF0F0); // true
	System.out.println((0x0F0F >> 4) == 0x00F0); // true
	System.out.println(~0x0F0F == 0xFFFFF0F0); // true
	System.out.println(10 / 3); // 3
	System.out.println(10 % 3); // 1
	System.out.println(3.5 / 51 * 51); // 3.5000000000000004
	System.out.println(3.5f / 51 * 51);// 3.5000002
}
