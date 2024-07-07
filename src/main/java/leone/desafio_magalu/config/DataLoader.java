package leone.desafio_magalu.config;

import leone.desafio_magalu.model.Channel;
import leone.desafio_magalu.model.StatusNotification;
import leone.desafio_magalu.repository.ChannelRepository;
import leone.desafio_magalu.repository.StatusNotificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusNotificationRepository statusNotificationRepository;

    public DataLoader(ChannelRepository channelRepository, StatusNotificationRepository statusNotificationRepository) {
        this.channelRepository = channelRepository;
        this.statusNotificationRepository = statusNotificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(StatusNotification.Values.values())
                .map(StatusNotification.Values::toStatusNotification)
                .forEach(statusNotificationRepository::save);
    }
}
