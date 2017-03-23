package hu.odrin7.bga.config;

import hu.odrin7.bga.service.security.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final MongoUserDetailsService userDetailsService;
    private final TokenStore tokenStore;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OAuth2AuthorizationConfig(AuthenticationManager authenticationManager,
                                     MongoUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        tokenStore = new InMemoryTokenStore();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("ui-service")
            .secret("ui-service")
            .authorities("ROLE_TRUSTED_CLIENT")
            .authorizedGrantTypes("client_credentials", "implicit", "authorization_code", "refresh_token", "password")
            .accessTokenValiditySeconds(600)
            .scopes("openid")
            .autoApprove(true)
        .and()
            .withClient("boardGame-service")
            .secret("boardGame-service")
            .authorities("ROLE_TRUSTED_CLIENT")
            .authorizedGrantTypes("client_credentials", "implicit", "authorization_code", "refresh_token", "password")
            .scopes("server");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
            .tokenStore(tokenStore)
            .accessTokenConverter(jwtAccessTokenConverter())
            .authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
            .tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
            .checkTokenAccess("isAuthenticated()");
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray())
            .getKeyPair("test");
        converter.setKeyPair(keyPair);
        return converter;
    }
}
