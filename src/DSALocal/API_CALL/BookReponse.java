package DSA.API_CALL;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BookReponse {

	@SerializedName("total")
	private int total;

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private List<BookDataResponse> data;

	@SerializedName("status")
	private String status;

	public int getTotal(){
		return total;
	}

	public int getCode(){
		return code;
	}

	public List<BookDataResponse> getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}
}