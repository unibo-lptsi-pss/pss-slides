package it.unibo.apice.oop.p15io.files;

import java.io.*;
import java.util.*;

public class UseStreamDumper {

	public static void main(String[] args) throws IOException {
		
		final byte[] b = new byte[]{10,20,30};
		
		try(
			final InputStream input = new ByteArrayInputStream(b);
			final InputStream input2 = new FileInputStream(UseFile.FILE_NAME);
			final InputStream input3 = new InputStream(){ // An ad-hoc stream
				private int count = 100;
				private final Random r = new Random();
				public int read() throws IOException {
					return (this.count-- > 0 ? r.nextInt(256) : -1);
				}
			};
		) {
			StreamDumper.dump(input);
			System.out.println();
			StreamDumper.dump(input2);
			System.out.println();
			StreamDumper.dump(input3);
			System.out.println();
		}
	}
}
