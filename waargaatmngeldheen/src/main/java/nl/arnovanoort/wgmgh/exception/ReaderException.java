package nl.arnovanoort.wgmgh.exception;

public class ReaderException extends RuntimeException {

	Exception exception;
	
	public ReaderException(String message, Exception e){
		super(message);
		this.exception = e;
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
		exception.printStackTrace();
	}
}
