package de.x1c1b.attoly.api.domain;

import de.x1c1b.attoly.api.domain.exception.EmailAlreadyInUseException;
import de.x1c1b.attoly.api.domain.exception.EntityNotFoundException;
import de.x1c1b.attoly.api.domain.model.User;
import de.x1c1b.attoly.api.domain.payload.UserCreationPayload;
import de.x1c1b.attoly.api.domain.payload.UserUpdatePayload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    User findById(UUID id) throws EntityNotFoundException;

    User findByEmail(String email) throws EntityNotFoundException;

    boolean existsById(UUID id);

    boolean existsByEmail(String email);

    User create(UserCreationPayload payload) throws EmailAlreadyInUseException;

    User updateById(UUID id, UserUpdatePayload payload) throws EntityNotFoundException;

    User updateByEmail(String email, UserUpdatePayload payload) throws EntityNotFoundException;

    /**
     * Assigns the specified roles to a user if they don't already have them.
     *
     * @param id        The unique identifier of the user.
     * @param roleNames The names of the roles to assign.
     * @return The updated user.
     * @throws EntityNotFoundException  Thrown if the user cannot be found.
     * @throws IllegalArgumentException Is thrown if one of the named roles is not known.
     */
    User assignRolesById(UUID id, String... roleNames) throws EntityNotFoundException, IllegalArgumentException;

    /**
     * Assigns the specified roles to a user if they don't already have them.
     *
     * @param email     The unique email of the user.
     * @param roleNames The names of the roles to assign.
     * @return The updated user.
     * @throws EntityNotFoundException  Thrown if the user cannot be found.
     * @throws IllegalArgumentException Is thrown if one of the named roles is not known.
     */
    User assignRolesByEmail(String email, String... roleNames) throws EntityNotFoundException, IllegalArgumentException;

    /**
     * Revokes a role from a user if they own it, otherwise nothing is changed.
     *
     * @param id       The unique identifier of the user.
     * @param roleName The name of the role to remove.
     * @return The updated user.
     * @throws EntityNotFoundException  Thrown if the user cannot be found.
     * @throws IllegalArgumentException Is thrown if the role is not known.
     */
    User removeRoleById(UUID id, String roleName) throws EntityNotFoundException, IllegalArgumentException;

    /**
     * Revokes a role from a user if they own it, otherwise nothing is changed.
     *
     * @param email    The unique email of the user.
     * @param roleName The name of the role to remove.
     * @return The updated user.
     * @throws EntityNotFoundException  Thrown if the user cannot be found.
     * @throws IllegalArgumentException Is thrown if the role is not known.
     */
    User removeRoleByEmail(String email, String roleName) throws EntityNotFoundException, IllegalArgumentException;

    void deleteById(UUID id) throws EntityNotFoundException;

    void deleteByEmail(String email) throws EntityNotFoundException;
}