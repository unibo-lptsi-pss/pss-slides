package it.unibo.apice.oop.p18concurrency1;

public class TestCounter {
	public static void main(String[] args) {
		Counter c = new Counter(0);
        javax.swing.SwingUtilities.invokeLater(() -> {
        	new CounterGUI(c).setVisible(true);
        });
	}
}
