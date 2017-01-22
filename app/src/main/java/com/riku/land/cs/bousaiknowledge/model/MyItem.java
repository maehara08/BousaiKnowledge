package com.riku.land.cs.bousaiknowledge.model;

import org.json.JSONArray;

import java.io.Serializable;

/**
 * Created by riku_maehara on 17/01/22.
 */
public class MyItem implements Serializable {
    private String title;
    private JSONArray aggregate;
    private MyContent [] contents;


    public MyContent[] getContens() {
        return contents;
    }

    public void setContens(MyContent[] contens) {
        this.contents = contens;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public class MyContent implements Serializable{
        private int id;
        private String name;
        private String opinion;
        private String graph_image_url;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpinion() {
            return opinion;
        }

        public void setOpinion(String opinion) {
            this.opinion = opinion;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getGraph_image_url() {
            return graph_image_url;
        }

        public void setGraph_image_url(String graph_image_url) {
            this.graph_image_url = graph_image_url;
        }
    }
}
