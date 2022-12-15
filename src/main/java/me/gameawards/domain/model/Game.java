package me.gameawards.domain.model;

import jakarta.persistence.*;

@Entity(name = "Games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entity_id;

    private String name;

    @Column(length = 500)
    private String description;

    private String cover;

    private long votes;

    public Long getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Long entity_id) {
        this.entity_id = entity_id;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}
