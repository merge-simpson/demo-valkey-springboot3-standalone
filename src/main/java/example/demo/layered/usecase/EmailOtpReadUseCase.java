package example.demo.layered.usecase;

import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpReadOneResponse;

public interface EmailOtpReadUseCase {
    EmailOtpReadOneResponse findOneByEmail(String email);
    EmailOtpReadOneResponse findOneByOtp(String otp);
}
