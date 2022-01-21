package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setWildBerriesKeys(dto.getWildBerriesKeys());
        user.setUsername(dto.getUsername());
        user.setNameCompany(dto.getNameCompany());
        user.setIsBlocked(dto.getIsBlocked());
        user.setIsSubscribed(dto.getIsSubscribed());
        return user;
    }

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setWildBerriesKeys(user.getWildBerriesKeys());
        userDto.setUsername(user.getUsername());
        userDto.setNameCompany(user.getNameCompany());
        userDto.setIsBlocked(user.getIsBlocked());
        userDto.setIsSubscribed(user.getIsSubscribed());
        return userDto;
    }

    @NotEmpty
    private int id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String username;

    @NotEmpty
    private String nameCompany;

    @NotEmpty
    private String wildBerriesKeys;

    @NotEmpty
    private Boolean isBlocked;

    @NotEmpty
    private Boolean isSubscribed;
}
