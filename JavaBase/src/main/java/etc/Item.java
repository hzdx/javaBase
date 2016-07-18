package etc;

import java.sql.Timestamp;

public class Item {
	private Integer id;
	private String name;
	private Integer price;
	private String detail;
	private String pic;
	private Timestamp createTime;

	public Item() {
	}

	public Item(Integer id, String name, Integer price, String detail, String pic, Timestamp createTime) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.pic = pic;
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public String getDetail() {
		return detail;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPic() {
		return pic;
	}

	public Integer getPrice() {
		return price;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
