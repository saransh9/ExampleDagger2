package demo.daggerexmaple;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.Policy;

import javax.inject.Scope;

/**
 * Created by saransh on 05/03/18.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface MainActivityScope {
}
