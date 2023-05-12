package com.ian.springboot.service.users;

import com.ian.springboot.domain.user.Users;
import com.ian.springboot.domain.user.UsersRepository;
import com.ian.springboot.web.dto.UsersResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersResponseDto findById(Long id) {
        Users entity = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다. id=" + id));

        return new UsersResponseDto(entity);
    }

    public UsersResponseDto findByEmail(String email) {
        Users entity = usersRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다. email=" + email));

        return new UsersResponseDto(entity);
    }
}
