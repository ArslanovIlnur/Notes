package org.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;

    @Column(name = "heading")
    private String heading;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Notes() {
    }

    public Notes(int id, int userId, String heading, String text, User user) {
        this.id = id;
        this.userId = userId;
        this.heading = heading;
        this.text = text;
        this.user = user;
    }

    public Notes(int userId, String heading, String text, User user) {
        this.userId = userId;
        this.heading = heading;
        this.text = text;
        this.user = user;
    }

    public Notes(int id, int userId, String heading, String text) {
        this.id = id;
        this.userId = userId;
        this.heading = heading;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", userId=" + userId +
                ", heading='" + heading + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
