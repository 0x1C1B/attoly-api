package de.x1c1b.attoly.api.domain.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserUpdatePayload {

    private String password;

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }
}
