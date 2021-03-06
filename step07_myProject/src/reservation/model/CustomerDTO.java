package reservation.model;

public class CustomerDTO {
	private String customerId;
	private int headCount;
	private String customerName;
	private String phoneNumber;
	

public CustomerDTO(String customerId,  int headCount, String customerName,  String phoneNumber) {
	super();
	this.customerId = customerId;
	this.headCount = headCount;
	this.customerName = customerName;
	this.phoneNumber = phoneNumber;
}

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public int getHeadCount() {
	return headCount;
}

public void setHeadCount(int headCount) {
	this.headCount = headCount;
}



public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

@Override
public String toString() {
//	return "CustomerDTO [customerId=" + customerId + ", headCount=" + headCount + ", customerName=" + customerName
//			+ ", phoneNumber=" + phoneNumber + "]";
	StringBuilder builder = new StringBuilder();
	builder.append("[???? ID : ");
	builder.append(customerId);
	builder.append(", ???? ?̸? : ");
	builder.append(customerName);
	builder.append(", ?ִ? ?ο? : ");
	builder.append(headCount);
	builder.append(", ???? ????ó : ");
	builder.append(phoneNumber);
	return builder.toString();
}


	
	
	
}
