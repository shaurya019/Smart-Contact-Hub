package contact.Manager.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class Helper {
    public static String getEmailOfLoggedInUser(Authentication authentication){
        if(authentication instanceof OAuth2AuthenticationToken){
            var aOAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            var clientID = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User = (OAuth2User) authentication.getPrincipal();
            String username = "";
            if(clientID.equalsIgnoreCase("google")){
                username = oauth2User.getAttribute("email").toString();
            }else if (clientID.equalsIgnoreCase("github")){
                username = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
                        : oauth2User.getAttribute("login").toString() + "@gmail.com";
            }
            return username;
        }
        return authentication.getName();
    }
}
