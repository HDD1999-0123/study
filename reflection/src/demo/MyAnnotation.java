package demo;

import java.lang.annotation.*;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
    String value() default "";
}
