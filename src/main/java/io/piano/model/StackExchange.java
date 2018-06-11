package io.piano.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StackExchange {

    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private Owner owner;
    private Integer answer_count;
    private Long last_activity_date;
    private String creation_date;
    private Long question_id;
    private String link;
    private String title;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Integer getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(Integer answer_count) {
        this.answer_count = answer_count;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Long creation_date) {
        this.creation_date = formatter.format(new Date(creation_date));
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(Long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }
}