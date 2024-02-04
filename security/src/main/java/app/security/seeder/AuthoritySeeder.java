package app.security.seeder;

import app.security.domain.Authority;
import app.security.domain.enums.AuthorityEnum;
import app.security.repositories.AuthorityRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AuthoritySeeder {

    private final AuthorityRepository authorityRepository;

    public void seedAuthorities() {
        List<Authority> authorities = new ArrayList<>();
        for (AuthorityEnum authorityName : AuthorityEnum.values()) {
            Authority authority = Authority.builder()
                    .name(authorityName)
                    .build();
            authorities.add(authority);
        }
        authorityRepository.saveAll(authorities);
    }
}
