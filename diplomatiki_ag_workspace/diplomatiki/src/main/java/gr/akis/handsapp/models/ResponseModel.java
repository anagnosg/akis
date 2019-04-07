package gr.anagnosg.schoolservices.models;



public class ResponseModel<E> { // Όταν γράφουμε E μπορεί να μπει οποιοδηποτε αντικείμενο.
	private boolean success = true;
	
	private E data;
	private String message ="Success";
	private int code;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	
	public void setError(String message,Integer code) {
		this.message = message;
		this.code = code;
		this.success = false;
	}
}
