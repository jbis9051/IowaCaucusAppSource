package javax.annotation;

import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class MatchesPattern$Checker implements TypeQualifierValidator<MatchesPattern> {
    public When forConstantValue(MatchesPattern matchesPattern, Object obj) {
        if (Pattern.compile(matchesPattern.value(), matchesPattern.flags()).matcher((String) obj).matches()) {
            return When.ALWAYS;
        }
        return When.NEVER;
    }
}
