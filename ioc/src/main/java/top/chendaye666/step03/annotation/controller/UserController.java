package top.chendaye666.step03.annotation.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller // 等价 Compnent
@Scope("singleton")
public class UserController {
}
