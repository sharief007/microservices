package app.peers.routerservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
   @Override
   public void registerStompEndpoints(StompEndpointRegistry registry) {
       registry.addEndpoint("/ws")
               .setAllowedOrigins("http://localhost:8080","http://localhost:8082")
               .setHandshakeHandler(new DefaultHandshakeHandler())
               .withSockJS()
               .setHeartbeatTime(1000)
               .setWebSocketEnabled(true);
   }

   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry) {
       registry.setApplicationDestinationPrefixes("/spring")
               .enableStompBrokerRelay("/topic","/queue")
               .setRelayHost("localhost")
               .setRelayPort(61613)
               .setClientLogin("guest")
               .setClientPasscode("guest");
   }
}
