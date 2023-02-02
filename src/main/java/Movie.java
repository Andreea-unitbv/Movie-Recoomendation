import java.sql.Date;

public class Movie {
    private String title,genre,director,studio;
    private Integer likes;
    private Date releaseDate;

    public Movie(String title, String genre, String director, String studio, Date releaseDate) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.studio = studio;
        this.likes = 0;
        this.releaseDate = releaseDate;
    }


    public void Like(){
        likes++;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public Integer getLikes() {
        return likes;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

}
