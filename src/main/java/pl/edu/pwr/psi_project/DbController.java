package pl.edu.pwr.psi_project;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private HikariDataSource dataSource;

    @GetMapping("/pool/name")
    public String getPoolName() {
        return dataSource.getHikariConfigMXBean().getPoolName()+" Sem executar o maven de novo";
    }

    @GetMapping("/pool/size")
    public String getPoolSize() {
        return String.valueOf(dataSource.getHikariConfigMXBean().getMaximumPoolSize());
    }
}
