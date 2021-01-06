package com.musicapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "vui lòng nhập tên đăng nhập")
    @Size(min = 2, max = 20, message = "độ dài từ 2 đến 20 ký tự")
    private String username;
    @NotEmpty(message = "vui lòng nhập password")
    private String password;

}
