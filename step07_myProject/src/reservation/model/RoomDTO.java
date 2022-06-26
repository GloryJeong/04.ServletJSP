package reservation.model;

public class RoomDTO {

	

	private int roomId; // �� ��ȣ
	private int maxCapacity; //�ִ�����ο�
	private String price; //����
	private String region; // ����
	
	public RoomDTO(int roomId, int maxCapacity, String price, String region) {
		super();
		this.roomId = roomId;
		this.maxCapacity = maxCapacity;
		this.price = price;
		this.region = region;
		
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[�� ��ȣ : ");
		builder.append(roomId);
		builder.append(", �ִ� �����ο� : ");
		builder.append(maxCapacity);
		builder.append(", ���� : ");
		builder.append(price);
		builder.append(", ���� : ");
		builder.append(region);
		return builder.toString();
	}

	
}
