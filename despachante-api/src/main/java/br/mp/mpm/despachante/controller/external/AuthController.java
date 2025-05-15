package br.mp.mpm.despachante.controller.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpm.acasisclient.security.token.TokenService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/obterToken")
@Api(value = "authController")
@CrossOrigin
public class AuthController {

    private TokenService tokenService;
    
    @Autowired	
	public void setTokenService(@Lazy TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	public TokenService getTokenService() {
		return tokenService;
	}
    
	@PostMapping
	public ResponseEntity<String> obterToken(@RequestParam(required = true) String usuario, 
			@RequestParam(required = true) String senha) {
		String entity = getTokenService().getRedeMPMToken(usuario, senha);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		}
		return ResponseEntity.notFound().build();
	}
	
}
