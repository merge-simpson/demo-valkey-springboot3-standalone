package example.demo.layered.mapper;

import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpInsertionResponse;
import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpReadOneResponse;
import example.demo.layered.entity.EmailOtp;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper // (componentModel = "spring") required if there is no "-Amapstruct.defaultComponentModel" in VM args on compile
public interface EmailOtpDtoMapper {
    EmailOtp toEntity(String email, String otp, Integer ttl, Instant createdAt);
    EmailOtpReadOneResponse toReadOneDto(EmailOtp entity);
    EmailOtpInsertionResponse toInsertionResponse(EmailOtp entity);
}
