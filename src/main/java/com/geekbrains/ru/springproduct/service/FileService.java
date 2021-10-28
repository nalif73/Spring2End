package com.geekbrains.ru.springproduct.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileService {

    Path saveProductImage(MultipartFile imageFile);

}
