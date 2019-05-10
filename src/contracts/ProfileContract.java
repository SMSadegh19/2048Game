package contracts;

public interface ProfileContract {
    interface Controller {
        void login(String name, String password);
        void createProfile(String name, String password);
        void changeUsername(String newName);
    }
}
