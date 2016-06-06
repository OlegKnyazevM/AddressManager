package ua.levelup.AddressManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Class {@link ConfigurationForTitles} tiles configuration
 *
 * @author Knyazev Oleg
 * @version 1.0
 * @since 20.10.15
 */

@Configuration
public class ConfigurationForTitles {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setUseMutableTilesContainer(true);

        configurer.setDefinitions(new String[]{"/WEB-INF/pages/tiles.xml"});
        configurer.setCheckRefresh(true);
        return configurer;
    }

    /**
     * Introduce a Tiles view resolver, this is a convenience implementation that extends URLBasedViewResolver.
     *
     * @return tiles view resolver
     */
    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
}
