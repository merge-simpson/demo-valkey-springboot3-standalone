package example.demo.layered.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public final class EmailOtpDto {
    private EmailOtpDto() {}

    @Builder
    public record EmailOtpInsertionRequest(
            @NotBlank
            @Email
            String email
    ) {}

    @Builder
    public record EmailOtpInsertionResponse(
            String email,
            String otp,
            @JsonInclude(Include.NON_NULL)
            Integer ttl
    ) {}

    @Builder
    public record EmailOtpReadOneResponse(
            String email,
            String otp,
            @JsonInclude(Include.NON_NULL)
            Integer ttl
    ) {}
}
