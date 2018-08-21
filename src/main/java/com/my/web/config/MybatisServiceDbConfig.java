package com.my.web.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.my.web.dao.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory3")
public class MybatisServiceDbConfig {

    @Autowired
    @Qualifier("serviceDataSource")
    private DataSource serviceDS;

    @Bean
    public SqlSessionFactory sqlSessionFactory3() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(serviceDS);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:mybatis/mapper/**/*.xml"));
        return factoryBean.getObject();

    }

    @Bean(name = "sqlSessionTemplate3")
    public SqlSessionTemplate sqlSessionTemplate3() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory3()); // 使用上面配置的Factory
        return template;
    }

    @Bean(name = "transactionManager3")
    public DataSourceTransactionManager transactionManager3() {
        return new DataSourceTransactionManager(serviceDS);
    }
}
