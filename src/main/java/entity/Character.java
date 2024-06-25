package entity;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class Character {
    
    private String name;
    private Data data;

    // Empty Constructor
    public Character() {
    }

    public Character(String name, Data data) {
        this.name = name;
        this.data = data;
    }

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for data
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static Character[] readFromFile(String fileName) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, Character[].class);
        }
    }

    public static class Data {
        private String[] loves;
        private String[] likes;
        private String[] dislikes;
        private String[] hates;
        private String[] image;

        public Data() {
            // Default constructor for Jackson
        }

        // Getters and Setters for loves
        public String[] getLoves() {
            return loves;
        }

        public void setLoves(String[] loves) {
            this.loves = loves;
        }

        // Getters and Setters for likes
        public String[] getLikes() {
            return likes;
        }

        public void setLikes(String[] likes) {
            this.likes = likes;
        }

        // Getters and Setters for dislikes
        public String[] getDislikes() {
            return dislikes;
        }

        public void setDislikes(String[] dislikes) {
            this.dislikes = dislikes;
        }

        // Getters and Setters for hates
        public String[] getHates() {
            return hates;
        }

        public void setHates(String[] hates) {
            this.hates = hates;
        }

        // Getters and Setters for image
        public String[] getImage() {
            return image;
        }

        public void setImage(String[] image) {
            this.image = image;
        }
    }

}
