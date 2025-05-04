package me.whiteship.java8to11.chapter6.chap1;

import java.util.Optional;
import me.whiteship.java8to11.chapter5.chap1.Progress;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Optional<Progress>  getProgress() {
//        return Optional.of(progress); // null이 아닐 때!
        return Optional.ofNullable(progress); // null일 수도 있을 때!
//        return Optional.empty(); // 빈 값을 return 할 때!
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setProgress(Optional<Progress> progress) {
        if (progress.isPresent()) {
            progress.ifPresent(p -> this.progress = p);
        }
    }
}
