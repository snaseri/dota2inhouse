package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;


@Configuration
@PropertySource({"application.properties"})
@ComponentScan
public class BeanConfig {


    @Value("${spring.datasource.url}")
    private String jdbcURl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;



    @Value("${spring.datasource.url}")
    private String h2jdbcURl;
    @Value("${spring.datasource.username}")
    private String h2dbUsername;
    @Value("${spring.datasource.password}")
    private String h2dbPassword;







    @Autowired
    Environment env;
    @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();



        if(Arrays.asList(env.getActiveProfiles()).contains("demo")) {

            sessionFactory.setDataSource(secondgetDataSource());
            sessionFactory.setPackagesToScan(new String[]{"uk.ac.cf.cs.ons.skillsdb.skillsdb"});
        }
        else {
            sessionFactory.setDataSource(getDataSource());
            sessionFactory.setPackagesToScan(new String[]{"uk.ac.cf.cs.ons.skillsdb.skillsdb"});

        }
        return sessionFactory;
    }






    @Bean
    @ConfigurationProperties("mysql.datasource")
    @Primary
    @Profile("main")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(jdbcURl);
        dataSourceBuilder.username(dbUsername);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();

    }


    @Bean
    @Profile("demo")
    public DataSource secondgetDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(h2jdbcURl);
        dataSourceBuilder.username(h2dbUsername);
        dataSourceBuilder.password(h2dbPassword);
        return dataSourceBuilder.build();
    }

















    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "create");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
                setProperty("hibernate.show_sql", "true");
            }
        };
    }







}
