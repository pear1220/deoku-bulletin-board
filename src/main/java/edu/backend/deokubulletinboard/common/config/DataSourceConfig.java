package edu.backend.deokubulletinboard.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * packageName     : edu.backend.deokubulletinboard.common.config
 * fileName        : DataSourceConfig
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
@Configuration
@MapperScan(basePackages = "edu.backend.deokubulletinboard.**.mapper")
@EnableTransactionManagement
public class DataSourceConfig {
    private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name = "h2Db")
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public HikariDataSource dataSource(){
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:sql/**/*.xml"));
//        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }

}
