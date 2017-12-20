package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String genre;
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public Document getDocument() {
        return new Document()
                .append("title", this.title)
                .append("authorFirstName", this.authorFirstName)
                .append("authorLastName", this.authorLastName)
                .append("genre", this.genre)
                .append("description", this.description);
    }
}
