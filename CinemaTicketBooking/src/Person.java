abstract  class Person{
    protected String id;
    protected String username;
    protected String password;

    public Person(String inputId, String inputUsername, String inputPassowrd){
        this.id = inputId;
        this.username = inputUsername;
        this.password = inputPassowrd;
    }

    public boolean  checkPassword(String inputPassword){
        return this.password.equals((inputPassword));
    }

    public String getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassoword(){
        return password;
    }
}
