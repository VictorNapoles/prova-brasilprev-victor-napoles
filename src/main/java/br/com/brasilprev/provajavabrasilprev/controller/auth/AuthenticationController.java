package br.com.brasilprev.provajavabrasilprev.controller.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.provajavabrasilprev.config.security.TokenService;
import br.com.brasilprev.provajavabrasilprev.controller.auth.dto.LoginResquestDto;
import br.com.brasilprev.provajavabrasilprev.controller.auth.dto.TokenResponseDto;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid LoginResquestDto dto){
        
        UsernamePasswordAuthenticationToken dadosLogin = dto.convert();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.createToken(authentication);                     
            return ResponseEntity.ok(new TokenResponseDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }

}