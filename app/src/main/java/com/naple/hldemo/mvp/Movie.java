package com.naple.hldemo.mvp;

import java.util.List;

/**
 * created by hl at 2018/5/12
 * com.naple.hldemo.mvp
 */
public class Movie {

    private String title;
    private List<Subjects> subjects;


    public String getTitle() {
        return title;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }


    public static class Subjects {
        private String title, year, id;

        public Subjects(String title, String year, String id) {
            this.title = title;
            this.year = year;
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getYear() {
            return year;
        }

        public String getId() {
            return id;
        }
    }
}
