package it.unibo.apice.oop.p18concurrency2;

public class RWLock {

	private int nReaders;
	private boolean writerPresent;
	
	public RWLock(){
		nReaders = 0;
		writerPresent = false;
	}
	
	public synchronized void acquireReadLock() throws InterruptedException {
		while (writerPresent){
			wait();
		}
		nReaders++;
	}

	public synchronized void releaseReadLock(){
		nReaders--;
		if (nReaders == 0){
			notifyAll();
		}
	}

	public synchronized void acquireWriteLock() throws InterruptedException {
		while (nReaders > 0 || writerPresent){
			wait();
		}
		writerPresent = true;
	}

	public synchronized void releaseWriteLock(){
		writerPresent = false;
		notifyAll();
	}
}
