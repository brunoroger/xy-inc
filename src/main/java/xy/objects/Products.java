package xy.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name= "products")
public class Products implements EntityObject<Integer>{
	
	@Id
	@Column(name = "id", length = 5)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty
	@Column(name = "name", length = 45)
	private String name;
	
	@NotNull
	@NotEmpty
	@Column(name = "description", length = 500)
	private String description;
	
	@NotNull
	@DecimalMin(value = "0.01")
	@Column(name = "price", length = 9)
	private double price;
	
	@NotNull
	@NotEmpty
	@Column(name = "category", length = 45)
	private String category;

	public void setPrimaryKey(Integer id) {
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
}
