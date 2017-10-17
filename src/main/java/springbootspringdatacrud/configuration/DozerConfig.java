package springbootspringdatacrud.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozerConfig {
    private static final String PACKAGE_TO_SCAN="springbootspringdatacrud.mapping";
    @Bean
    public DozerBeanMapper mapper() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        final DozerBeanMapper mapper = new DozerBeanMapper();
        final List<BeanMappingBuilder> registeredMapping = getRegisteredMapping();
        registeredMapping.forEach(mapper::addMapping);
        return mapper;
    }

    private List<BeanMappingBuilder> getRegisteredMapping() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(BeanMappingBuilder.class));
        final List<BeanMappingBuilder> customMapping = new ArrayList<>();
        for(final BeanDefinition bd : scanner.findCandidateComponents(PACKAGE_TO_SCAN)){
            customMapping.add((BeanMappingBuilder) Class.forName(bd.getBeanClassName()).newInstance());
        }
        return customMapping;
    }
}

