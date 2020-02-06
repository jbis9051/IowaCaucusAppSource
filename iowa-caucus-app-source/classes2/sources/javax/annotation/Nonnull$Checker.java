package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class Nonnull$Checker implements TypeQualifierValidator<Nonnull> {
    public When forConstantValue(Nonnull nonnull, Object obj) {
        if (obj == null) {
            return When.NEVER;
        }
        return When.ALWAYS;
    }
}
