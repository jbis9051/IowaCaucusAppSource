package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class Nonnegative$Checker implements TypeQualifierValidator<Nonnegative> {
    public When forConstantValue(Nonnegative nonnegative, Object obj) {
        if (!(obj instanceof Number)) {
            return When.NEVER;
        }
        Number number = (Number) obj;
        boolean z = true;
        if (!(number instanceof Long) ? !(number instanceof Double) ? !(number instanceof Float) ? number.intValue() >= 0 : number.floatValue() >= 0.0f : number.doubleValue() >= 0.0d : number.longValue() >= 0) {
            z = false;
        }
        if (z) {
            return When.NEVER;
        }
        return When.ALWAYS;
    }
}
