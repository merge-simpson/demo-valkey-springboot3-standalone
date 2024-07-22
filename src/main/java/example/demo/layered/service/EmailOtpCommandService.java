package example.demo.layered.service;

import example.common.util.random.PaddedDecimalSecuredRandom;
import example.demo.layered.entity.EmailOtp;
import example.demo.layered.exception.EmailOtpErrorCode;
import example.demo.layered.mapper.EmailOtpDtoMapper;
import example.demo.layered.repository.EmailOtpRepository;
import example.demo.layered.usecase.EmailOtpDeleteUseCase;
import example.demo.layered.usecase.EmailOtpInsertionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailOtpCommandService implements EmailOtpInsertionUseCase, EmailOtpDeleteUseCase {

    private final EmailOtpRepository emailOtpRepository;
    private final EmailOtpDtoMapper mapper;

    @Override
    public EmailOtp save(String email) {
        // 존재하는지 확인 (존재하면 기존 걸 삭제)
        Optional<EmailOtp> optional = emailOtpRepository.findById(email);
        optional.ifPresent(emailOtpRepository::delete);

        String otp = PaddedDecimalSecuredRandom.nextStrong(6);
        Integer ttl = 180;
        Instant createdAt = Instant.now();

        EmailOtp entity = mapper.toEntity(email, otp, ttl, createdAt);
        return emailOtpRepository.save(entity);
    }

    @Override
    public void deleteByOtp(String otp) {
        EmailOtp entity = emailOtpRepository.findByOtp(otp)
                .orElseThrow(EmailOtpErrorCode.OTP_NOT_FOUND::defaultException);

        emailOtpRepository.delete(entity);
    }
}
