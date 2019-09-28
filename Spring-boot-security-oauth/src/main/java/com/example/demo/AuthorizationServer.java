package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	
	JdbcTokenStore jdbcTokenStore;
	
	/*@Bean
    public TokenStore tokenStore() {
        String insertAccessTokenSql = "insert into oauth_access_token (token_id, token, authentication_id, email, client_id, authentication, refresh_token) values (?, ?, ?, ?, ?, ?, ?)";
        String selectAccessTokensFromUserNameAndClientIdSql = "select token_id, token from oauth_access_token where email = ? and client_id = ?";
        String selectAccessTokensFromUserNameSql = "select token_id, token from oauth_access_token where email = ?";
        String selectAccessTokensFromClientIdSql = "select token_id, token from oauth_access_token where client_id = ?";
        String insertRefreshTokenSql = "insert into oauth_refresh_token (token_id, token, authentication) values (?, ?, ?)";

        JdbcTokenStore jdbcTokenStore = new JdbcTokenStore(dataSource);
        jdbcTokenStore.setInsertAccessTokenSql(insertAccessTokenSql);
        jdbcTokenStore.setSelectAccessTokensFromUserNameAndClientIdSql(selectAccessTokensFromUserNameAndClientIdSql);
        jdbcTokenStore.setSelectAccessTokensFromUserNameSql(selectAccessTokensFromUserNameSql);
        jdbcTokenStore.setSelectAccessTokensFromClientIdSql(selectAccessTokensFromClientIdSql);
        jdbcTokenStore.setInsertRefreshTokenSql(insertRefreshTokenSql);


        return jdbcTokenStore;
    }*/
	
	@Autowired
	private AuthenticationManager authenticationManager;
	public void configure(AuthorizationServerSecurityConfigurer security)
	{
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()").passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception
	{
		clients.jdbc(dataSource);

		/*clients.inMemory().withClient("scott")
		.authorizedGrantTypes("client_credentials", "password","refresh_token")
		//.authorizedGrantTypes("authorization_code")
		.authorities("ROLE_Admin")
		.scopes("read", "write", "trust")
		.secret("tiger").accessTokenValiditySeconds(10000)
		.refreshTokenValiditySeconds(50000);*/
	}
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
	{
		endpoints.authenticationManager(authenticationManager);
		endpoints.tokenStore(jdbcTokenStore).authenticationManager(authenticationManager);
	}
	
}
