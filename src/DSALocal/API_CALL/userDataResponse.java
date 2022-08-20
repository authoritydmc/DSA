package DSA.API_CALL;

import com.google.gson.annotations.SerializedName;

public class userDataResponse {

	@SerializedName("image")
	private String image;

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("password")
	private String password;

	@SerializedName("macAddress")
	private String macAddress;

	@SerializedName("website")
	private String website;

	@SerializedName("ip")
	private String ip;

	@SerializedName("id")
	private int id;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("email")
	private String email;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("username")
	private String username;



	public String getImage(){
		return image;
	}

	public String getFirstname(){
		return firstname;
	}

	public String getPassword(){
		return password;
	}

	public String getMacAddress(){
		return macAddress;
	}

	public String getWebsite(){
		return website;
	}

	public String getIp(){
		return ip;
	}

	public int getId(){
		return id;
	}

	public String getUuid(){
		return uuid;
	}

	public String getEmail(){
		return email;
	}

	public String getLastname(){
		return lastname;
	}

	public String getUsername(){
		return username;
	}

	@Override
	public String toString() {
		return "User{" +
				"image='" + image + '\'' +
				", firstname='" + firstname + '\'' +
				", password='" + password + '\'' +
				", macAddress='" + macAddress + '\'' +
				", website='" + website + '\'' +
				", ip='" + ip + '\'' +
				", id=" + id +
				", uuid='" + uuid + '\'' +
				", email='" + email + '\'' +
				", lastname='" + lastname + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}