package example.common.random.bean;

import example.common.random.util.PaddedDecimalSecuredRandom;
import org.springframework.stereotype.Component;

@Component // if you divide modules, you can skip this annotation and use @Bean in your configuration class.
public class DefaultPaddedDecimalRandom implements PaddedDecimalRandom {
    @Override
    public String nextStrong(int length) {
        return PaddedDecimalSecuredRandom.nextStrong(length);
    }
}
