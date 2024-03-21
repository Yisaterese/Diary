package services;

import dto.request.RegisterRequest;

public interface DiaryService {
    long numberOfDiaries();
    void register(RegisterRequest request);
    boolean logIn(String userName, String password);
}
