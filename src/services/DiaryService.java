package services;

import dto.request.LogInRequest;
import dto.request.RegisterRequest;

public interface DiaryService {
    long numberOfDiaries();
    void register(RegisterRequest request);
    void logIn(LogInRequest request);
}
