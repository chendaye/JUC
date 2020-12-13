package proxy.statics.step02;

public class UserServiceProxy implements UserService{
    UserServiceImp userServiceImp;

    public UserServiceImp getUserServiceImp() {
        return userServiceImp;
    }

    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public void add() {
        log();
        userServiceImp.add();
    }

    @Override
    public void del() {
        log();
        userServiceImp.del();
    }

    @Override
    public void update() {
        log(); 
        userServiceImp.update();
    }

    @Override
    public void query() {
        userServiceImp.query();
    }
    
    public void log(){
        System.out.println("log");
    }
}
