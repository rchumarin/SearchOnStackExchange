package io.piano.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StackExchange {

    private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private String[] tags;
    private Owner owner;
    private Long accepted_answer_id;
    private Boolean is_answered;
    private Integer view_count;
    private Long closed_date;
    private Long protected_date;
    private Integer answer_count;
    private Integer score;
    private Long last_activity_date;
    private Long last_edit_date;
    private String creation_date;
    private Long question_id;
    private String link;
    private String closed_reason;
    private String title;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Long getAccepted_answer_id() {
        return accepted_answer_id;
    }

    public void setAccepted_answer_id(Long accepted_answer_id) {
        this.accepted_answer_id = accepted_answer_id;
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

    public Long getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(Long last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public Boolean getIs_answered() {
        return is_answered;
    }

    public void setIs_answered(Boolean is_answered) {
        this.is_answered = is_answered;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Long getProtected_date() {
        return protected_date;
    }

    public void setProtected_date(Long protected_date) {
        this.protected_date = protected_date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getClosed_date() {
        return closed_date;
    }

    public void setClosed_date(Long closed_date) {
        this.closed_date = closed_date;
    }

    public String getClosed_reason() {
        return closed_reason;
    }

    public void setClosed_reason(String closed_reason) {
        this.closed_reason = closed_reason;
    }
}