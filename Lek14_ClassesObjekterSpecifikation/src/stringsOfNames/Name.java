package stringsOfNames;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String _firstName, String _middleName, String _lastName) {
        firstName = _firstName;
        middleName = _middleName;
        lastName = _lastName;
    }

    public Name(String _firstName, String _lastName) {
        firstName = _firstName;
        lastName = _lastName;
    }

    public void setFirstName(String _firstName){
        firstName = _firstName;
    }

    public String getFirstName() { return firstName; }

    public void setMiddleName(String _middleName) {
        middleName = _middleName;
    }

    public String getMiddleName() { return middleName; }

    public void setLastName(String _lastName) {
        lastName = _lastName;
    }

    public String getLastName() { return lastName; }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();

        fullName.append(firstName).append(" ");

        if (middleName!=null && !middleName.isEmpty()) {
            fullName.append(middleName).append(" ");
            fullName.append(lastName);
        }
        return fullName.toString();
    }

    public String getInit() {
        StringBuilder initials = new StringBuilder();

        initials.append(firstName.charAt(0));

        if (middleName != null && !middleName.isEmpty()){
            initials.append(middleName.charAt(0));
        }

        initials.append(lastName.charAt(0));

        return initials.toString();
    }

    public String getUserName() {
        StringBuilder username = new StringBuilder();

        username.append(firstName.toUpperCase(), 0, 2);

        if (middleName != null && !middleName.isEmpty()) {
            username.append(middleName.length());
        } else {
            username.append(0);
        }

        username.append(lastName.toLowerCase().substring(lastName.length() - 2));

        return username.toString();
    }

    public String getCryptoInit(int count) {
        StringBuilder encryptedInitials = new StringBuilder();
        for (int i = 0; i < getInit().length(); i++) {
            char ch = getInit().charAt(i);
            char encryptedChar = (char) ((ch - 'A' + count) % 26 + 'A');
            encryptedInitials.append(encryptedChar);
        }

        return encryptedInitials.toString();
    }

    public String toString() {
        return (middleName != null ) ? firstName + " " + middleName + " " + lastName
                : firstName + " " + lastName;

    }

}
