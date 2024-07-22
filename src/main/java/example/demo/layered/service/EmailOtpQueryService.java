package example.demo.layered.service;

import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpReadOneResponse;
import example.demo.layered.entity.EmailOtp;
import example.demo.layered.exception.EmailOtpErrorCode;
import example.demo.layered.mapper.EmailOtpDtoMapper;
import example.demo.layered.repository.EmailOtpRepository;
import example.demo.layered.usecase.EmailOtpReadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailOtpQueryService implements EmailOtpReadUseCase {

    private final EmailOtpRepository emailOtpRepository;
    private final EmailOtpDtoMapper mapper;

    @Override
    public EmailOtpReadOneResponse findOneByEmail(String email) {
        EmailOtp entity = emailOtpRepository.findById(email)
                .orElseThrow(EmailOtpErrorCode.OTP_NOT_FOUND::defaultException);

        return mapper.toReadOneDto(entity);
    }

    @Override
    public EmailOtpReadOneResponse findOneByOtp(String otp) {
        EmailOtp entity = emailOtpRepository.findByOtp(otp)
                .orElseThrow(EmailOtpErrorCode.OTP_NOT_FOUND::defaultException);

        return mapper.toReadOneDto(entity);
    }
}
