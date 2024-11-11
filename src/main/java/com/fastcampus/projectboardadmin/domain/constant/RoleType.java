package com.fastcampus.projectboardadmin.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
/**
 * `BoardAdminPrincipal`을 사용하는 외부 클래스의 Spring Security 의존성을 끊기 위해 `RoleType`을 사용한다.
 * 만약 RoleType enum 클래스를 사용하지 않는다면 회원 계정을 생성할 때 외부에서 `BoardAdminPrincipal`에 `authorities` 객체를 전달해야 한다.
 * 이 때 `RoleType`을 사용하면 Spring Security를 사용하지 않아도 된다.
 */
public enum RoleType {
    USER("ROLE_USER", "사용자"),
    MANAGER("ROLE_MANAGER", "운영자"),
    DEVELOPER("ROLE_DEVELOPER", "개발자"),
    ADMIN("ROLE_ADMIN", "관리자");

    @Getter private final String roleName;
    @Getter private final String description;
}
