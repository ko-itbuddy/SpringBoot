package com.example.itbuddy.database.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User {
    String userId;
    String userEmail;
    String userPwd;
    String userSalt;
    String userInfo;
    String userPlaceInfo;
    String userPaymentInfo;
    String roles;
    Timestamp createdAt;
    Timestamp updatedAt;
    Timestamp expiredAt;
    Timestamp credentialsExpiredAt;
    Timestamp lockedAt;
}
