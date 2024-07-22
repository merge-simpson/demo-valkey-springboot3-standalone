package example.demo.layered.usecase;

import example.demo.layered.entity.EmailOtp;

public interface EmailOtpInsertionUseCase {
    EmailOtp save(String email);
}
