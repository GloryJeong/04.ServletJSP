package reservation.model;

public class RoomDTO {

	

	private int roomId; // 방 번호
	private int maxCapacity; //최대수용인원
	private String price; //가격
	private String region; // 지역
	
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
		builder.append("[방 번호 : ");
		builder.append(roomId);
		builder.append(", 최대 수용인원 : ");
		builder.append(maxCapacity);
		builder.append(", 가격 : ");
		builder.append(price);
		builder.append(", 지역 : ");
		builder.append(region);
		return builder.toString();
	}

	
}
