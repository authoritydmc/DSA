package DSA.API_CALL;

import com.google.gson.annotations.SerializedName;

public class BookDataResponse {

	@SerializedName("image")
	private String image;

	@Override
	public String toString() {
		return "Book {" +
				"image='" + image + '\'' +
				", author='" + author + '\'' +
				", isbn='" + isbn + '\'' +
				", genre='" + genre + '\'' +
				", description='" + description + '\'' +
				", publisher='" + publisher + '\'' +
				", id=" + id +
				", published='" + published + '\'' +
				", title='" + title + '\'' +
				'}';
	}

	@SerializedName("author")
	private String author;

	@SerializedName("isbn")
	private String isbn;

	@SerializedName("genre")
	private String genre;

	@SerializedName("description")
	private String description;

	@SerializedName("publisher")
	private String publisher;

	@SerializedName("id")
	private int id;

	@SerializedName("published")
	private String published;

	@SerializedName("title")
	private String title;

	public String getImage(){
		return image;
	}

	public String getAuthor(){
		return author;
	}

	public String getIsbn(){
		return isbn;
	}

	public String getGenre(){
		return genre;
	}

	public String getDescription(){
		return description;
	}

	public String getPublisher(){
		return publisher;
	}

	public int getId(){
		return id;
	}

	public String getPublished(){
		return published;
	}

	public String getTitle(){
		return title;
	}
}