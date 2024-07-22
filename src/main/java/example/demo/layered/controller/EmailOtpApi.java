package example.demo.layered.controller;

import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpInsertionRequest;
import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpInsertionResponse;
import example.demo.layered.controller.dto.EmailOtpDto.EmailOtpReadOneResponse;
import example.demo.layered.entity.EmailOtp;
import example.demo.layered.mapper.EmailOtpDtoMapper;
import example.demo.layered.usecase.EmailOtpDeleteUseCase;
import example.demo.layered.usecase.EmailOtpInsertionUseCase;
import example.demo.layered.usecase.EmailOtpReadUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email-verification")
public final class EmailOtpApi {
    private final EmailOtpReadUseCase readUseCase;
    private final EmailOtpInsertionUseCase insertionUseCase;
    private final EmailOtpDeleteUseCase deleteUseCase;

    private final EmailOtpDtoMapper mapper;

    // CRUD for demo
    @GetMapping("/email/{email}")
    public EmailOtpReadOneResponse findByEmail(@PathVariable @Email String email) {
        return readUseCase.findOneByEmail(email);
    }

    @GetMapping("/otp/{otp}")
    public EmailOtpReadOneResponse findByOtp(@PathVariable String otp) {
        return readUseCase.findOneByOtp(otp);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmailOtpInsertionResponse append(@RequestBody @Valid EmailOtpInsertionRequest body) {
        EmailOtp entity = insertionUseCase.save(body.email());
        return mapper.toInsertionResponse(entity);
    }

    @DeleteMapping("/otp/{otp}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByOtp(@PathVariable String otp) {
        deleteUseCase.deleteByOtp(otp);
    }

    // actual api to verify otp would be required later. Above codes are just for demo CRUD.
}
