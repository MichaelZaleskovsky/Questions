package com.questions.autorizationserver.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class JWTTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> accessInfo = new HashMap<>();
		String userId = "dummy id";
		accessInfo.put("userId", userId);
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(accessInfo);
		return accessToken;
	}

}
