class User {
    private String firstName;
    private String lastName;
    private boolean authState;
    private String cookieId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAuthState(boolean authState) {
        this.authState = authState;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getAuthState() {
        return authState;
    }

    public String getCookieId() {
        return cookieId;
    }
}

interface UserBuilder {
    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAuthState();

    void setCookieId(String cookieId);

    User getUser();
}

class AuthenticatedUserBuilder implements UserBuilder {

    private User user;

    public AuthenticatedUserBuilder() {
        user = new User();
    }

    @Override
    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    @Override
    public void setAuthState() {
        user.setAuthState(true);
    }

    @Override
    public void setCookieId(String cookieId) {
        user.setCookieId(cookieId);
    }

    @Override
    public User getUser() {
        return user;
    }
}

class UnauthenticatedUserBuilder implements UserBuilder {

    private User user;

    public UnauthenticatedUserBuilder() {
        this.user = new User();
    }

    @Override
    public void setFirstName(String firstName) {
        user.setFirstName("Unauthenticated");
    }

    @Override
    public void setLastName(String lastName) {
        user.setLastName("Unauthenticated");
    }

    @Override
    public void setAuthState() {
        user.setAuthState(false);
    }

    @Override
    public void setCookieId(String cookieId) {
        user.setCookieId(cookieId);
    }

    @Override
    public User getUser() {
        return user;
    }
}

class UserManager {
    private final UserBuilder builder;

    public UserManager(UserBuilder builder) {
        this.builder = builder;
    }

    public User constructUser() {
        builder.setFirstName("John");
        builder.setLastName("Doe");
        builder.setAuthState();
        builder.setCookieId("12345");
        return builder.getUser();
    }
}

class Main {
    public static void main(String[] args) {
        UserManager manager = new UserManager(new AuthenticatedUserBuilder());
        User authenticatedUser = manager.constructUser();

        manager = new UserManager(new UnauthenticatedUserBuilder());
        User unauthenticatedUser = manager.constructUser();
    }
}
