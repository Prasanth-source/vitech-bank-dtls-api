package vitech.bank.com.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Bankmodel {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
   private String customerName;
   private String bankName;
   private String accountType;
   private String branchName;
   private String accountNumber;
   private Integer atmPin;
   private String ifscCode;
   private Float depositeAmount;
   private String mailId;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public Integer getAtmPin() {
	return atmPin;
}
public void setAtmPin(Integer atmPin) {
	this.atmPin = atmPin;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public Float getDepositeAmount() {
	return depositeAmount;
}
public void setDepositeAmount(Float depositeAmount) {
	this.depositeAmount = depositeAmount;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
@Override
public String toString() {
	return "Bankmodel [id=" + id + ", customerName=" + customerName + ", bankName=" + bankName + ", accountType="
			+ accountType + ", branchName=" + branchName + ", accountNumber=" + accountNumber + ", atmPin=" + atmPin
			+ ", ifscCode=" + ifscCode + ", depositeAmount=" + depositeAmount + ", mailId=" + mailId + "]";
}
public Bankmodel(Integer id, String customerName, String bankName, String accountType, String branchName,
		String accountNumber, Integer atmPin, String ifscCode, Float depositeAmount, String mailId) {
	super();
	this.id = id;
	this.customerName = customerName;
	this.bankName = bankName;
	this.accountType = accountType;
	this.branchName = branchName;
	this.accountNumber = accountNumber;
	this.atmPin = atmPin;
	this.ifscCode = ifscCode;
	this.depositeAmount = depositeAmount;
	this.mailId = mailId;
}
public Bankmodel() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
   
}

