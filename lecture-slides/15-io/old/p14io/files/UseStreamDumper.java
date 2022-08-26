package it.unibo.apice.oop.p14io.files;

import java.io.*;
import java.util.*;

public class UseStreamDumper {

	public static void main(String[] args) throws IOException {
		
		StreamDumper dumper = StreamDumper.getStreamDumper();
		
		InputStream input = new ByteArrayInputStream(new byte[]{10,20,30});
		dumper.dump(input);
		input.close();
		System.out.println("\n");
		
		input = new FileInputStream("/home/mirko/aula/14/prova.txt");
		dumper.dump(input);
		input.close();
		System.out.println("\n");
		
		input = new InputStream(){ // An ad-hoc stream
			int count = 100;
			Random r = new Random();
			public int read() throws IOException {
				return (this.count-- > 0 ? r.nextInt(256) : -1);
			}
		};
		dumper.dump(input);
		input.close();
	}
}
