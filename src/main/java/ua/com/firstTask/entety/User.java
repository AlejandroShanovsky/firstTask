package ua.com.firstTask.entety;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Size;

@Component
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Getter @Setter
    private int userId;
    @Size(min = 2, max = 30)
    @Getter @Setter
    private String firstName;
    @Size(min = 2, max = 30)
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private Role role;

    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder setUserId(int userId) {
            user.setUserId(userId);
            return this;
        }

        public Builder setFirstName(String name) {
            user.setFirstName(name);
            return this;
        }

        public Builder setLastName(String lastName) {
            user.setLastName(lastName);
            return this;
        }

        public Builder setUserRole(Role role) {
            user.setRole(role);
            return this;
        }

        public User getInstance() {
            return user;
        }

    }
}
