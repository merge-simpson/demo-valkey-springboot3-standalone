package example.demo.layered.repository;

import example.demo.layered.entity.EmailOtp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailOtpRepository extends CrudRepository<EmailOtp, String> {
    Optional<EmailOtp> findByOtp(String otp);
}
