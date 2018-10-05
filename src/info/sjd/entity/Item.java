package info.sjd.entity;

public class Item {

	String url;
	String articleID;
	String title;
	String description;
	String rating;
	String price;
	String availability;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("    <item>").append(System.lineSeparator());
		sb.append("       <url>").append(url).append("</url>").append(System.lineSeparator());
		sb.append("       <articleID>").append(articleID).append("</articleID>").append(System.lineSeparator());
		sb.append("       <title>").append(title).append("</title>").append(System.lineSeparator());
		sb.append("       <description>").append(description).append("</description>").append(System.lineSeparator());
		sb.append("       <price>").append(price).append("</price>").append(System.lineSeparator());
		sb.append("       <rating>").append(rating).append("</rating>").append(System.lineSeparator());
		sb.append("       <availability>").append(availability).append("</availability>").append(System.lineSeparator());
		sb.append("    </item>");

		return sb.toString();
	}

}
