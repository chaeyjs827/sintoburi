package com.sintoburi.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author seongnamfc
 * @package com.sintoburi.config
 * @file DataSourceConfig
 * @description
 * @date 2021/12/04
 */
@Configuration
@MapperScan(basePackages = "com.sintoburi.dao.*"
        , sqlSessionFactoryRef = "sqlSessionFactory")
@RequiredArgsConstructor
public class DataSourceConfig {

    private final String MAPPER_LOCATION = "classpath:mapper/*/*.xml";
    private final String ALIASES_PACKAGE = "com.sintoburi.*";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean

    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource orderDataSourceProxy) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(orderDataSourceProxy);
        sessionFactory.setTypeAliasesPackage(ALIASES_PACKAGE);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        SqlSessionFactory sqlSessionFactory = sessionFactory.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
}
