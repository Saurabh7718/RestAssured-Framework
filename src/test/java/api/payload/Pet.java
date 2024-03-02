package api.payload;

public class Pet {
	int id;
	int petId;
	int quantity;
	String status;
	String shipDate;
	String complete1;
	
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getComplete1() {
		return complete1;
	}
	public void setComplete1(String complete1) {
		this.complete1 = complete1;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public void setComplete(String complete2) {
		// TODO Auto-generated method stub
		
	}
	

}
