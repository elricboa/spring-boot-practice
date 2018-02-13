package fun.elricboa.spring.ioc;

import lombok.Setter;

/**
 * @author elricboa on 2018/2/12.
 */
public class HelloSpringIOCServiceImpl implements HelloSpringIOCService {

    @Setter
    private String text;

    private OutputService outputService;

    @Override
    public void helloSpring() {
        outputService.output(text);
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
