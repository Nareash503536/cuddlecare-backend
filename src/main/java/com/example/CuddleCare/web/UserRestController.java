package com.example.CuddleCare.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.CuddleCare.entity.Role;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.helper.JWTHelper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static com.example.CuddleCare.constant.JWTUtil.AUTH_HEADER;
import static com.example.CuddleCare.constant.JWTUtil.SECRET;

@RestController
@CrossOrigin("*")
public class UserRestController {

    private UserService userService;

    private BabyService babyService;

    private JWTHelper jwtHelper;

    public UserRestController(UserService userService, JWTHelper jwtHelper, BabyService babyService) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
        this.babyService = babyService;
    }

    @Getter
    @Setter
    public class AuthenticationResponse {
        private boolean authenticated;
        private String phoneNumber;
    }

    @GetMapping("/users")
    public boolean checkEmailExist(){
        return true;
    }

    @GetMapping("/isValid")
    public boolean isTokenExpired(){
        return false;
    }

    @GetMapping("/refresh-token")
    public void generateNewAccessToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jwtRefreshToken = jwtHelper.extractTokenFromHeaderIfExists(request.getHeader(AUTH_HEADER));
        if (jwtRefreshToken != null) {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwtRefreshToken);
            String email = decodedJWT.getSubject();
            User user = userService.loadUserByUsername(email);
            String jwtAccessToken = jwtHelper.generateAccessToken(user.getEmail(), user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()));
            response.setContentType("application/json");
            new ObjectMapper().writeValue(response.getOutputStream(), jwtHelper.getTokensMap(jwtAccessToken, jwtRefreshToken));
        } else {
            throw new RuntimeException("Refresh token required");
        }
    }


    @GetMapping("/do")
    public boolean doSomething(){
        return true;
    }

    @PostMapping("/authenticateUser")
    public boolean authenticateUser(@RequestParam(name = "email") String email){
        userService.authenticateUser(email);
        return true;
    }

    @PostMapping("/isAuthenticated")
    public ResponseEntity<AuthenticationResponse> isAuthenticated(@RequestParam(name = "email") String email){
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        User user = userService.loadUserByEmail(email);
        boolean authenticatedStatus = user.isAuthenticated();
        String phoneNumber = null;
        if(!authenticatedStatus)
            phoneNumber = user.getContactNumber();
        authenticationResponse.setAuthenticated(authenticatedStatus);
        authenticationResponse.setPhoneNumber(phoneNumber);
        return ResponseEntity.ok(authenticationResponse);
    }

    @PostMapping("/setAuthenticated")
    public User setAuthenticated(@RequestParam(name = "email") String email){
        User user = userService.loadUserByEmail(email);
        user.setAuthenticated(true);
        return userService.updateUser(user);
    }
}
