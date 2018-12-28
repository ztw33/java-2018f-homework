import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface TeamSide {
	String side();
}
