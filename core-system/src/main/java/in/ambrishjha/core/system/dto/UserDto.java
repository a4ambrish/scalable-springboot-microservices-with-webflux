package in.ambrishjha.core.system.dto;

public class UserDto {

    private Long id = 3863L;
    private String name = "A Sample User from Core System";
    
    
	public UserDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
