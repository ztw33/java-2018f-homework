import java.lang.annotation.*;

@Documented
@Target(ElementType.PACKAGE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorAnno {
    String name() default "Tian Chenjiang";
    int version() default 1;
}
