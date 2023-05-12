package com.ian.springboot.web.dto;

import com.ian.springboot.domain.user.Role;
import com.ian.springboot.domain.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersResponseDto {

    private Long id;
    private String name;
    private String email;
    private String picture;
    private Role role;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
    }
}
