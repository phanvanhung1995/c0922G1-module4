package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class SongDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 800, message = "số ký tự từ 1-300 ký tự")
    @Pattern(regexp = "^([\\p{L}\\s]|\\d)+$",
            message = "tên không chứa ký tự đặc biệt")
    private String name;
    @Pattern(regexp = "^[([\\p{L}\\s]|\\d)+]{1,5}$", message = "tên không chứa ký tự đặc biệt và dưới 300 ký tự")
    private String singer;
    @Size(min = 1, max = 300, message = "số ký tự từ 1-300 ký tự")
    @Pattern(regexp = "^([\\p{L}\\s]|\\d)+$", message = "tên không chứa ký tự đặc biệt")
    private String kindOfMusic;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }

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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
